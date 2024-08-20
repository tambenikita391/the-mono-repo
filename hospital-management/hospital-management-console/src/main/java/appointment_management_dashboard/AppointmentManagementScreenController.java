package appointment_management_dashboard;

import add_appointments.AddAppointmentScreen;
import add_patients.AddPatientScreen;
import add_user.AddUserScreen;
import case_management_dashboard.CaseManagementScreen;
import edit_search_appointments.EditSearchAppointmentScreen;
import hospital_management_dashboard.HospitalManagementScreen;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AppointmentManagementScreenController {
  @FXML private Button logOutButton;

  @FXML private Button addAppointment;

  @FXML private Button usersButton;

  @FXML private Button patientsButton;

  @FXML private Button dashBoardButton;

  @FXML private Button casesButton;

  @FXML private Button deleteAppointment;

  @FXML private Button appointmentsButton;

  @FXML private Button editAppointment;

  @FXML private Button searchAppointment;

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

  @FXML
  private void addAppointments(ActionEvent event) throws IOException {
    AddAppointmentScreen.showAddAppointmentScreen();
  }

  @FXML
  private void searchAppointments(ActionEvent event) throws IOException {
    EditSearchAppointmentScreen.showEditSearchAppointmentScreen();
  }

  @FXML
  private void editAppointments(ActionEvent event) throws IOException {
    EditSearchAppointmentScreen.showEditSearchAppointmentScreen();
  }
}
