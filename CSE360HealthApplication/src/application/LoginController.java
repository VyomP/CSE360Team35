package application;

import DoctorPortal.DoctorPortalAppointmentsView;
import DoctorPortal.DoctorPortalMessagingView;
//import DoctorPortal.DoctorPortalApp;
import NursePortal.nursePortalMain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



public class LoginController {
	private Stage stage;
	private Scene scene;
	private Parent parent;
	
	private String username;
	private String password;
	
	String folderPath;
	
	String patientAccountFolderPath = "/PatientUsernamePassword/";
	
	String nurseAccountFolderPath = "/NurseUsernamePassword";
	
	@FXML
	private Button loginButton;
	@FXML
	private TextField patientID;
	@FXML
	private TextField patientPassword;
	@FXML
	private TextField doctorID;
	@FXML
	private TextField doctorPassword;
	@FXML
	private TextField nurseID;
	@FXML
	private TextField nursePassword;
	
	File folder = new File(patientAccountFolderPath);
	
	
	
	
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
	private void register(ActionEvent event) throws IOException {
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/CreateIntakePortal/Sample.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	@FXML
	private void logIn(ActionEvent event) throws IOException {
		//System.out.println("Patient Log In Was Pressed");
		
		username = patientID.getText();
		password = patientPassword.getText();
		
		
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/PatientPortal/PatientHome.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	@FXML
	private void doctorLogIn(ActionEvent event) throws IOException {
		//System.out.println("Doctor Log In Was Pressed");
		
		DoctorPortalMessagingView messagingView;
	    DoctorPortalAppointmentsView appointmentsView;

	    TabPane tabPane = new TabPane();
        messagingView = new DoctorPortalMessagingView();
        appointmentsView = new DoctorPortalAppointmentsView();

        tabPane.getTabs().addAll(
                new Tab("Messaging", messagingView),
                new Tab("Appointments", appointmentsView)
        );
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(tabPane, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Doctor Portal");
        stage.show();

        // Load doctor login details from the text file
        try {
            List<String> doctorLoginData = Files.readAllLines(Paths.get("/DoctorPortal/doctors.txt"));
            for (String line : doctorLoginData) {
                String[] fields = line.split(",");
                String username = fields[0];
                String password = fields[1];
                // Use the loaded doctor login details as needed
                // ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load messages from the text file
        try {
            List<String> messageData = Files.readAllLines(Paths.get("/DoctorPortal/messages.txt"));
            for (String line : messageData) {
                String[] fields = line.split(",");
                String patientID = fields[0];
                String urgency = fields[1];
                String subject = fields[2];
                String message = fields[3];
                messagingView.addMessages(new DoctorPortalMessagingView.Message(patientID, urgency, subject, message));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Handle urgent messages
        messagingView.messageList.setOnMouseClicked(localEvent -> {
            if (localEvent.getClickCount() == 2) {
                DoctorPortalMessagingView.Message selectedMessage = messagingView.messageList.getSelectionModel().getSelectedItem();
                if (selectedMessage != null && selectedMessage.getUrgency().equals("Urgent")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Urgent Message");
                    alert.setHeaderText("Patient: " + selectedMessage.getPatientID());
                    alert.setContentText("Subject: " + selectedMessage.getSubject() + "\n\nMessage: " + selectedMessage.getMessage());
                    alert.showAndWait();
                }
            }
        });
		
		/*
		username = doctorID.getText();
		password = doctorPassword.getText();
		System.out.println(username + password);
		
		folderPath  = "/DoctorUsernamePassword";
		String absoluteFolderPath = getClass().getResource(folderPath).getPath();
		System.out.println(absoluteFolderPath);
		
		File folder = new File(absoluteFolderPath);
	    File[] files = folder.listFiles();
	    //System.out.println(files);
	    
	    if (true) { // replace TRUE with files != null
	        for (File file : files) {
	            if (file.isFile()) {
	                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	                    String pass;
	                    while ((pass = reader.readLine()) != null) {
	                    	System.out.println(pass);
	                    	if (true) { // replace TRUE with pass.equals(username + "," + password) || (username + "," + password).equals("test,test")
	                        	
	                        }
	                    }
	                } catch (IOException e) {
	                    System.err.println("Error reading file: " + file.getName() + ", " + e.getMessage());
	                }
	            }
	        }
	    } else {
	    	Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText(null);
	        alert.setContentText("Wrong username or password");
	        alert.showAndWait();
	    }
		
		*/
	}
	
	
	
	
	@FXML
	private void nurseLogIn(ActionEvent event) throws IOException {
		//System.out.println("Nurse Log In Was Pressed");
		
		username = nurseID.getText();
		password = nursePassword.getText();
		
		
		
		Pane root = FXMLLoader.load(getClass().getResource("/NursePortal/hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	
	
}
