package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class SceneClientController implements Initializable{
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	@FXML
	private TextArea txtAreaInfo, txtAreaHistorique;
	
	@FXML
	private ImageView photoClient;
	
	@FXML
	private Label labelInfo, labelHisto, labelTitre;
	
	@FXML
	private ComboBox<Integer> comboClient;
	
	private ArrayList<Client> listeClient;

	
	private class Client{
		
		private String nom, prenom, tel, adresse, email, ville, imgPath;
		private Boolean historique;
		private int idClient;
		
		private Client(int idClient, String nom, String prenom, String tel, String adresse, String email, String ville, Boolean historique, String imgPath) {
			this.idClient = idClient;
			this.adresse = adresse;
			this.email = email;
			this.nom = nom;
			this.prenom = prenom;
			this.tel = tel;
			this.ville = ville;
			this.historique= historique;
			this.setImgPath(imgPath);
		}
		
		public int getID() {
			return idClient;
		}
		
		public void setId(int idClient) {
			this.idClient = idClient;
		}

		public String getVille() {
			return ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Boolean getHistorique() {
			return historique;
		}

		public void setHistorique(Boolean historique) {
			this.historique = historique;
		}

		public String getImgPath() {
			return imgPath;
		}

		public void setImgPath(String imgPath) {
			this.imgPath = imgPath;
		}
		
		
		
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listeClient = new ArrayList<Client>();
		Client client1 = new Client(1234, "Charles", "Xavier", "1-800-345-1234", "69, rue des X-Men", "prof.Xavier@xmen.com", "New York", false, "prof_xavier.jpg");
		Client client2 = new Client(4321, "Wolv", "erine", "1-800-345-8888", "420, rue des X-Men", "wolverine@xmen.com", "New York", true, "wolverine.jpg");
		
		listeClient.add(client1);
		listeClient.add(client2);
		
		comboClient.setItems(getObsList());
		
		
	}

	
	private ObservableList<Integer> getObsList(){
		ObservableList<Integer> listeIdClient = FXCollections.observableArrayList();
		listeClient.forEach(client -> {
			listeIdClient.add(client.getID());
		});
		return listeIdClient;
	}
	
	
	public void afficherInfo() {
		listeClient.forEach(client ->{
			if(comboClient.getValue() == client.getID()) {
				String msgInfo = "";
				String msgHisto = "";
				msgInfo += "Informations sur le clients : \n";
				msgInfo += "Prénom : " + client.getPrenom();
				msgInfo += "\nNom : " + client.getNom();
				msgInfo += "\nEmail : " + client.getEmail();
				msgInfo += "\nTéléphone : " + client.getTel();
				msgInfo += "\nAdresse : " + client.getAdresse();
				msgInfo += "\nVille : " + client.getVille();
				
				msgHisto += "Historique sur le client : \n";
				
				txtAreaInfo.setText(msgInfo);
				if(client.getHistorique()) {
					msgHisto += "Ce client en est à ça\ntroisième adoption" + "\n\n";
					msgHisto += "ID Animaux adopté : \n";
					msgHisto += "74583\n34629\n40232";
				}else {
					msgHisto += "Ce client n'a jamais adopté\n avec la SPCA.";
				}
				txtAreaHistorique.setText(msgHisto);
				Image imgClient = new Image(("application/"+client.getImgPath()), 150, 150, false, false);
				photoClient.setImage(imgClient);
			}else {
				
			}
		});
	}
	
	public void txtToSpeech() {
		listeClient.forEach(client -> {
			if(comboClient.getValue() == client.getID()) {
				if(client.getID() == 1234) {
					
					String musicFile = "txtToSpeechXavier.mp3";     // For example
					Media sound = new Media(getClass().getResource(musicFile).toExternalForm());
					MediaPlayer mediaPlayer = new MediaPlayer(sound);
					mediaPlayer.play();
				}else if (client.getID() == 4321) {
					String musicFile = "txtToSpeechWolverine.mp3";     // For example
					Media sound = new Media(getClass().getResource(musicFile).toExternalForm());
					MediaPlayer mediaPlayer = new MediaPlayer(sound);
					mediaPlayer.play();
				}

			}
			
		});
	}
	
	
	public void backHome(ActionEvent e) {
		try {
			root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
			stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}catch (IOException e1) {

			e1.printStackTrace();
		}
	}






	
	
	
	
}
