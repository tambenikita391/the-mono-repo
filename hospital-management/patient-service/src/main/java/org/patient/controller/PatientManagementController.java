package org.patient.controller;

import org.patient.dto.PatientRequest;
import org.patient.dto.PatientResponse;
import org.patient.service.PatientManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class PatientManagementController {

  @Autowired PatientManagementServiceImpl patientManagementServiceImpl;

  @PostMapping(
      path = "/api/v1/patient/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public PatientResponse addPatient(@Valid @RequestBody PatientRequest request) {
    return patientManagementServiceImpl.addPatientDetails(request);
  }

  @GetMapping(
      path = "/api/v1/patient/{patientId}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public PatientResponse searchPatientById(@PathVariable String patientId) {
    return patientManagementServiceImpl.searchPatientById(patientId);
  }

  @PostMapping(
      path = "/api/v1/patient/{patientId}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public PatientResponse updatePatient(
      @PathVariable String patientId, @RequestBody PatientRequest request) {
    return patientManagementServiceImpl.updatePatientDetails(patientId, request);
  }

  @DeleteMapping(
      path = "/api/v1/patient/{patientId}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public String deletePatient(@PathVariable String patientId) {
    return patientManagementServiceImpl.deletePatientDetails(patientId);
  }
}
