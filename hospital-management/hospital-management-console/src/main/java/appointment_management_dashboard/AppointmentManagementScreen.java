package appointment_management_dashboard;

import common.StageFactory;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AppointmentManagementScreen {
  public static void showAppointmentManagementScreen() throws IOException {
    Parent actorGroup =
        FXMLLoader.load(
            new URL(
                "file:///C|/Users//tambe//eclipse-workspace//hospital-console//src//main//java//appointment_management_dashboard//appointment-management.fxml"));
    StageFactory.stage.setTitle("APPOINTMENT MANAGEMENT SCREEN");
    StageFactory.stage.setFullScreen(true);

    Scene scene = new Scene(actorGroup);
    StageFactory.stage.setScene(scene);
    StageFactory.stage.show();
  }
}
