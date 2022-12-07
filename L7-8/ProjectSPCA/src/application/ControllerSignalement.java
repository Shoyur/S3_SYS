package application;


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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ControllerSignalement implements Initializable{

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private ArrayList<Signalement> listeSignalement;
	
	@FXML
	private ComboBox<Integer> comboForm;
	
	@FXML
	private Label labelID, contactLabel, lieuLabel, titreLabel;
	
	@FXML
	private TextArea txtContact, txtLieu, txtDetails;
	
	@FXML
	private TextField tailleTxtField;
	
	private ArrayList<Label> listeLabel;
	private ArrayList<TextArea> listeTxtArea;
	
	
	private class Signalement  {
		
		private int id;
		private String nom;
		private String prenom;
		private String tel;
		private String adresse;
		private String ville;
		
		private String details;
		private String dateSignalement;
		
		private Signalement(int id, String nom, String prenom, String tel, String adresse, String ville, String details, String dateSignalement) {
			this.setId(id);
			this.setNom(nom);
			this.setPrenom(prenom);
			this.setTel(tel);
			this.setAdresse(adresse);
			this.setVille(ville);
			this.setDetails(details);
			this.setDateSignalement(dateSignalement);
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getVille() {
			return ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		public String getDetails() {
			return details;
		}

		public void setDetails(String details) {
			this.details = details;
		}

		public String getDateSignalement() {
			return dateSignalement;
		}

		public void setDateSignalement(String dateSignalement) {
			this.dateSignalement = dateSignalement;
		}
		
		
		
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listeSignalement = new ArrayList<Signalement>();
		Signalement signalement1 = new Signalement(12345, "Signal", "Jean", "514-800-9098", "69, rue des Amis des Animaux", "Montréal", "La personne a signalé avoir vue un propriétaire de chien le battre", "2022-11-22");
		Signalement signalement2 = new Signalement(28907, "Aivuedotre", "Jean", "514-800-9098", "420, rue des Pie-X", "Montréal", "La personne dit avoir vue des enfants botté un chat.", "2022-09-12");
		listeSignalement.add(signalement1);
		listeSignalement.add(signalement2);
		
		comboForm.setItems(getObsList());
		
		listeLabel = new ArrayList<Label>();
		listeTxtArea = new ArrayList<TextArea>();
		
		listeLabel.add(contactLabel);
		listeLabel.add(labelID);
		listeLabel.add(lieuLabel);
		listeLabel.add(contactLabel);
		listeTxtArea.add(txtContact);
		listeTxtArea.add(txtLieu);
		listeTxtArea.add(txtDetails);
		
		
		
	}
	
	
	private ObservableList<Integer> getObsList(){
		ObservableList<Integer> listID = FXCollections.observableArrayList();
		listeSignalement.forEach(signalement -> {
			listID.add(signalement.getId());
		});
		return listID;
	}
	
	public void send() {
		Alert alert = new Alert(AlertType.INFORMATION, "Formulaire de signalement transmis au agents.");
		alert.show();
		cancel();
	}
	
	public void cancel() {
		txtDetails.setEditable(true);
		txtContact.setText("");
		txtDetails.setText("");
		txtLieu.setText("");
		labelID.setText("ID Signalement : ");
		comboForm.getSelectionModel().clearSelection();
	}
	
	public void edit() {
		txtDetails.setEditable(true);
	}
	
	public void changerFormulaire() {
		txtDetails.setEditable(false);
		listeSignalement.forEach(signal ->{
			if(comboForm.getValue() == signal.getId()) {
				String msgContact = "";
				String msgLieu = "";
				String details = "";
				
				labelID.setText("ID Signalement : " + signal.getId());
				msgContact += "Info du signaleur : \n";
				msgContact += "\nPrénom : " + signal.getPrenom();
				msgContact += "\nNom : " + signal.getNom();
				msgContact += "\nTéléphone : " + signal.getTel();
				txtContact.setText(msgContact);
				msgLieu += "Lieu du signalement : \n";
				msgLieu += "Ville : " + signal.getVille();
				msgLieu += "\nAdresse : \n" + signal.getAdresse();
				txtLieu.setText(msgLieu);
				if(signal.getDetails().length() > 50) {
					details += "Date du signalement : " + signal.getDateSignalement() + "\n";
					details += signal.getDetails().substring(0, 44);
					details += "-\n" + signal.getDetails().substring(44);
					txtDetails.setText(details);
				}else {
					
					txtDetails.setText(signal.getDetails());
				}
				
			}else {
				
			}
		});
	}
	
	public void changeTextSize() {
		if(tailleTxtField.getText() != "") {
			int tailleText = Integer.parseInt(tailleTxtField.getText());
			Font font = new Font("System", tailleText);
			listeLabel.forEach(label ->{
				label.setFont(font);
			});
			listeTxtArea.forEach(txtArea -> {
				txtArea.setFont(font);
			});
		}
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
