package org.patient.service;

import java.util.List;
import java.util.Optional;

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
public class PatientManagementServiceImpl implements PatientManagementService {
  @Autowired PatientRepository patientRepo;

  @Autowired PatientResponse patientRespone;

  @Autowired PatientRequest patientRequest;

  public PatientResponse addPatientDetails(PatientRequest patientRequest) {
    Patient patient =
        Patient.getInstance()
                .setPatientNameInEnglish(patientRequest.getPatientNameInEnglish())
                .setPatientNameInMarathi(patientRequest.getPatientNameInMarathi())
                .setMobileNumber(patientRequest.getMobileNumber().trim())
                .setGender(patientRequest.getGender())
                .setBirthDate(patientRequest.getBirthDate())
                .setFirstExaminationDate(patientRequest.getFirstExaminationDate())
                .setAddress(patientRequest.getAddress())
                .setPatientId("PAT"
                        + RandomStringGenerator.generateRandomString(5));
    try {
      patient = patientRepo.save(patient);
    } catch (Exception e) {
      e.printStackTrace();
    }
    patientRespone.setPatientId(patient.getPatientId());
    patientRespone.setStatus(ResponseCode.ADD_PATIENT_SUCCESS.getStatus());
    patientRespone.setMessage(ResponseCode.ADD_PATIENT_SUCCESS.getMessage());
    return patientRespone;
  }

  public PatientResponse searchPatientById(String patientId) {
    Optional<Patient> patient = patientRepo.findByPatientId(patientId);
    if (patient == null) {
      patientRespone.setStatus(ResponseCode.SEARCH_PATIENT_FAILURE.getStatus());
      patientRespone.setMessage(ResponseCode.SEARCH_PATIENT_FAILURE.getMessage());
    } else {
      Patient patientDetails = patient.get();
      patientRespone.setPatientNameInEnglish(patientDetails.getPatientNameInEnglish());
      patientRespone.setPatientNameInMarathi(patientDetails.getPatientNameInMarathi());
      patientRespone.setMobileNumber(patientDetails.getMobileNumber());
      patientRespone.setGender(patientDetails.getGender());
      patientRespone.setBirthDate(patientDetails.getBirthDate());
      patientRespone.setFirstExaminationDate(patientDetails.getFirstExaminationDate());
      patientRespone.setAddress(patientDetails.getAddress());

      patientRespone.setStatus(ResponseCode.SEARCH_PATIENT_SUCCESS.getStatus());
      patientRespone.setMessage(ResponseCode.SEARCH_PATIENT_SUCCESS.getMessage());
    }
    return patientRespone;
  }

  public PatientResponse updatePatientDetails(String patientId, PatientRequest patientRequest) {
    Optional<Patient> receivedPatient = patientRepo.findByPatientId(patientId);
    if (receivedPatient == null) {
      patientRespone.setStatus(ResponseCode.UPDATE_PATIENT_FAILURE.getStatus());
      patientRespone.setMessage(ResponseCode.UPDATE_PATIENT_FAILURE.getMessage());
    } else {
      Patient patient =
          Patient.getInstance()
              .setPatientNameInEnglish(patientRequest.getPatientNameInEnglish())
              .setPatientNameInMarathi(patientRequest.getPatientNameInMarathi())
              .setMobileNumber(patientRequest.getMobileNumber())
              .setGender(patientRequest.getGender())
              .setBirthDate(patientRequest.getBirthDate())
              .setFirstExaminationDate(patientRequest.getFirstExaminationDate())
              .setAddress(patientRequest.getAddress());
      try {
        patient = patientRepo.save(patient);
      } catch (Exception e) {
        e.printStackTrace();
      }
      patientRespone.setStatus(ResponseCode.UPDATE_PATIENT_SUCCESS.getStatus());
      patientRespone.setMessage(ResponseCode.UPDATE_PATIENT_SUCCESS.getMessage());
    }

    return patientRespone;
  }

  public String deletePatientDetails(String patientId) {
    patientRepo.deleteByPatientId(patientId);
    return "Patient " + "of ID -" + patientId + "  is deleted";
  }
}
