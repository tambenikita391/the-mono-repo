package org.cases.common;

public enum ResponseCode {
  ADD_CASES_SUCCESS("Success", "Cases added successfully"),
  SEARCH_CASES_SUCCESS("Success", "Case found"),
  SEARCH_CASES_FAILURE("Fail", "Case not found"),
  UPDATE_CASES_SUCCESS("success", "Case updated"),
  UPDATE_CASES_FAILURE("Fail", "Case not updated"),
  DELETE_CASES_SUCCESS("success", "Case deleted"),
  DELETE_CASES_FAILURE("Fail", "Case not deleted");

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
