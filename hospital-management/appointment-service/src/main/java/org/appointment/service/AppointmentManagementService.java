package org.appointment.service;

import org.appointment.dto.AppointmentRequest;
import org.appointment.dto.AppointmentResponse;

public interface AppointmentManagementService {
  public AppointmentResponse makeAppointment(AppointmentRequest appointmentRequest);

  public AppointmentResponse searchAppointment(String patientId);

  public AppointmentResponse deleteAppointment(String patientId);

  public AppointmentResponse searchAppointmentByAppointmentId(String appointmentId);
}
