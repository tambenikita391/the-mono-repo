package org.patient.controller;

import jakarta.validation.Valid;
import org.patient.dto.PatientRequest;
import org.patient.dto.PatientResponse;
import org.patient.service.PatientMnagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientManagementController {

  @Autowired PatientMnagementServiceImpl patientManagementServiceImpl;

  @PostMapping("/add/patient")
  public PatientResponse addPatientData(@Valid @RequestBody PatientRequest request) {
    return patientManagementServiceImpl.addPatients(request);
  }

  @GetMapping("/search/patient/{name}")
  public PatientResponse searchPatientData(@PathVariable String name) {
    return patientManagementServiceImpl.searchPatients(name);
  }

  @PostMapping("/edit/patient/{patientId}")
  public PatientResponse editPatientData(
      @RequestBody PatientRequest request, @PathVariable String patientId) {
    return patientManagementServiceImpl.editPatients(request, patientId);
  }

  @DeleteMapping("/delete/patient/{name}")
  public PatientResponse deletePatientData(@PathVariable String name) {
    return patientManagementServiceImpl.deletePatient(name);
  }
}
