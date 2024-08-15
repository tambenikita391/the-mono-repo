package org.user.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginRequest {
  private String userName;
  private String mobileNumber;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

public String getMobileNumber() {
return mobileNumber;}

public void setMobileNumber(String mobileNumber) {
this.mobileNumber = mobileNumber;}

  
}
