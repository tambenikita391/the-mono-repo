package case_management_dashboard;

import add_appointments.AddAppointmentScreen;
import add_cases.AddCasesScreen;
import add_patients.AddPatientScreen;
import add_user.AddUserScreen;
import delete_cases.DeleteCaseScreen;
import hospital_management_dashboard.HospitalManagementScreen;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import search_update_cases.SearchCasesScreen;

public class CaseManagementScreenController {
  @FXML private Button addCase;

  @FXML private Button logOutButton;

  @FXML private Button usersButton;

  @FXML private Button patientsButton;

  @FXML private Button searchCase;

  @FXML private Button dashBoardButton;

  @FXML private Button caseButton;

  @FXML private Button appointmentsButton;

  @FXML private Button deleteCase;

  @FXML private Button editCase;

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
  private void addCases(ActionEvent event) throws IOException {
    AddCasesScreen.showAddCasesScreen();
  }

  @FXML
  private void editCases(ActionEvent event) throws IOException {
    SearchCasesScreen.showSearchCasesScreen();
  }

  @FXML
  private void deleteCases(ActionEvent event) throws IOException {
    DeleteCaseScreen.showDeleteCaseScreen();
  }

  @FXML
  private void searchCases(ActionEvent event) throws IOException {
    SearchCasesScreen.showSearchCasesScreen();
  }
}
