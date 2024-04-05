package HealthApplication;

import javafx.application.Application;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//import javafx.scene.control.ToggleButton; 
import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Box;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.text.Text;
//import javafx.scene.control.ToggleGroup;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
//import javafx.event.*; 
//import javafx.collections.*; 
//import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*; 
import javafx.scene.layout.*;
import java.util.HashMap; // import the HashMap class



 
public class landingPage extends Application {
	
	
	
	private Scene homeScene;
	private Scene patient_intake;
	private Scene ctScanUI;
	private Scene patientView;
	//private Scene doctorView;
	private Stage programName;
	
	
	
	
	
    public static void main(String[] args) {
        launch(args);
    }
  
    public void start(Stage programName) {
    	this.programName = programName;
    	String welcomeTitle = "Welcome to Heart Health Imaging and Recording System";
    	  
        StackPane homeLayout = new StackPane();
        
        
                                       
        
        
        homeScene = new Scene(homeLayout, 500, 400);
        
        
       

        
        
        
        VBox vMenuSelection = new VBox(25);
        
        patient_intake = patientCreation.createPatientUI(this, programName);
    	//ctScanUI = Technician_view.createCTScan(this, programName);
    	//patientView = Patient_view.createPatientView(this, programName);
    					//doctorView = ct_doctor_view.createDoctorView(this, programName);
						//Scene scene2 = new Scene(patientUIComponents, 600, 400);
        
        programName.setScene(homeScene); // Set the initial scene
		programName.setTitle("CSE-360-th35");
		programName.show();
		 
       
        
        Button patientIntakeBttn = new Button("Patient Intake");
        patientIntakeBttn.setOnAction(e -> {
            programName.setScene(patient_intake); // Activate Scene 2
        });
        Button ctScanTechBttn = new Button("CT Scan Tech View");
        ctScanTechBttn.setOnAction(e -> {
            programName.setScene(ctScanUI); // Activate Scene 2
        });
        Button patientViewBttn = new Button("Patient View");
        patientViewBttn.setOnAction(e -> {
            programName.setScene(patientView); // Activate Scene 2
        });
		
        vMenuSelection.getChildren().addAll(new Label(welcomeTitle), patientIntakeBttn, ctScanTechBttn, patientViewBttn);
        vMenuSelection.setAlignment(Pos.CENTER);
        homeLayout.getChildren().add(vMenuSelection);
        
        // Create Scene 2
        
        Button deactivateScene2Button = new Button("Deactivate Scene 2");
        deactivateScene2Button.setOnAction(e -> {
            //programName.setScene(null); // Deactivate Scene 2
            //programName.setScene(scene1);
        });


		
	
		 

        
    }
	public void switchHomeScene() {
		
		//Stage stage = (Stage) homeScene.getWindow();
		//stage.setScene(homeScene);
		programName.setScene(homeScene);
    }
	
}