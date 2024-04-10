package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class LoginController {
	private Stage stage;
	private Scene scene;
	private Parent parent;
	
	@FXML
	private void switchToDoctor(ActionEvent event) throws IOException {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("MainSceneDoctor.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void switchToNurse(ActionEvent event) throws IOException {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("MainSceneNurse.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void switchToPatient(ActionEvent event) throws IOException {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void logIn(ActionEvent event) {
		//System.out.println("Patient Log In Was Pressed");
	}
	
	@FXML
	private void doctorLogIn(ActionEvent event) {
		//System.out.println("Doctor Log In Was Pressed");
	}
	
	@FXML
	private void nurseLogIn(ActionEvent event) {
		//System.out.println("Nurse Log In Was Pressed");
	}
	
	@FXML
	private void register(ActionEvent event) {
		
	}
	
}
