

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.Timer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SceneJeux1 implements Initializable {

    private Stage stage;
	private Scene scene;
    private Parent root;
    public static MouseEvent nodeTest;

    private int[] progress = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    private int pts = 0;

    @FXML
    private ImageView A01, A02, A03, A04, A05, A06, A07, A08, A09, A10;

    @FXML
    private Label pointage, temps;

    private Timer timer;
    private int delai = 30;
    

    @FXML
    void A01(MouseEvent event) {
        nodeTest = event;
        if (progress[1] == 0) {
            progress[1] = 1;
            A01.setStyle("-fx-image: url('A01v.png')");
            pts++;
            refreshPoints();
        }
    }

    @FXML
    void A02(MouseEvent event) {
        nodeTest = event;
        if (progress[2] == 0) {
            progress[2] = 1;
            A02.setStyle("-fx-image: url('A02v.png')");
            pts++;
            refreshPoints();
        }
    }

    @FXML
    void A03(MouseEvent event) {
        nodeTest = event;
        if (progress[3] == 0) {
            progress[3] = 1;
            A03.setStyle("-fx-image: url('A03v.png')");
            pts++;
            refreshPoints();
        }
    }

    @FXML
    void A04(MouseEvent event) {
        nodeTest = event;
        if (progress[4] == 0) {
            progress[4] = 1;
            A04.setStyle("-fx-image: url('A04v.png')");
            pts++;
            refreshPoints();
        }
    }


    @FXML
    void A05(MouseEvent event) {
        nodeTest = event;
        if (progress[5] == 0) {
            progress[5] = 1;
            A05.setStyle("-fx-image: url('A05v.png')");
            pts++;
            refreshPoints();
        }
    }

    @FXML
    void A06(MouseEvent event) {
        nodeTest = event;
        if (progress[6] == 0) {
            progress[6] = 1;
            A06.setStyle("-fx-image: url('A06v.png')");
            pts++;
            refreshPoints();
        }
    }

    @FXML
    void A07(MouseEvent event) {
        nodeTest = event;
        if (progress[7] == 0) {
            progress[7] = 1;
            A07.setStyle("-fx-image: url('A07v.png')");
            pts++;
            refreshPoints();
        }
    }

    @FXML
    void A08(MouseEvent event) {
        nodeTest = event;
        if (progress[8] == 0) {
            progress[8] = 1;
            A08.setStyle("-fx-image: url('A08v.png')");
            pts++;
            refreshPoints();
        }
    }


    @FXML
    void A09(MouseEvent event) {
        nodeTest = event;
        if (progress[9] == 0) {
            progress[9] = 1;
            A09.setStyle("-fx-image: url('A09v.png')");
            pts++;
            refreshPoints();
        }
    }


    @FXML
    void A10(MouseEvent event) {
        nodeTest = event;
        if (progress[10] == 0) {
            progress[10] = 1;
            A10.setStyle("-fx-image: url('A10v.png')");
            pts++;
            refreshPoints();
        }
    }

    private void refreshPoints() {
        pointage.setText("  " + pts + "/10 Points ");
        if (pts == 10) {
            goToJeux1Resultat(nodeTest);
        }
    }

    @FXML
    void goToJeux1Resultat(MouseEvent e) {
        // System.out.println(e.toString());
        timer.stop();
        ScenePrincipaleController.texteResultat = "Bravo! Tu as réussi à trouver\n" + pts + " animaux en\n" + (30-this.delai) + " secondes!\nDave te dit : O M G !!!";
        try {
            root = FXMLLoader.load(getClass().getResource("SceneJeux1Resultats.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e1) { e1.printStackTrace(); }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        temps.setText(delai + "s");
        timer = new Timer(1000, e -> {
            this.delai--;
            Platform.runLater(() -> { temps.setText(this.delai + "s"); });
            if (this.delai == 0) {
                timer.stop();
                Platform.runLater(() -> { goToJeux1Resultat(nodeTest); });
            }
            
        });
        timer.start();
    }

}