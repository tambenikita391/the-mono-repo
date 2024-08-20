package hospital_management_dashboard;

import add_user.AddUserScreen;
import appointment_management_dashboard.AppointmentManagementScreen;
import case_management_dashboard.CaseManagementScreen;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import patient_management_dashboard.PatientManagementScreen;
import user_login.LoginScreen;

public class HospitalManagementScreenController {
  @FXML private Button logOutButton;

  @FXML private Button patientButton;

  @FXML private Button caseButton;

  @FXML private Button appointmentButton;

  @FXML private Button userButton;

  @FXML
  public void patients(ActionEvent event) throws IOException {
    System.out.println("Patient Screens button clicked!");
    PatientManagementScreen.showPatientManagementScreen();
  }

  @FXML
  private void cases(ActionEvent event) throws IOException {
    System.out.println("Case Screens button clicked!");
    CaseManagementScreen.showCaseManagementScreen();
  }

  @FXML
  public void appointments(ActionEvent event) throws IOException {
    System.out.println("Appointment Screen button clicked!");
    AppointmentManagementScreen.showAppointmentManagementScreen();
  }

  @FXML
  public void logOut(ActionEvent event) throws IOException {
    LoginScreen.showLoginScreen();
  }

  @FXML
  public void addUser(ActionEvent event) throws IOException {
    System.out.println("Users Screen button clicked!");
    AddUserScreen.showAddUserScreen();
  }
}
