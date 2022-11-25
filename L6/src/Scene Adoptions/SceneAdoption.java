import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneAdoption {

    Stage stage;

    Scene scene;

    Parent root;

    @FXML
    void retour(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e1) { e1.printStackTrace(); }
    }

}