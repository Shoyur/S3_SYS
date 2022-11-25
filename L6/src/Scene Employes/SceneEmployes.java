import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SceneEmployes implements Initializable {

    Stage stage;

    Scene scene;

    Parent root;

    @FXML
    private Label sEmployesLabelAutres;

    @FXML
    private Label sEmployesLabelInfos;

    @FXML
    private ListView<String> sEmployesListView;

    private ObservableList<String> employes = FXCollections.observableArrayList();

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

    @FXML
    void sProduitsListViewMouseClicked(MouseEvent e) {
        if (sEmployesListView.getSelectionModel().getSelectedItem() == 
        "Alicia Hubert") {
            String texte1 = "Nom:\t Hubert\n\n";
            texte1 += "Prénom:\t Alicia\n\n";
            texte1 += "Tâches:\t Parainnage, Entretien, Caisse, Stock\n\n";
            texte1 += "Autres information: \n\n";
            sEmployesLabelInfos.setText(texte1);
            sEmployesLabelAutres.setText("Demandes d'adoption gérées par " + sEmployesListView.getSelectionModel().getSelectedItem() + " :\n\n");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        sEmployesListView.setItems(employes);
        employes.add("Alicia Hubert");
        employes.add("Emilie Garon");
        employes.add("Kassandra Bougie");
        employes.add("Rosalie Veilleux");
        employes.add("Bianca Lamarre");
        employes.add("Normélie Danis");
        employes.add("Edgénia Berthiaume");
        employes.add("Huméline Laflamme");
        employes.add("Clérentienne Lavergne");
        employes.add("Jovénine Drolet");

        
        
    }

}
