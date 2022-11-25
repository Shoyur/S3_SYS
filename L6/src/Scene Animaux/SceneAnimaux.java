import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SceneAnimaux implements Initializable {

    Stage stage;

    Scene scene;

    Parent root;

    Path fichierImageChien;

    @FXML
    private ComboBox<String> sAnimalComboBox;

    @FXML
    private DatePicker sAnimalDatePicker;

    @FXML
    private ImageView sAnimalImageView;

    @FXML
    private TextArea sAnimalTextAreaInfo;

    @FXML
    private TextArea sAnimalTextAreaMedical;

    @FXML
    private TextField sAnimalTextFieldQui;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        sAnimalComboBox.getItems().add("51289388 - Chien - Wallabee");
        sAnimalComboBox.getItems().add("49277310 - Chat - Coquette");
        sAnimalComboBox.getItems().add("51381554 - Chien - Calvin");
        sAnimalComboBox.getItems().add("50857478 - Chat - Pumpkin Spice");
        sAnimalComboBox.getItems().add("51409680 - Lapin - Newton");
        sAnimalComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            String cheminImage = "";
            String cheminTexte1 = "";
            switch (newValue) {
                case "51289388 - Chien - Wallabee": {
                    cheminImage = "animal_1.jpg";
                    cheminTexte1 = "animal_1.txt";
                    break;
                }
                case "49277310 - Chat - Coquette": {
                    cheminImage = "animal_2.jpg";
                    cheminTexte1 = "animal_2.txt";
                    break;
                }
                case "51381554 - Chien - Calvin": {
                    cheminImage = "animal_3.jpg";
                    cheminTexte1 = "animal_3.txt";
                    break;
                }
                case "50857478 - Chat - Pumpkin Spice": {
                    cheminImage = "animal_4.jpg";
                    cheminTexte1 = "animal_4.txt";
                    break;
                }
                case "51409680 - Lapin - Newton": {
                    cheminImage = "animal_5.jpg";
                    cheminTexte1 = "animal_5.txt";
                    break;
                }
                default: {
                    sAnimalImageView.setImage(null);
                    sAnimalTextAreaInfo.setText(null);
                    sAnimalTextAreaMedical.setText(null);
                    sAnimalTextFieldQui.setText(null);
                    sAnimalDatePicker.setValue(null);
                    break;
                }
            }
            fichierImageChien = Paths.get("src/" + cheminImage);
            try {
                sAnimalImageView.setImage(new Image(fichierImageChien.toUri().toURL().toExternalForm()));
            } catch (MalformedURLException e) { e.printStackTrace(); }
            String texte1 = "";
            String texte2 = "";
            try {
                Path fichierTexte1 = Path.of("src/" + cheminTexte1);
                texte1 = Files.readString(fichierTexte1);
                Path fichierTexte2 = Path.of("src/texte2.txt");
                texte2 = Files.readString(fichierTexte2);
            }
            catch (IOException e) { e.printStackTrace(); }
            sAnimalTextAreaInfo.setText(texte1);
            sAnimalTextAreaMedical.setText(texte2);
            sAnimalTextFieldQui.setText("Rose-Marie Chérie");
            sAnimalDatePicker.setValue(LocalDate.of(2022,07,20));
         }); 
        
    }

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
