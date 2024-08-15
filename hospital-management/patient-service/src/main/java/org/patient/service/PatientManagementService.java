package org.patient.service;

import java.util.List;

import org.patient.dto.PatientRequest;
import org.patient.dto.PatientResponse;
import org.patient.entity.Patient;

public interface PatientManagementService {
  public PatientResponse addPatientDetails(PatientRequest patientRequest);

  public PatientResponse searchPatientById(String patientId);

  public PatientResponse updatePatientDetails(String patientId, PatientRequest patientRequest);

  public String deletePatientDetails(String patientId);

}
