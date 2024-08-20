package add_patients;

import add_appointments.AddAppointmentScreen;
import add_user.AddUserScreen;
import case_management_dashboard.CaseManagementScreen;
import common.RestUtilGenerics;
import hospital_management_dashboard.HospitalManagementScreen;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hospital.dto.PatientRequest;
import org.hospital.dto.PatientResponse;

public class AddPatientScreenController {

  @FXML private ComboBox<String> gender;

  @FXML private TextField address;
  @FXML private TextField mobileNumber;
  @FXML private TextField patientNameInMarathi;
  @FXML private TextField patientNameInEnglish;
  @FXML private TextField birthDate;
  @FXML private TextField firstExaminationdate;
  @FXML private Label userMessage;

  @FXML
  private void initialize() {
    ObservableList<String> genders = FXCollections.observableArrayList("Male", "Female", "Other");
    gender.setItems(genders);
  }

  @FXML
  public void save(ActionEvent event) throws Exception {
    // Check if any field is empty
    if (address.getText().isEmpty()
        || mobileNumber.getText().isEmpty()
        || patientNameInMarathi.getText().isEmpty()
        || patientNameInEnglish.getText().isEmpty()
        || birthDate.getText().isEmpty()
        || firstExaminationdate.getText().isEmpty()
        || gender.getValue().isEmpty()) {
      userMessage.setText("All fields are mandatory, please fill all data");
      return;
    }

    PatientRequest addPatient = new PatientRequest();
    addPatient.setAddress(address.getText().trim());
    addPatient.setMobileNumber(mobileNumber.getText().trim());
    addPatient.setPatientNameInMarathi(patientNameInMarathi.getText().trim());
    addPatient.setPatientNameInEnglish(patientNameInEnglish.getText().trim());
    addPatient.setBirthDate(birthDate.getText().trim());
    addPatient.setFirstExaminationDate(firstExaminationdate.getText().trim());
    addPatient.setGender(gender.getValue().trim());

    try {
      PatientResponse response =
          RestUtilGenerics.sendPostRequest(
              "http://localhost:8082/api/v1/patient/add", PatientResponse.class, addPatient);
      userMessage.setText("Patient added successfully!!");
    } catch (IOException e) {
      e.printStackTrace();
      userMessage.setText("Failed to add patient: " + e.getMessage());
    } catch (InterruptedException e) {
      e.printStackTrace();
      userMessage.setText("Failed to add patient: " + e.getMessage());
    }
  }

  @FXML
  public void cancle(ActionEvent event) throws IOException {
    HospitalManagementScreen.showHospitalManagementScreen();
  }

  @FXML
  public void logOut(ActionEvent event) throws IOException {
    System.exit(0);
  }

  @FXML
  private void patients(ActionEvent event) throws IOException {
    AddPatientScreen.showAddPatientScreen();
  }

  @FXML
  private void cases(ActionEvent event) throws IOException {
    CaseManagementScreen.showCaseManagementScreen();
  }

  @FXML
  private void dashBoard(ActionEvent event) throws IOException {
    HospitalManagementScreen.showHospitalManagementScreen();
  }

  @FXML
  private void users(ActionEvent event) throws IOException {
    AddUserScreen.showAddUserScreen();
  }

  @FXML
  private void appointments(ActionEvent event) throws IOException {
    AddAppointmentScreen.showAddAppointmentScreen();
  }
}
