package org.user.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.user.dto.LoginRequest;
import org.user.dto.LoginResponse;
import org.user.entity.Users;
import org.user.repo.UsersRepository;

@Service
@Component
public class LoginServiceImpl implements LoginService {

  @Autowired UsersRepository repo;

  public LoginResponse validateUser(LoginRequest request) {
    LoginResponse response = new LoginResponse();

    List<Users> user =
        repo.findByUserNameAndMobileNumber(request.getUserName(), request.getMobileNumber());

    if (user.size() == 1) {
      response.setStatus("Success");
      response.setMessage("Login successful ");

    } else {
      response.setStatus("Fail");
      response.setMessage("Login failed ");
    }
    return response;
  }
}
