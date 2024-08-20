package hospital_console_main;

import common.StageFactory;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import user_login.LoginScreen;

public class HospitalMain extends Application {
  public static void main(String[] args) {

    launch(args);
  }

  public void start(Stage stage) throws IOException {
    StageFactory.stage = stage;
    LoginScreen.showLoginScreen();
  }
}
