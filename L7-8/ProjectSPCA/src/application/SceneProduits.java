package application;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SceneProduits implements Initializable {

    Stage stage;

    Scene scene;

    Parent root;

    Path fichierImageProduit;

    @FXML
    private ComboBox<String> sProduitsComboBox;

    @FXML
    private ImageView sProduitsImageView;

    @FXML
    private ListView<String> sProduitsListViewProduits;

    @FXML
    private TextField sProduitsTextFieldQte;

    @FXML
    private Label sProduitsLabelInfos;

    private ObservableList<String> produits = FXCollections.observableArrayList();

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        sProduitsComboBox.getItems().add("Nourriture pour Chiens");
        sProduitsComboBox.getItems().add("Nourriture pour Chats");
        sProduitsComboBox.getItems().add("Entretien Chiens");
        sProduitsComboBox.getItems().add("Entretien Chats");
        sProduitsComboBox.getItems().add("Jouets");
        sProduitsComboBox.getItems().add("Accessoires");
        sProduitsComboBox.getItems().add("Autres");

        sProduitsListViewProduits.setItems(produits);
        sProduitsComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            if (newValue == "Nourriture pour Chiens") {
                produits.add("Pro Plan - Nourriture sèche formule Sport Performance 30/20");
                produits.add("Vetdiet - Nourriture sèche au poulet pour chien adulte de grande race");
                produits.add("Pro Plan - Entrée de nourriture humide au poisson blanc");
                produits.add("");
            }
        }); 
        
    }

    @FXML
    void sProduitsListViewMouseClicked(MouseEvent event) {
        if (sProduitsListViewProduits.getSelectionModel().getSelectedItem() == 
        "Pro Plan - Nourriture sèche formule Sport Performance 30/20") {
            String texte1 = "Marque:\tPro Plan";
            texte1 += "\n\nQuoi:\tNourriture sèche formule Sport Performance 30/20 au saumon et riz pour chiens, 17 kg";
            texte1 += "\n\nPrix:\t\t82,99$";
            sProduitsLabelInfos.setText(texte1);
//            fichierImageProduit = Paths.get("src/produit_1.png");
            try {
//                sProduitsImageView.setImage(new Image(fichierImageProduit.toUri().toURL().toExternalForm()));
                sProduitsImageView.setImage(new Image("application/produit_1.png"));
            } catch (Exception e) { e.printStackTrace(); }
        }
        else if (sProduitsListViewProduits.getSelectionModel().getSelectedItem() ==
        "Pro Plan - Entrée de nourriture humide au poisson blanc") {
            String texte3 = "Marque:\tPro Plan";
            texte3 += "\n\nQuoi:\tEntrée de nourriture humide au poisson blanc spécialisée pour un système urinaire en santé pour chats, 156 g";
            texte3 += "\n\nPrix:\t\t2,49$";
            sProduitsLabelInfos.setText(texte3);
//            fichierImageProduit = Paths.get("src/produit_3.png");
            try {
//                sProduitsImageView.setImage(new Image(fichierImageProduit.toUri().toURL().toExternalForm()));
                sProduitsImageView.setImage(new Image("application/produit_3.png"));
            } catch (Exception e) { e.printStackTrace(); }
        }
        else {
            sProduitsImageView.setImage(null);
            sProduitsLabelInfos.setText(null);
        }
    }

}
