package org.patient.common;

public enum ResponseCode {
  ADD_PATIENT_SUCCESS("200", "Patient details addedd successfully"),
  ADD_PATIENT_FAIL("404", "Patient data not aadded"),
  SEARCH_PATIENT_SUCCESS("200", "Patient details found successfully"),
  SEARCH_PATIENT_FAIL("404", "Patient details not found"),
  UPDATE_PATIENT_SUCCESS("200", "Patient details updated successfully"),
  UPDATE_PATIENT_FAIL("404", "Patient details not updated"),
  DELETE_PATIENT_SUCCESS("200", "Patient details deleted successfully"),
  DELETE_PATIENT_FAIL("404", "Patient details not deleted");

  private final String status;
  private final String message;

  private ResponseCode(String status, String message) {
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
