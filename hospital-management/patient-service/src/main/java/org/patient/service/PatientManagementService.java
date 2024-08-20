package org.patient.service;

import org.patient.dto.PatientRequest;
import org.patient.dto.PatientResponse;

public interface PatientManagementService {
  public PatientResponse addPatients(PatientRequest request);

  public PatientResponse searchPatients(String patientName);

  public PatientResponse editPatients(PatientRequest request, String patientId);

  public PatientResponse deletePatient(String patientId);
}
