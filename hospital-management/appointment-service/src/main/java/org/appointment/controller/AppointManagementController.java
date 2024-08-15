package org.appointment.controller;

import org.appointment.dto.AppointmentRequest;
import org.appointment.dto.AppointmentResponse;
import org.appointment.service.AppointmentManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class AppointManagementController {
  @Autowired AppointmentManagementServiceImpl appointmentManagementServiceImpl;

  @PostMapping(
      path = "/api/v1/appointment/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public AppointmentResponse makeAppointment(@Valid @RequestBody AppointmentRequest request) {
    return appointmentManagementServiceImpl.makeAppointment(request);
  }

  @GetMapping(
      path = "/api/v1/appointment/patient/{patientId}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public AppointmentResponse searchAppointments(@PathVariable String patientId) {
    return appointmentManagementServiceImpl.searchAppointment(patientId);
  }

  @GetMapping(
      path = "/api/v1/appointment/{appointmentId}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public AppointmentResponse searchAppointmentByAppointmentId(@PathVariable String appointmentId) {
    return appointmentManagementServiceImpl.searchAppointmentByAppointmentId(appointmentId);
  }

  @DeleteMapping(
      path = "/api/v1/appointment/{appointmentId}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public AppointmentResponse deleteAppointments(@PathVariable String appointmentId) {
    return appointmentManagementServiceImpl.deleteAppointment(appointmentId);
  }
}
