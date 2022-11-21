import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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

public class MainViewController implements Initializable {

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
        sAnimalComboBox.getItems().add("002075 - Chien - Balou");
        sAnimalComboBox.getItems().add("002479 - Chat - Minou");
        sAnimalComboBox.getItems().add("003055 - Chien - Figarou");
        sAnimalComboBox.getItems().add("003112 - Chat - Pincette");
        sAnimalComboBox.getItems().add("003283 - Oiseau - Hourah");
        sAnimalComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            switch (newValue) {
                case "002075 - Chien - Balou": {
                    fichierImageChien = Paths.get("src/chien1.png");
                    try {
                        sAnimalImageView.setImage(new Image(fichierImageChien.toUri().toURL().toExternalForm()));
                    } catch (MalformedURLException e) { e.printStackTrace(); }
                    String texte1 = "";
                    texte1 += "Disponible pour adoption / Available for adoption\n";
                    texte1 += "\n";
                    texte1 += "Âge / Age : 5 ans / 5 years-old\n";
                    texte1 += "Mâle / Male\n";
                    texte1 += "Race (s) / Breed (s) : Mix\n";
                    texte1 += "Poids / Weight : 30.6 kg\n";
                    texte1 += "\n";
                    texte1 += "Bon pour appartement, peut-être vocal / Good for apartment, can be vocal\n";
                    texte1 += "Famille sans jeunes enfants / Family without young children\n";
                    texte1 += "Pas de chiens / No dogs\n";
                    texte1 += "Pas de chats / No cats\n";
                    texte1 += "\n";
                    texte1 += "Pas encore confortable de rester seul / Not yet comfortable being alone\n";
                    texte1 += "Niveau d'exercice requis / Exercise level needed : 2-3h\n";
                    texte1 += "Niveau d'expérience requis / Experience level required : Avancé/Advanced*\n";
                    texte1 += "\n";
                    texte1 += "* Pour parfaire le comportement de Bosco, un dépôt pour consultation(s) post-adoption sera exigé lors de l'adoption. Plus de détails sur notre page « Frais et procédures d'adoption » dans la section « Frais d'adoption / Dépôt ».\n";
                    texte1 += "\n";
                    texte1 += "//\n";
                    texte1 += "\n";
                    texte1 += "To improve Bosco's behaviour, a deposit for post-adoption consultation(s) will be required upon adoption.\n";
                    sAnimalTextAreaInfo.setText(texte1);
                    sAnimalTextAreaMedical.setText(newValue);
                    sAnimalTextFieldQui.setText("Rose-Marie Chérie");
                    sAnimalDatePicker.setValue(LocalDate.of(2022,07,20));
                    break;
                }
                case "002479 - Chat - Minou": {
                    break;
                }
                case "003055 - Chien - Figarou": {
                    break;
                }
                case "003112 - Chat - Pincette": {
                    break;
                }
                case "003283 - Oiseau - Hourah": {
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
