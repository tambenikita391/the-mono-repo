package org.hospital.dto;

import org.springframework.stereotype.Component;

@Component
public class CaseRequest {

  private String patientNameInEnglish;

  private String patientNameInMarathi;
  private String caseNumber;
  private String patientId;

  public String getCaseNumber() {
    return caseNumber;
  }

  public void setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
  }

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  private String examinationDate;
  private String symptoms;
  private String prescription;

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

  public String getExaminationDate() {
    return examinationDate;
  }

  public void setExaminationDate(String examinationDate) {
    this.examinationDate = examinationDate;
  }

  public String getSymptoms() {
    return symptoms;
  }

  public void setSymptoms(String symptoms) {
    this.symptoms = symptoms;
  }

  public String getPrescription() {
    return prescription;
  }

  public void setPrescription(String prescription) {
    this.prescription = prescription;
  }
}
