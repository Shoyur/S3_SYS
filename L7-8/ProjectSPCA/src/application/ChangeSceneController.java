package application;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChangeSceneController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private String css = this.getClass().getResource("./application.css").toExternalForm();
	
	@FXML 
	private Label labelMain;
	
	@FXML
	private AnchorPane anchorPaneMain;
	

	
	
	public void goToFormSignalScene(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("FormSignalement.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void goToFormAdoptScene(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("SceneAdoption.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void goToAnimalScene(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("SceneAnimaux.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void goToEmpScene(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("SceneEmployes.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void goToClientScene(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("SceneClient.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
	}
	
	public void goToProdScene(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("SceneProduits.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void changeColor() {
		labelMain.setTextFill(Color.RED);
	}
	
	public void changeBackColor() {
		labelMain.setTextFill(Color.BLACK);
	}
	
	public void goToJeux1() {
		
	}
	
	public void goToJeux2() {
		
	}

	public void goToInitEmp() {
	
}
	
	
	
	
}
