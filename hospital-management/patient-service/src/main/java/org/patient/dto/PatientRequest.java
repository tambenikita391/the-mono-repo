package org.patient.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Pattern;

@Component
public class PatientRequest {

  @Pattern(regexp = "[A-Za-z]{2,40}")
  private String patientNameInEnglish;

  private String patientNameInMarathi;

  @Pattern(regexp = "[789][0-9]{9}")
  private String mobileNumber;
  private String gender;
  private String birthDate;
  private String firstExaminationDate;

  @Pattern(regexp = "[A-Za-z]{2,25}")
  private String address;

  public String getPatientNameInEnglish() {
    return patientNameInEnglish;
  }

  public void setPatientNameInEnglish(String patientNameInEnglish) {
    this.patientNameInEnglish = patientNameInEnglish;
  }

  public String getPatientNameInMarathi() {
    return patientNameInMarathi;
  }

  public void setPatientNameInMarathi(String patientNameInMarathi) {
    this.patientNameInMarathi = patientNameInMarathi;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getFirstExaminationDate() {
    return firstExaminationDate;
  }

  public void setFirstExaminationDate(String firstExaminationDate) {
    this.firstExaminationDate = firstExaminationDate;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}
