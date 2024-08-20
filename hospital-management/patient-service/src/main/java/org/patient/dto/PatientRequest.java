package org.patient.dto;

import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Component;

@Component
public class PatientRequest {
  @Pattern(regexp = "[a-zA-Z]{2,50}")
  private String patientName;

  private String gender;

  @Pattern(regexp = "[789][0-9]{9}")
  private String mobileNumber;

  private String age;
  private String address;

  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
