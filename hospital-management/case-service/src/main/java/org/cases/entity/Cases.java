package org.cases.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cases {
  @Id
  @GeneratedValue(generator = "custom-id")
  @GenericGenerator(name = "custom-id", strategy = "org.cases.common.CustomIdGenerator")
  @Column
  private String patientId;

  @Column private String patientNameInEnglish;

  @Column private String patientNameInMarathi;

  @GeneratedValue(generator = "custom-id")
  @GenericGenerator(name = "custom-id", strategy = "org.cases.common.RandomStringGenerator")
  @Column
  private String caseId;

  @Column private String examinationDate;

  @Column private String symptoms;

  @Column private String prescription;

  public static Cases getInstanace() {
    return new Cases();
  }

  public String getPatientId() {
    return patientId;
  }

  public Cases setPatientId(String patientId) {
    this.patientId = patientId;
    return this;
  }

  public String getPatientNameInEnglish() {
    return patientNameInEnglish;
  }

  public Cases setPatientNameInEnglish(String patientNameInEnglish) {
    this.patientNameInEnglish = patientNameInEnglish;
    return this;
  }

  public String getPatientNameInMarathi() {
    return patientNameInMarathi;
  }

  public Cases setPatientNameInMarathi(String patientNameInMarathi) {
    this.patientNameInMarathi = patientNameInMarathi;
    return this;
  }

  public String getExaminationDate() {
    return examinationDate;
  }

  public Cases setExaminationDate(String examinationDate) {
    this.examinationDate = examinationDate;
    return this;
  }

  public String getSymptoms() {
    return symptoms;
  }

  public Cases setSymptoms(String symptoms) {
    this.symptoms = symptoms;
    return this;
  }

  public String getPrescription() {
    return prescription;
  }

  public Cases setPrescription(String prescription) {
    this.prescription = prescription;
    return this;
  }

  public String getCaseId() {
    return caseId;
  }

  public Cases setCaseId(String string) {
    this.caseId = string;
    return this;
  }

  @Enumerated(EnumType.STRING)
  private Status status;

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public enum Status {
    DELETED
  }
}
