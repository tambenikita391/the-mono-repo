package add_cases;

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

public class AddCasesScreenController {
  @FXML private TextField symptoms;

  @FXML private Button cancleButton;

  @FXML private TextField prescription;

  @FXML private TextField examinationDate;

  @FXML private TextField patientNameInMarathi;
  @FXML private TextField patientNameInEnglish;

  @FXML private Button saveButton;

  @FXML private Button logOutButton;
  @FXML private Label userMessage;

  @FXML
  public void save(ActionEvent event) throws Exception {

    if (examinationDate.getText() == null
        || examinationDate.getText().trim().isEmpty()
        || patientNameInEnglish.getText() == null
        || patientNameInEnglish.getText().trim().isEmpty()
        || prescription.getText() == null
        || prescription.getText().trim().isEmpty()
        || symptoms.getText() == null
        || symptoms.getText().trim().isEmpty()) {
      userMessage.setText("All fields are mandatory, please fill all data");
      return;
    }

    CaseRequest addCase = new CaseRequest();
    addCase.setExaminationDate(examinationDate.getText().trim());
    addCase.setPatientNameInEnglish(patientNameInEnglish.getText().trim());
    addCase.setPatientNameInMarathi(patientNameInMarathi.getText().trim());
    addCase.setPrescription(prescription.getText().trim());
    addCase.setSymptoms(symptoms.getText().trim());

    try {
      CaseResponse response =
          RestUtilGenerics.sendPostRequest(
              "http://localhost:8083/api/v1/case/add", CaseResponse.class, addCase);
      userMessage.setText("Case added successfully !!");
    } catch (IOException e) {
      e.printStackTrace();
      userMessage.setText("Failed to add case: " + e.getMessage());
    } catch (InterruptedException e) {
      e.printStackTrace();
      userMessage.setText("Failed to add case: " + e.getMessage());
    }
  }

  @FXML
  private void cancle(ActionEvent event) throws IOException {
    HospitalManagementScreen.showHospitalManagementScreen();
  }

  @FXML
  private void logOut(ActionEvent event) {
    System.exit(0);
  }

  @FXML
  private void patients(ActionEvent event) throws IOException {
    AddPatientScreen.showAddPatientScreen();
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
  private void cases(ActionEvent event) throws IOException {
    CaseManagementScreen.showCaseManagementScreen();
  }
}
