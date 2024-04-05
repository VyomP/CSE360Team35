package HealthApplication;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class patientCreation{
	
	public static Scene createPatientUI(landingPage lp, Stage programName) {
		
		Label sceneName = new Label(" Patient Intake Form");
		Label firstName = new Label("First Name: ");
		Label lastName = new Label("Last Name: ");
		Label email = new Label("Email: ");
		Label phoneNumber = new Label("Phone Number: ");
		Label healthHistory = new Label("Health History: ");
		Label insuranceID = new Label("Insurance ID: ");
		
		
		TextField firstNameField = new TextField();
		TextField lastNameField = new TextField();
		TextField emailField = new TextField();
		TextField phoneField = new TextField();
		TextField healthField = new TextField();
		TextField insuranceField = new TextField();
		
		Button saveButton = new Button("Save");
		saveButton.setOnAction(event -> {
			
			String firstNameText = firstNameField.getText();
			String lastNameText = lastNameField.getText();
			String emailText = emailField.getText();
			String phoneText = phoneField.getText();
			String healthText = healthField.getText();
			String insuranceText = insuranceField.getText();
			
			if(firstNameText.isEmpty() || lastNameText.isEmpty() || emailText.isEmpty() || phoneText.isEmpty() || healthText.isEmpty() || insuranceText.isEmpty()) {
				if (firstNameText.isEmpty()) {
					firstNameField.setStyle("-fx-border-color: red;");
				} else {
					firstNameField.setStyle("-fx-border-color: green;");
				}
				
				if (lastNameText.isEmpty()) {
					lastNameField.setStyle("-fx-border-color: red;");
				} else {
					lastNameField.setStyle("-fx-border-color: green;");
				}
				
				if (emailText.isEmpty()) {
					emailField.setStyle("-fx-border-color: red;");
				} else {
					emailField.setStyle("-fx-border-color: green;");
				}
				
				if (phoneText.isEmpty()) {
					phoneField.setStyle("-fx-border-color: red;");
				} else {
					
					phoneField.setStyle("-fx-border-color: green;");
				}
				
				if (healthText.isEmpty()) {
					healthField.setStyle("-fx-border-color: red;");
				} else {
					healthField.setStyle("-fx-border-color: green;");
				}
				
				if (insuranceText.isEmpty()) {
					insuranceField.setStyle("-fx-border-color: red;");
				} else {
					insuranceField.setStyle("-fx-border-color: green;");
				}
			}else {
				
				
				firstNameField.clear();  
				lastNameField.clear();
				emailField.clear();
				phoneField.clear();
				healthField.clear();
				
				insuranceField.clear(); // Reset style
				int IDCreation = new Random().nextInt(90000) + 10000;
				String patientIDCreation = String.valueOf(IDCreation);
				
				String fileFormat = patientIDCreation + "_PatientInfo.txt";
				 				
				 try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileFormat))) {
		                writer.write(firstNameText + "\n");
		                writer.write(lastNameText + "\n");
		                writer.write(emailText + "\n");
		                writer.write(phoneText + "\n");
		                writer.write(healthText + "\n");
		                writer.write(insuranceText + "\n"); // Write data to file line by line
		            } catch (IOException e) {
		                e.printStackTrace();
		            }		
				System.out.println("The patient ID is " + patientIDCreation);
				lp.switchHomeScene();
			}
		});
		
		
		HBox sceneBox = new HBox(55);
		sceneBox.getChildren().add(sceneName);
		sceneBox.setAlignment(Pos.CENTER);
		HBox firstNameBox = new HBox(65);
		firstNameBox.getChildren().addAll(firstName,firstNameField);
		HBox lastNameBox = new HBox(65);
		lastNameBox.getChildren().addAll(lastName,lastNameField);
		HBox emailBox = new HBox(92);
		emailBox.getChildren().addAll(email,emailField);
		HBox phoneBox = new HBox(40);
		phoneBox.getChildren().addAll(phoneNumber,phoneField);
		HBox healthBox = new HBox(43);
		healthBox.getChildren().addAll(healthHistory,healthField);
		HBox insuranceBox = new HBox(52);
		insuranceBox.getChildren().addAll(insuranceID,insuranceField);
		HBox saveBox = new HBox();
		saveBox.getChildren().add(saveButton);
		saveBox.setAlignment(Pos.CENTER);
		VBox patient_Form_UI = new VBox(25);
		
		
		patient_Form_UI.getChildren().addAll(sceneBox, firstNameBox, lastNameBox, emailBox, phoneBox, healthBox, insuranceBox, saveBox);
		//return patient_Form_UI;
		return new Scene(patient_Form_UI, 700,500);
		
	}
	 
   
}