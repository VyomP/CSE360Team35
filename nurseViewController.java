package NursePortal;

import DoctorPortal.DoctorPortalAppointmentsView.Appointment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import DoctorPortal.DoctorPortalMessagingView.Message;
import DoctorPortal.DoctorPortalMessagingView.MessageListCell;


public class nurseViewController {
    @FXML
    private Label welcomeText;

    @FXML
    private VBox myVBox;
    public TextField patIDTF;
    public TextField heightTF;
    public TextField weightTF;
    public TextField tempTF;
    public TextField bpTF;
    public Label emptyFieldError;
    public Pane nursepage;
    Button save;
    TextField monthTF, dayTF, paatIDTF, timeTF;
    Label error, aptSaved;
    
    String pID = "";
    public void appointments(ActionEvent e){
        myVBox.getChildren().clear();
        Stage s4 = new Stage();
        Scene scene;
		GridPane gp = new GridPane();
		gp.setVgap(10);
		gp.setHgap(10);
		
		Label month = new Label("Month");
		Label day = new Label("Day");
		Label paatID = new Label("Patient ID");
		Label time = new Label("Time: ");
		
		monthTF = new TextField();
		dayTF = new TextField();
		paatIDTF = new TextField();
		timeTF = new TextField();
		
		Label tit = new Label("Make New Appointment");
		save = new Button("Save Appointment");
		save.setOnAction(new ButtonHandler());
		error = new Label("");
		aptSaved = new Label("");
		
		gp.add(tit, 5, 3);
		gp.add(paatID, 4, 4);
		gp.add(month, 4, 6);
		gp.add(day, 4, 8);
		gp.add(paatIDTF, 6, 4);
		gp.add(monthTF, 6, 6);
		gp.add(dayTF, 6, 8);
		gp.add(time, 4, 10);
		gp.add(timeTF, 6, 10);
		gp.add(save, 6, 12);
		gp.add(error, 4, 12);
		gp.add(aptSaved, 4, 12);
		
		scene = new Scene(gp, 600, 450);
		s4.setScene(scene);
		s4.show();
		
    }
    public class ButtonHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			try {
				if(e.getSource().equals(save)) {
					if (paatIDTF.getText().trim().isBlank() || monthTF.getText().trim().isBlank() || dayTF.getText().trim().isBlank() || timeTF.getText().trim().isBlank()) {
						aptSaved.setText("");
						error.setText("One or more\nfields empty");
						error.setStyle("-fx-text-fill: red");
					}
					else {
						error.setText("");
						File apptFil = new File(paatIDTF.getText() + "APT.txt");
						apptFil.createNewFile();
						FileWriter fw2 = new FileWriter(apptFil);
						BufferedWriter bw2 = new BufferedWriter(fw2);
						//save all values to the patientID file
						bw2.write("\n");
						bw2.write(monthTF.getText() + "\n");
						bw2.write(dayTF.getText() + "\n");
						bw2.write(timeTF.getText() + "\n");
						
						//close writer
						bw2.flush();
						bw2.close();
						
						aptSaved.setText("Appointment Information Saved.\nYou may now close this page.");
					}
				}
			}catch(Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

    public void messageCenter(ActionEvent e) throws IOException{
        myVBox.getChildren().clear();
	    BufferedReader br2;
		try {
			br2 = new BufferedReader(new FileReader("nullMSG.txt"));
			//read and save all values to their respective labels
			br2.readLine();
			String sub = br2.readLine();
			String to = br2.readLine();
			String gen = br2.readLine();
			
			Label subl = new Label("Subject: " + sub);
			Label tol = new Label(to);
			Label genl = new Label("Message: " + gen);
			
			myVBox.getChildren().add(tol);
			myVBox.getChildren().add(subl);
			myVBox.getChildren().add(genl);
			
			//close both bufferedreaders
			br2.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    public void save(ActionEvent e){
        if(patIDTF.getText().trim().isBlank() || heightTF.getText().trim().isBlank() || weightTF.getText().trim().isBlank() || tempTF.getText().trim().isBlank() || bpTF.getText().trim().isBlank()) {
            emptyFieldError.setText("Error: Empty\nText Field");
            emptyFieldError.setStyle("-fx-text-fill: red");
        }
        else {
        	pID = patIDTF.getText();
            emptyFieldError.setText("");
            String fileName= patIDTF.getText() + "_PatientVitals.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(heightTF.getText() + "\n");
                writer.write(weightTF.getText() + "\n");
                writer.write(tempTF.getText() + "\n");
                writer.write(bpTF.getText() + "\n");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            emptyFieldError.setText("Patient Vitals\n    Saved");
            emptyFieldError.setStyle("-fx-text-fill: black");
        }
    }
    public void logout(ActionEvent e){
        nursepage.getChildren().clear();
        //load login screen
    }
}