package org.user.common;

public enum ResponseCode {
  ADD_USER_SUCCESS("Success", "User details added successfully"),
  SEARCH_USER_FAIL("Fail", "User not found"),
  SEARCH_USER_SUCCESS("Success", "User found successfully"),
  UPDATE_USER_FAIL("Fail", "User not updated"),
  UPDATE_USER_SUCCESS("Success", "User details updated successfully");

  private final String status;
  private final String message;

  ResponseCode(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}
