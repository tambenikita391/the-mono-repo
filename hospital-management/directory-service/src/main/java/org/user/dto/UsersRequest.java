package org.user.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Pattern;

@Component
public class UsersRequest {

  @Pattern(regexp = "[A-Za-z]{2,50}")
  private String userName;

  @Pattern(regexp = "[a-zA-Z0-9]+[@][a-z]+[/.][a-z]{2,3}")
  private String email;

  @Pattern(regexp = "[789][0-9]{9}")
  private String mobileNumber;

  private String role;

  @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-z])(?=.*[@#$%]).{8,20}")
  private String password;

  @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-z])(?=.*[@#$%]).{8,20}")
  private String confirmPassword;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }
}
