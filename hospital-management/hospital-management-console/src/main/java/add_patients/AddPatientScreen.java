package add_patients;

import common.StageFactory;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddPatientScreen {
  public static void showAddPatientScreen() throws IOException {
    Parent actorGroup =
        FXMLLoader.load(
            new URL(
                "file:///C|/Users//tambe//eclipse-workspace//hospital-console//src//main//java//add_patients//Add Patients.fxml"));
    StageFactory.stage.setTitle("ADD PATIENT SCREEN");
    StageFactory.stage.setFullScreen(true);

    Scene scene = new Scene(actorGroup);
    StageFactory.stage.setScene(scene);
    StageFactory.stage.show();
  }
}
