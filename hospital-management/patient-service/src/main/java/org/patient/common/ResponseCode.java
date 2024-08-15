package org.patient.common;

public enum ResponseCode {
  ADD_PATIENT_SUCCESS("Success", "Patient successfully added"),
  ADD_PATIENT_FAILURE("Fail", "Patient not added"),
  SEARCH_PATIENT_SUCCESS("Success", "Patient details found"),
  SEARCH_PATIENT_FAILURE("Fail", "Patient details not found"),
  UPDATE_PATIENT_SUCCESS("Success", "Patient details updated successfully"),
  UPDATE_PATIENT_FAILURE("Fail", "Patient details not updated");

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
