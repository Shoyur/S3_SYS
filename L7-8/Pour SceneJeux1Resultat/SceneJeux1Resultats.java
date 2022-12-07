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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SceneJeux1Resultats implements Initializable {
	private Stage stage;
	private Scene scene;
    @FXML
    private Label labelResultat;

    @FXML
    private TextArea records;

    @FXML
    void revenir(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ScenePrincipale.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e1) { e1.printStackTrace(); }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelResultat.setText(ScenePrincipaleController.texteResultat);
        String texte = "";
        texte += "Le 11 juillet 2022 à 14h55, quelqu'un a réussi à trouver 9 animaux en 30 secondes.\n";
        texte += "Le 23 juin 2022 à 15h00, quelqu'un a réussi à trouver 6 animaux en 30 secondes.\n";
        texte += "Le 22 mai 2022 à 10h02, quelqu'un a réussi à trouver 10 animaux en 30 secondes.\n";
        texte += "Le 19 mars 2022 à 11h01, quelqu'un a réussi à trouver 5 animaux en 15 secondes.\n";
        texte += "Le 8 mars 2022 à 17h15, quelqu'un a réussi à trouver 8 animaux en 30 secondes.\n";
        texte += "Le 15 février 2022 à 11h22, quelqu'un a réussi à trouver 9 animaux en 30 secondes.\n";
        texte += "Le 4 décembre 2021 à 9h02, quelqu'un a réussi à trouver 9 animaux en 30 secondes.\n";
        texte += "Le 20 novembre 2021 à 9h12, quelqu'un a réussi à trouver 10 animaux en 25 secondes.\n";
        texte += "Le 12 octobre 2021 à 10h09, quelqu'un a réussi à trouver 9 animaux en 30 secondes.\n";
        texte += "Le 1 août 2021 à 11h40, quelqu'un a réussi à trouver 7 animaux en 29 secondes.\n";
        texte += "Le 18 juin 2021 à 14h52, quelqu'un a réussi à trouver 8 animaux en 30 secondes.\n";
        texte += "Le 13 juin 2021 à 8h17, quelqu'un a réussi à trouver 9 animaux en 11 secondes.\n";
        texte += "Le 2 juin 2021 à 14h02, quelqu'un a réussi à trouver 8 animaux en 30 secondes.\n";
        records.setText(texte);
    }

}
