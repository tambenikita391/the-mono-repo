package add_appointments;

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
import org.hospital.dto.AppointmentRequest;
import org.hospital.dto.AppointmentResponse;

public class AddAppointmentScreenController {
  @FXML private TextField appointmentTime;

  @FXML private Button logOutButton;

  @FXML private Button cancleButton;

  @FXML private Button usersButton;

  @FXML private TextField examinationDate;

  @FXML private TextField patientNameInMarathi;

  @FXML private Button dashBoardButton;

  @FXML private Button casesButton;

  @FXML private TextField patientNameInEnglish;

  @FXML private Button appointmentsButton;

  @FXML private Button saveButton;

  @FXML private Button PatientsButton;

  @FXML private Label userMessage;

  @FXML
  private void save(ActionEvent event) throws Exception {
    if (patientNameInEnglish.getText().isEmpty()
        || patientNameInMarathi.getText().isEmpty()
        || appointmentTime.getText().isEmpty()
        || examinationDate.getText().isEmpty()) {
      userMessage.setText("All fields are mandatory, please fill all data");
      return;
    }

    AppointmentRequest addAppointment = new AppointmentRequest();
    addAppointment.setPatientNameInEnglish(patientNameInEnglish.getText());
    addAppointment.setPatientNameInMarathi(patientNameInMarathi.getText());
    addAppointment.setAppointmentTime(appointmentTime.getText());
    addAppointment.setExaminationDate(examinationDate.getText());

    try {
      // Send a POST request to add the appointment
      AppointmentResponse response =
          RestUtilGenerics.sendPostRequest(
              "http://localhost:8084/api/v1/appointment/add",
              AppointmentResponse.class,
              addAppointment);

      if (response != null && "Success".equals(response.getStatus())) {
        userMessage.setText("Appointment added successfully!!");
      } else {
        userMessage.setText("Error, failed to add appointment.");
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      userMessage.setText("Error, failed to add appointment.");
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
}
