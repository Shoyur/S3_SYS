
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


public class ScenePrincipaleController {

    public static String texteResultat;

	private Stage stage;
	private Scene scene;

    @FXML
    void goToJeux1(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SceneJeux1.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("animaux.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void goToInverser(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SceneInverse.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
}
