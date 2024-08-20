package org.patient.service;

import java.util.List;
import org.patient.common.RandomStringGenerator;
import org.patient.common.ResponseCode;
import org.patient.dto.PatientRequest;
import org.patient.dto.PatientResponse;
import org.patient.entity.Patient;
import org.patient.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class PatientMnagementServiceImpl implements PatientManagementService {
  @Autowired PatientRepository patientRepo;

  @Autowired PatientResponse patientResponse;

  public PatientResponse addPatients(PatientRequest request) {
    Patient patientEntity = new Patient();
    patientEntity.setPatientName(request.getPatientName());
    patientEntity.setMobileNumber(request.getMobileNumber());
    patientEntity.setAddress(request.getAddress());
    patientEntity.setGender(request.getGender());
    patientEntity.setAge(request.getAge());
    patientEntity.setPatientId("PAT" + RandomStringGenerator.generateRandomString(5));
    patientEntity.setStatus(Patient.Status.ACTIVE);

    patientRepo.save(patientEntity);

    patientResponse.setStatus(ResponseCode.ADD_PATIENT_SUCCESS.getStatus());
    patientResponse.setMessage(ResponseCode.ADD_PATIENT_SUCCESS.getMessage());

    return patientResponse;
  }

  @Override
  public PatientResponse searchPatients(String patientName) {
    List<Patient> patientData = patientRepo.findByPatientName(patientName);
    if (patientData.isEmpty() || patientData == null) {
      patientResponse.setStatus(ResponseCode.SEARCH_PATIENT_FAIL.getStatus());
      patientResponse.setMessage(ResponseCode.SEARCH_PATIENT_FAIL.getMessage());
    } else {
      Patient patient = patientData.get(0);
      patientResponse.setPatientName(patient.getPatientName());
      patientResponse.setMobileNumber(patient.getMobileNumber());
      patientResponse.setGender(patient.getGender());
      patientResponse.setAge(patient.getAge());
      patientResponse.setAddress(patient.getAddress());

      patientResponse.setStatus(ResponseCode.SEARCH_PATIENT_SUCCESS.getStatus());
      patientResponse.setMessage(ResponseCode.SEARCH_PATIENT_SUCCESS.getMessage());
    }

    return patientResponse;
  }

  public PatientResponse editPatients(PatientRequest request, String patientId) {
    List<Patient> patientData = patientRepo.findByPatientId(patientId);
    if (patientData.isEmpty() || patientData == null) {
      patientResponse.setStatus(ResponseCode.UPDATE_PATIENT_FAIL.getStatus());
      patientResponse.setMessage(ResponseCode.UPDATE_PATIENT_FAIL.getMessage());
    } else {
      Patient patient = new Patient();
      patient.setPatientName(request.getPatientName());
      patient.setMobileNumber(request.getMobileNumber());
      patient.setGender(request.getGender());
      patient.setAge(request.getAge());
      patient.setAddress(request.getAddress());
      patient.setStatus(Patient.Status.ACTIVE);

      patient = patientRepo.save(patient);

      patientResponse.setStatus(ResponseCode.UPDATE_PATIENT_SUCCESS.getStatus());
      patientResponse.setMessage(ResponseCode.UPDATE_PATIENT_SUCCESS.getMessage());
    }
    return patientResponse;
  }

  public PatientResponse deletePatient(String patientId) {
    List<Patient> patientData = patientRepo.findByPatientId(patientId);
    if (patientData.isEmpty()) {
      patientResponse.setStatus(ResponseCode.DELETE_PATIENT_FAIL.getStatus());
      patientResponse.setMessage(ResponseCode.DELETE_PATIENT_FAIL.getMessage());
    } else {
      Patient patient = patientData.get(0);
      patient.setStatus(Patient.Status.DELETED);
      patientRepo.save(patient);
    }
    return patientResponse;
  }
}
