package search_update_cases;

import add_appointments.AddAppointmentScreen;
import add_patients.AddPatientScreen;
import add_user.AddUserScreen;
import case_management_dashboard.CaseManagementScreen;
import common.RestUtilGenerics;
import hospital_management_dashboard.HospitalManagementScreen;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hospital.dto.CaseRequest;
import org.hospital.dto.CaseResponse;

public class SearchCasesScreenController {
  @FXML private Button searchButton;

  @FXML private Button cancleButton;

  @FXML private Button usersButton;

  @FXML private TextField patient_id_search;

  @FXML private TextField patientnameInEnglish;

  @FXML private Button appointmentsButton;

  @FXML private Button logoutButton;

  @FXML private TextField symptoms;

  @FXML private Label userMessage;

  @FXML private Button dashboardButton;

  @FXML private TextField prescription;

  @FXML private TextField patientNameInMarathi;

  @FXML private TextField examinationDate;

  @FXML private Button patientsButton;

  @FXML private Button casesButton;

  @FXML private TextField case_id_search;
  @FXML private Button editButton;

  @FXML
  private void logOut(ActionEvent event) {
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
  private void appointments(ActionEvent event) throws IOException {
    AddAppointmentScreen.showAddAppointmentScreen();
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
  public void search(ActionEvent event) throws IOException {
    String patientId = patient_id_search.getText().trim();
    String caseId = case_id_search.getText().trim();

    CaseResponse response = null;
    try {
      if (!caseId.isEmpty()) {
        response =
            RestUtilGenerics.sendGetRequest(
                "http://localhost:8083/api/v1/case/" + caseId, CaseResponse.class);
      } else if (!patientId.isEmpty()) {
        response =
            RestUtilGenerics.sendGetRequest(
                "http://localhost:8083/api/v1/case/patient/" + patientId, CaseResponse.class);
      }

      if (response != null && "Success".equals(response.getStatus())) {
        patientnameInEnglish.setText(response.getPatientNameInEnglish());
        patientNameInMarathi.setText(response.getPatientNameInMarathi());
        examinationDate.setText(response.getExaminationDate());
        symptoms.setText(response.getSymptoms());
        prescription.setText(response.getPrescription());
        userMessage.setText("Case details retrieved successfully.");
      } else {
        userMessage.setText(
            "!!Error!! Case not found. Please enter a valid patient ID or case ID.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      userMessage.setText("!!Error!!, failed to fetch case details.");
    }
  }

  @FXML
  private void cancle(ActionEvent event) throws IOException {
    HospitalManagementScreen.showHospitalManagementScreen();
  }

  @FXML
  public void edit(ActionEvent event) throws IOException {
    String caseId = case_id_search.getText().trim();

    if (caseId.isEmpty()) {
      userMessage.setText("Error, Case ID is required to edit.");
      return;
    }

    CaseRequest updateCase = new CaseRequest();
    updateCase.setExaminationDate(examinationDate.getText());
    updateCase.setPatientNameInEnglish(patientnameInEnglish.getText());
    updateCase.setPatientNameInMarathi(patientNameInMarathi.getText());
    updateCase.setPrescription(prescription.getText());
    updateCase.setSymptoms(symptoms.getText());

    try {
      CaseResponse response =
          RestUtilGenerics.sendPutRequest(
              "http://localhost:8083/api/v1/case/" + caseId, CaseResponse.class, updateCase);

      if (response != null && "Success".equals(response.getStatus())) {
        userMessage.setText("Success, Case details have been updated successfully.");
      } else {
        userMessage.setText("Updated.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      userMessage.setText("Updated");
    }
  }
}
