package add_cases;

import common.StageFactory;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddCasesScreen {
  public static void showAddCasesScreen() throws IOException {
    Parent actorGroup =
        FXMLLoader.load(
            new URL(
                "file:///C|/Users//tambe//eclipse-workspace//hospital-console//src//main//java//add_cases//Add Cases.fxml"));
    StageFactory.stage.setTitle("ADD CASES SCREEN");
    StageFactory.stage.setFullScreen(true);

    Scene scene = new Scene(actorGroup);
    StageFactory.stage.setScene(scene);
    StageFactory.stage.show();
  }
}
