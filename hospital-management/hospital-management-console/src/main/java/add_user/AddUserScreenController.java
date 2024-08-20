package add_user;

import add_appointments.AddAppointmentScreen;
import add_patients.AddPatientScreen;
import case_management_dashboard.CaseManagementScreen;
import common.RestUtilGenerics;
import hospital_management_dashboard.HospitalManagementScreen;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.hospital.dto.UsersRequest;
import org.hospital.dto.UsersResponse;

public class AddUserScreenController {
  @FXML private TextField role;

  @FXML private Button cancleButton;

  @FXML private Button usersButton;

  @FXML private TextField mobile;

  @FXML private Button appointmentsButton;

  @FXML private TextField userName;

  @FXML private PasswordField password;

  @FXML private Button logOutButton;

  @FXML private Button patientsButton;

  @FXML private Button dashBoardButton;

  @FXML private Button casesButton;

  @FXML private PasswordField confirmPassword;

  @FXML private Button saveButton;

  @FXML private TextField email;
  @FXML private Label userMessage;

  @FXML
  public void save(ActionEvent event) throws Exception {
    // Check if any field is empty
    if (userName.getText().isEmpty()
        || email.getText().isEmpty()
        || mobile.getText().isEmpty()
        || role.getText().isEmpty()
        || password.getText().isEmpty()
        || confirmPassword.getText().isEmpty()) {
      userMessage.setText("All fields are mandatory, please fill all data");
      return;
    }

    UsersRequest addUser = new UsersRequest();
    addUser.setUserName(userName.getText().trim());
    addUser.setEmail(email.getText().trim());
    addUser.setMobileNumber(mobile.getText().trim());
    addUser.setRole(role.getText().trim());
    addUser.setPassword(password.getText().trim());
    addUser.setConfirmPassword(confirmPassword.getText().trim());

    try {
      UsersResponse response =
          RestUtilGenerics.sendPostRequest(
              "http://localhost:8081/api/v1/directory/add", UsersResponse.class, addUser);
      userMessage.setText("User added successfully!!");
    } catch (IOException e) {
      e.printStackTrace();
      userMessage.setText("Failed to add user: " + e.getMessage());
    } catch (InterruptedException e) {
      e.printStackTrace();
      userMessage.setText("Failed to add user: " + e.getMessage());
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
