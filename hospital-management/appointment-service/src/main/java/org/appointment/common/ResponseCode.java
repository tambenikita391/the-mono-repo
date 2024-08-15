package org.appointment.common;

public enum ResponseCode {
  ADD_APPOINTMENT_SUCCESS("Success", "Appointment added"),
  SEARCH_APPOINTMENT_SUCCESS("Success", "Appointment found"),
  SEARCH_APPOINTMENT_FAILURE("Fail", "Appointment is not found"),
  DELETE_APPOINTMENT_SUCCESS("Success", "Appointment deleted"),
  DELETE_APPOINTMENT_FAILURE("Fail", "Appointment is not deleted");

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
