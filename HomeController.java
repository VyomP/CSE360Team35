package PatientPortal;

import javafx.scene.control.TextField;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
	private TextField sub;
	@FXML
	private TextField to;
	@FXML
	private TextField gen;
	@FXML
	TextField nameTextField;
	@FXML
	Label nameLabel;
	
	String un;
	
	public void displayName(String username) {
		un = username;
		nameLabel.setText("Hello: " + username);
	}
	
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	
	public void switchToMainScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void switchToMessage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("NewMessage.fxml"));
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
	
	public void save(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("PatientHome.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		File msgFil = new File(un + "MSG.txt");
		msgFil.createNewFile();
		FileWriter fw2 = new FileWriter(msgFil);
		BufferedWriter bw2 = new BufferedWriter(fw2);
		//save all values to the patientID file
		bw2.write("\n");
		bw2.write(sub.getText() + "\n");
		bw2.write(to.getText() + "\n");
		bw2.write(gen.getText() + "\n");
		
		//close writer
		bw2.flush();
		bw2.close();
	}
	
}
