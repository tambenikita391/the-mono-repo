package org.patient.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient {

  @Id
  @GeneratedValue(generator = "custom-id")
  @GenericGenerator(name = "custom-id", strategy = "org.patient.common.RandomStringGenerator")
  @Column(nullable = false, insertable = false, updatable = false)
  
  private String patientId;

  @Column(nullable = false)
  private String patientNameInEnglish;

  @Column(nullable = false)
  private String patientNameInMarathi;

  @Column(nullable = false)
  private String mobileNumber;

  @Column(nullable = false)
  private String gender;

  @Column(nullable = false)
  private String birthDate;

  @Column(nullable = false)
  private String firstExaminationDate;

  @Column(nullable = false)
  private String address;

  public static Patient getInstance() {
    return new Patient();
  }

  public String getPatientId() {
    return patientId;
  }

  public Patient setPatientId(String patientId) {
    this.patientId = patientId;
    return this;
  }

  public String getPatientNameInEnglish() {
    return patientNameInEnglish;
  }

  public Patient setPatientNameInEnglish(String patientNameInEnglish) {
    this.patientNameInEnglish = patientNameInEnglish;
    return this;
  }

  public String getPatientNameInMarathi() {
    return patientNameInMarathi;
  }

  public Patient setPatientNameInMarathi(String patientNameInMarathi) {
    this.patientNameInMarathi = patientNameInMarathi;
    return this;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public Patient setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public Patient setBirthDate(String birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  public String getFirstExaminationDate() {
    return firstExaminationDate;
  }

  public Patient setFirstExaminationDate(String firstExaminationDate) {
    this.firstExaminationDate = firstExaminationDate;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Patient setAddress(String address) {
    this.address = address;
    return this;
  }

  public String getGender() {
    return gender;
  }

  public Patient setGender(String gender) {
    this.gender = gender;
    return this;
  }
  public enum Status{
	  DELETED,
	  ACTIVE;
  }
}
