//Created by Drew

package CreateIntakePortal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.*;


public class SampleController {
	
	ObservableList<String> insuranceChoiceList = FXCollections.observableArrayList("None", "Aetna", "BCBS", "UnitedHealthCare");
	String selectedInsuranceChoice;
	StringBuilder allergiesMedicationString = new StringBuilder();
	String visitTextString;
	
	@FXML
	private TextArea visitTextArea;
	
	
	@FXML
	private TextField firstNameBox;
	
	
	@FXML
	private TextField middleInitialBox;
	
	@FXML
	private TextField lastNameBox;

	@FXML
	private TextField dobBox;

	@FXML
	private TextField phoneNumberBox;

	@FXML
	private TextField emailBox;
	
	@FXML
	private CheckBox knownAllergiesCB;
	
	@FXML
	private CheckBox medicationHistoryCB;
	
	@FXML
	private CheckBox InsuranceCB;
	
	@FXML
	private VBox allergiesvbox;
	
	@FXML
	private CheckBox allergiesFoodCB;
	
	@FXML
	private CheckBox allergiesHayFeverCB;
	
	@FXML
	private CheckBox allergiesAsthmaCB;
	
	@FXML
	private CheckBox allergiesInsectsCB;
	
	@FXML
	private CheckBox allergiesLatexCB;
	
	@FXML
	private CheckBox medicationAntacidsCB;
	
	@FXML
	private CheckBox medicationAntibioticsCB;
	
	@FXML
	private CheckBox medicationAntipyreticsCB;
	
	@FXML
	private CheckBox medicationAntihistaminesCB;
	
	@FXML
	private CheckBox medicationBronchodilatorsCB;
	
	
	@FXML
	private VBox medicationHistoryvbox;
	
	@FXML
	private VBox insurancevbox;
	
	@FXML
	private ChoiceBox<String> insuranceChoiceBox;
	
	@FXML
	private void initialize() {
		insuranceChoiceBox.setValue("None");
		insuranceChoiceBox.setItems(insuranceChoiceList);
	}

	/*
	 * @FXML private Button submitButton;
	 */
	
	//@FXML
	/*private void submitActionButton(ActionEvent saveFileEvent) {
		
		  if (firstNameBox.getText() == null) { 
			  System.out.println("Empty First Name");
		  }*/
		 
	//a}
	@FXML
	private void submitBttn(ActionEvent e) {
		String firstNameText = firstNameBox.getText();
		String middleInitialText = middleInitialBox.getText();
		String lastNameText = lastNameBox.getText();
		String dobText = dobBox.getText();
		String phoneNumberText = phoneNumberBox.getText();
		String emailText = emailBox.getText();
		if(firstNameText.isEmpty() || middleInitialText.isEmpty()|| lastNameText.isEmpty() || dobText.isEmpty() || phoneNumberText.isEmpty() || emailText.isEmpty()) {
			if (firstNameText.isEmpty()) { 
				firstNameBox.setStyle("-fx-border-color: red;");
			}else {
				firstNameBox.setStyle("-fx-border-color: NONE;");
			}
			if(middleInitialText.isEmpty()) {
				middleInitialBox.setStyle("-fx-border-color: red;");
			}else {
				middleInitialBox.setStyle("-fx-border-color: NONE;");
			}
			if (lastNameText.isEmpty()) { 
				lastNameBox.setStyle("-fx-border-color: red;");
			}else {
				lastNameBox.setStyle("-fx-border-color: NONE;");
			}
			if (dobText.isEmpty()) { 
				dobBox.setStyle("-fx-border-color: red;");
			}else {
				dobBox.setStyle("-fx-border-color: NONE;");
			}
			if (phoneNumberText.isEmpty()) { 
				phoneNumberBox.setStyle("-fx-border-color: red;");
			}else {
				phoneNumberBox.setStyle("-fx-border-color: NONE;");
			}
			if (emailText.isEmpty()) { 
				emailBox.setStyle("-fx-border-color: red;");
			}else {
				emailBox.setStyle("-fx-border-color: NONE;");
			}
		}else {
			allergiesMedicationString.append("Current Allergies \n");
			if(knownAllergiesCB.isSelected()) {
				if(allergiesFoodCB.isSelected()) {
					allergiesMedicationString.append("Food \n");
				
				}
				if(allergiesHayFeverCB.isSelected()) {
					allergiesMedicationString.append("Hay Fever \n");
				}
				if(allergiesAsthmaCB.isSelected()) {
					allergiesMedicationString.append("Asthma \n");
				}
				if(allergiesInsectsCB.isSelected()) {
					allergiesMedicationString.append("Insects \n");
				}
				if(allergiesLatexCB.isSelected()) {
					allergiesMedicationString.append("Letex \n");
				}
			}else {
				allergiesMedicationString.append("no known Allergies \n");
			}allergiesMedicationString.append("Medication history \n");
			if(medicationHistoryCB.isSelected()) {
				if(medicationAntacidsCB.isSelected()) {
                    allergiesMedicationString.append("Antacids \n");
                }
                if(medicationAntibioticsCB.isSelected()) {
                    allergiesMedicationString.append("Antibiotics \n");
                }
                if(medicationAntipyreticsCB.isSelected()) {
                    allergiesMedicationString.append("Antipyretics \n");
                }
                if(medicationAntihistaminesCB.isSelected()) {
                    allergiesMedicationString.append("Antihistamines \n");
                }
                if(medicationBronchodilatorsCB.isSelected()) {
                    allergiesMedicationString.append("Bronchodilators \n");
                }
			}else {
				allergiesMedicationString.append("No medication history \n");
			}
			String firstLetterUpperCase = firstNameText.substring(0, 1).toUpperCase();
			String middleLetterUpperCase = middleInitialText.substring(0, 1).toUpperCase();
			String lastLetterUpperCase = lastNameText.substring(0, 1).toUpperCase();
			firstNameText = firstNameText.toUpperCase();
			lastNameText = lastNameText.toUpperCase();
			emailText = emailText.toUpperCase();

			selectedInsuranceChoice = insuranceChoiceBox.getValue();
			allergiesMedicationString.append(selectedInsuranceChoice + "\n");
			
			visitTextString = visitTextArea.getText();
			firstNameBox.clear();
			middleInitialBox.clear();
			lastNameBox.clear();
			dobBox.clear();
			phoneNumberBox.clear();
			emailBox.clear();
			
			int IDCreation = new Random().nextInt(90000) + 10000;
			String patientIDCreation = String.valueOf(IDCreation);
			
			String fileFormat = firstLetterUpperCase + lastLetterUpperCase + patientIDCreation + "_patientInfo.txt";
			
			// Added path to patient folder
			String filePathAndFormat = "PatientUsernamePassword/" + fileFormat;
			
			 try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePathAndFormat))) {
				 	//writer.write(password + "\n");
				 
				 	writer.write(firstNameText + "\n");
				 	writer.write(middleLetterUpperCase + "\n");
	                writer.write(lastNameText + "\n");
	                writer.write(dobText + "\n");
	                writer.write(phoneNumberText + "\n");
	                writer.write(emailText + "\n");
	                writer.write(allergiesMedicationString.toString() + "\n"); // Write data to file line by line
	                writer.write(visitTextString);
	            } catch (IOException er) {
	                er.printStackTrace();
	            }		
			System.out.println("The patient ID is " + patientIDCreation);
			
		}
	}
	
	@FXML
	private void handleAllergiesBox() {
		if(knownAllergiesCB.isSelected()) {
			allergiesvbox.setDisable(false);
			
		}else {
			allergiesvbox.setDisable(true);
		}
	}
	
	@FXML
	private void handleMedicationBox() {
		if(medicationHistoryCB.isSelected()) {
			medicationHistoryvbox.setDisable(false);
			
		}else {
			medicationHistoryvbox.setDisable(true);
		}
	}
	
	@FXML
	private void handleInsuranceBox() {
		if(InsuranceCB.isSelected()) {
			insurancevbox.setDisable(false);
			
		}else {
			insurancevbox.setDisable(true);
		}
	}
	
	
	
	//Small edit for Back Button
	@FXML
	private void loginScene(ActionEvent event) throws IOException {
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/MainScene.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
