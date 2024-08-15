package org.user.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.user.common.RandomStringGenerator;
import org.user.common.ResponseCode;
import org.user.dto.UsersRequest;
import org.user.dto.UsersResponse;
import org.user.entity.Users;
import org.user.repo.UsersRepository;

@Service
@Component
public class UsersManagementServiceImpl {
  @Autowired UsersRepository usersRepo;
  @Autowired UsersRequest usersRequest;
  @Autowired UsersResponse usersResponse;

  public UsersResponse addUser(UsersRequest usersRequest) {

    String tempKey = generateAESKey();
    Users users =
        Users.getInstance()
            .setUserName(usersRequest.getUserName())
            .setEmail(usersRequest.getEmail())
            .setMobileNumber(usersRequest.getMobileNumber())
            .setRole(usersRequest.getRole())
            .setPassword(encryptAES(usersRequest.getPassword(), tempKey))
            .setConfirmPassword(encryptAES(usersRequest.getConfirmPassword(), tempKey))
            .setAesKey(tempKey)
            .setUserId("USR" + RandomStringGenerator.generateRandomString(5));

    tempKey = "";

    try {
      users = usersRepo.save(users);
    } catch (Exception e) {
      e.printStackTrace();
    }
    usersResponse.setStatus(ResponseCode.ADD_USER_SUCCESS.getStatus());
    usersResponse.setMessage(ResponseCode.ADD_USER_SUCCESS.getMessage());
    usersResponse.setUserId(users.getUserId());

    return usersResponse;
  }

  public UsersResponse searchUser(String userId) {
    List<Users> receivedData = usersRepo.findByUserId(userId);
    if (receivedData.isEmpty() || receivedData == null) {
      usersResponse.setStatus(ResponseCode.SEARCH_USER_FAIL.getStatus());
      usersResponse.setMessage(ResponseCode.SEARCH_USER_FAIL.getMessage());
    } else {
      Users users = receivedData.get(0);
      usersResponse.setUserName(users.getUserName());
      usersResponse.setEmail(users.getEmail());
      usersResponse.setMobileNumber(users.getMobileNumber());
      usersResponse.setRole(users.getRole());
      usersResponse.setPassword(decryptAES(users.getPassword(), users.getAesKey()));
      usersResponse.setConfirmPassword(decryptAES(users.getConfirmPassword(), users.getAesKey()));
      usersResponse.setStatus(ResponseCode.SEARCH_USER_SUCCESS.getStatus());
      usersResponse.setMessage(ResponseCode.SEARCH_USER_SUCCESS.getMessage());
    }
    return usersResponse;
  }

  public String deleteUser(String userId) {
    usersRepo.deleteByUserId(userId);
    return "User of userId " + userId + "  id deleted";
  }

  private String encryptAES(String input, String key) {
    try {
      Cipher cipher = Cipher.getInstance("AES");
      SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");
      cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
      byte[] encryptedBytes = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
      return Base64.getEncoder().encodeToString(encryptedBytes);
    } catch (Exception e) {
      throw new RuntimeException("Error encrypting with AES", e);
    }
  }

  public UsersResponse updateUser(String userId, UsersRequest usersRequest) {
    List<Users> usersData = usersRepo.findByUserId(userId);
    if (usersData.isEmpty() || usersData == null) {
      usersResponse.setStatus(ResponseCode.UPDATE_USER_FAIL.getStatus());
      usersResponse.setMessage(ResponseCode.UPDATE_USER_FAIL.getMessage());
    } else {
      String tempKey = generateAESKey();

      Users users =
          Users.getInstance()
              .setUserName(usersRequest.getUserName())
              .setEmail(usersRequest.getEmail())
              .setMobileNumber(usersRequest.getMobileNumber())
              .setRole(usersRequest.getRole())
              .setPassword(encryptAES(usersRequest.getPassword(), tempKey))
              .setConfirmPassword(encryptAES(usersRequest.getConfirmPassword(), tempKey))
              .setAesKey(tempKey)
              .setUserId("USR" + RandomStringGenerator.generateRandomString(5));

      tempKey = "";

      try {
        users = usersRepo.save(users);
      } catch (Exception e) {
        e.printStackTrace();
      }
      usersResponse.setStatus(ResponseCode.UPDATE_USER_SUCCESS.getStatus());
      usersResponse.setMessage(ResponseCode.UPDATE_USER_SUCCESS.getMessage());
      usersResponse.setUserId(users.getUserId());
    }
    return usersResponse;
  }

  private String generateAESKey() {
    try {
      KeyGenerator keyGen = KeyGenerator.getInstance("AES");
      keyGen.init(256);
      SecretKey secretKey = keyGen.generateKey();
      byte[] encodedKey = secretKey.getEncoded();
      return Base64.getEncoder().encodeToString(encodedKey);
    } catch (Exception e) {
      throw new RuntimeException("Error generating AES key", e);
    }
  }

  public String decryptAES(String encryptedInput, String key) {
    try {
      Cipher cipher = Cipher.getInstance("AES");
      SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");
      cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
      byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedInput));
      return new String(decryptedBytes, StandardCharsets.UTF_8);
    } catch (Exception e) {
      throw new RuntimeException("Error decrypting with AES", e);
    }
  }
}
