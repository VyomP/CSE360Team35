package PatientPortal;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class HomeController {

	@FXML
	
	
	Label nameLabel;
	
	public void displayName(String username) {
		nameLabel.setText("Hello: " + username);
	}
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void switchToMainScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/application/MainScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void switchToMessage(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("NewMessage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToAppointments(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UpcomingAppointments.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToHealth(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ViewHealth.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToPatientHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("PatientHome.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
