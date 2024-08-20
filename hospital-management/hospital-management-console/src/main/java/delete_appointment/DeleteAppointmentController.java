package delete_appointment;

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
import org.hospital.dto.AppointmentResponse;

public class DeleteAppointmentController {
  @FXML private Button deleteButton;

  @FXML private Button searchButton;

  @FXML private Button cancleButton;

  @FXML private Button usersButton;

  @FXML private TextField patient_id_search;

  @FXML private TextField patientnameInEnglish;

  @FXML private Button appointmentsButton;

  @FXML private Button logoutButton;

  @FXML private TextField PatientNameInMarathi;

  @FXML private Label userMessage;

  @FXML private TextField appointment_id_search;

  @FXML private Button dashboardButton;

  @FXML private TextField appointmentTime;

  @FXML private TextField examinationDate;

  @FXML private Button patientsButton;

  @FXML private Button casesButton;

  public void delete(ActionEvent event) throws IOException {
    String appointmentId = appointment_id_search.getText().trim();

    if (appointmentId.isEmpty()) {
      userMessage.setText("Error, Please enter a appointment Id to delete.");
      return;
    }

    try {
      AppointmentResponse response =
          RestUtilGenerics.sendDeleteRequest(
              "http://localhost:8084/api/v1/appointment/" + appointmentId,
              AppointmentResponse.class);

      if (response != null && response.getStatus().equals("Success")) {
        userMessage.setText("Success, Appointment deleted");
        patient_id_search.clear();
        patientnameInEnglish.clear();
        PatientNameInMarathi.clear();
        appointmentTime.clear();
        examinationDate.clear();
        appointment_id_search.clear();

      } else {
        userMessage.setText(
            "!!Error!! Case not found. Please enter a valid patient ID or case ID.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      userMessage.setText("Deleted");
    }
  }

  @FXML
  public void search(ActionEvent event) throws IOException {
    String appointmentId = appointment_id_search.getText().trim();
    String patientId = patient_id_search.getText().trim();

    AppointmentResponse response = null;
    try {
      if (!patientId.isEmpty()) {
        response =
            RestUtilGenerics.sendGetRequest(
                "http://localhost:8084/api/v1/appointment/patient/" + patientId,
                AppointmentResponse.class);
      } else if (!appointmentId.isEmpty()) {
        response =
            RestUtilGenerics.sendGetRequest(
                "http://localhost:8084/api/v1/appointment/" + appointmentId,
                AppointmentResponse.class);
      }
      if (response != null && response.getStatus().equals("Success")) {
        patientnameInEnglish.setText(response.getPatientNameInEnglish());
        PatientNameInMarathi.setText(response.getPatientNameInMarathi());
        examinationDate.setText(response.getExaminationDate());
        appointmentTime.setText(response.getAppointmentId());

        userMessage.setText("Success, Appointment details  searched successfully.");

      } else {
        userMessage.setText("Error,Appointment not found");
      }
    } catch (Exception e) {
      e.printStackTrace();
      userMessage.setText("search");
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
