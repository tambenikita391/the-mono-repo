package org.patient.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient {
  @Id @Column private String patientId;

  @Column private String patientName;
  @Column private String address;
  @Column private String mobileNumber;
  @Column private String gender;
  @Column private String age;

  public enum Status {
    ACTIVE,
    DELETED;
  }

  @Enumerated(EnumType.STRING)
  private Status status;

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

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

  public String getPatientName() {
    return patientName;
  }

  public Patient setPatientName(String patientName) {
    this.patientName = patientName;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Patient setAddress(String address) {
    this.address = address;
    return this;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public Patient setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  public String getGender() {
    return gender;
  }

  public Patient setGender(String gender) {
    this.gender = gender;
    return this;
  }

  public String getAge() {
    return age;
  }

  public Patient setAge(String age) {
    this.age = age;
    return this;
  }
}
