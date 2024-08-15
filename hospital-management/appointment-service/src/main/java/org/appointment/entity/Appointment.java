package org.appointment.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table
public class Appointment {
  @Id
  @GeneratedValue(generator = "custom-id")
  @GenericGenerator(name = "custom-id", strategy = "org.appointment.common.RandomStringGenerator")
  @Column
  private String patientId;

  @Column private String patientNameInEnglish;

  @Column private String patientNameInMarathi;

  @Column
  @GeneratedValue
  @GenericGenerator(name = "appointment_id", strategy = "org.appointment.common.CustomIdGenerator")
  private String appointmentId;

  @Column private String examinationDate;

  @Column private String appointmentTime;

  public static Appointment getInstanace() {
    return new Appointment();
  }

  public String getPatientId() {
    return patientId;
  }

  public Appointment setPatientId(String patientId) {
    this.patientId = patientId;
    return this;
  }

  public String getPatientNameInEnglish() {
    return patientNameInEnglish;
  }

  public Appointment setPatientNameInEnglish(String patientNameInEnglish) {
    this.patientNameInEnglish = patientNameInEnglish;
    return this;
  }

  public String getPatientNameInMarathi() {
    return patientNameInMarathi;
  }

  public Appointment setPatientNameInMarathi(String patientNameInMarathi) {
    this.patientNameInMarathi = patientNameInMarathi;
    return this;
  }

  public String getAppointmentId() {
    return appointmentId;
  }

  public Appointment setAppointmentId(String appointmentId) {
    this.appointmentId = appointmentId;
    return this;
  }

  public String getExaminationDate() {
    return examinationDate;
  }

  public Appointment setExaminationDate(String examinationDate) {
    this.examinationDate = examinationDate;
    return this;
  }

  public String getAppointmentTime() {
    return appointmentTime;
  }

  public Appointment setAppointmentTime(String appointmentTime) {
    this.appointmentTime = appointmentTime;
    return this;
  }

  public enum Status {
    DELETED
  }

  @Enumerated(EnumType.STRING)
  private Status status;

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
