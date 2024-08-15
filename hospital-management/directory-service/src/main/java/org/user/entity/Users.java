package org.user.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@Component
public class Users {
  @Id
  @GeneratedValue(generator = "custom-id")
  @GenericGenerator(name = "custom-id", strategy = "org.user.common.RandomStringGenerator")
  @Column
  private String userId;

  @Column private String userName;
  @Column private String email;
  @Column private String mobileNumber;
  @Column private String role;
  @Column private String password;
  @Column private String confirmPassword;
  @Column private String aesKey;

  public String getAesKey() {
    return aesKey;
  }

  public Users setAesKey(String aesKey) {
    this.aesKey = aesKey;
    return this;
  }

  public static Users getInstance() {
    return new Users();
  }

  public String getUserId() {
    return userId;
  }

  public Users setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public String getUserName() {
    return userName;
  }

  public Users setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Users setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public Users setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  public String getRole() {
    return role;
  }

  public Users setRole(String role) {
    this.role = role;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public Users setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public Users setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
    return this;
  }
}
