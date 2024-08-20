package user_login;

import common.RestUtilGenerics;
import hospital_management_dashboard.HospitalManagementScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import org.hospital.dto.LoginRequest;
import org.hospital.dto.LoginResponse;

public class LoginScreenController {
  @FXML private Label userMessage;

  @FXML private PasswordField mobile;

  @FXML private Button loginButton;

  @FXML private PasswordField userName;

  @FXML
  public void login(ActionEvent event) throws Exception {
    boolean loginStatus =
        LoginScreenController.validateUserAndPassword(userName.getText(), mobile.getText());
    if (loginStatus) {
      HospitalManagementScreen.showHospitalManagementScreen();
    } else {
      System.out.println("Login unsuccessfull!!");
    }
  }

  public static boolean validateUserAndPassword(String userName, String mobile) {
    LoginRequest loginRequest = new LoginRequest();

    loginRequest.setUserName(userName);
    loginRequest.setMobileNumber(mobile);

    LoginResponse response;

    try {
      response =
          RestUtilGenerics.sendPostRequest(
              "http://localhost:8081/api/v1/directory/validate", LoginResponse.class, loginRequest);

      if (response.getStatus().equals("Success")) return true;
    } catch (Exception e) {

      e.printStackTrace();
    }
    return false;
  }
}
