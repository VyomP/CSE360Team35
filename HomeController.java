package PatientPortal;

import java.awt.TextField;
import java.io.BufferedWriter;
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
	
	public void displayName(String username) {
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
		String fileName=  "1_Message.txt";
			
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(to.getText() + "\n");
                //writer.write(sub.getText() + "\n");
                writer.write(gen.getText() + "\n");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
		System.out.print("msg");
	}
	
}
