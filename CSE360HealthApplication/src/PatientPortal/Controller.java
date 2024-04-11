package PatientPortal;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	
	@FXML
	
	TextField nameTextField;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
		
	
	/*
	public void switchToRegister(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("NewPatient.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	*/
	
	
	public void switchToHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("PatientHome.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	/*
	public void switchToMainScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	*/
	
	public void login(ActionEvent event) throws IOException {
		
		String username = nameTextField.getText();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientHome.fxml"));
		root = loader.load();
		
		HomeController patienthomecontroller = loader.getController();
		patienthomecontroller.displayName(username);
		
		//Parent root = FXMLLoader.load(getClass().getResource("PatientHome.fxml"));
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
	
	public void switchToAppointments(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UpcomingAppointments.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	


	
}
