package case_management_dashboard;

import common.StageFactory;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CaseManagementScreen {
  public static void showCaseManagementScreen() throws MalformedURLException, IOException {
    Parent actorGroup =
        FXMLLoader.load(
            new URL(
                "file:///C|/Users//tambe//eclipse-workspace//hospital-console//src//main//java//case_management_dashboard//case_management.fxml"));
    StageFactory.stage.setTitle("HOSPITAL MANAGEMENT SCREEN");
    StageFactory.stage.setFullScreen(true);

    Scene scene = new Scene(actorGroup);
    StageFactory.stage.setScene(scene);
    StageFactory.stage.show();
  }
}
