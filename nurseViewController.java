package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    public void appointments(ActionEvent e){
        myVBox.getChildren().clear();
        ObservableList<Appointment> appointments = FXCollections.observableArrayList();
        ListView<Appointment> appointmentList;
        appointmentList = new ListView<>(appointments);
        myVBox.getChildren().add(10, new Text("Appointments:"), appointmentList);
    }
    public void messageCenter(ActionEvent e){
        myVBox.getChildren().clear();
        ObservableList<Message> messages = FXCollections.observableArrayList();
        ListView<Message> messageList = new ListView<>(messages);
        messageList.setCellFactory(param -> new MessageListCell());
        myVBox.getChildren().add(10, new Text("Messages:"), messageList);
    }
    public void save(ActionEvent e){
        if(patIDTF.getText().trim().isBlank() || heightTF.getText().trim().isBlank() || weightTF.getText().trim().isBlank() || tempTF.getText().trim().isBlank() || bpTF.getText().trim().isBlank()) {
            emptyFieldError.setText("Error: Empty\nText Field");
            emptyFieldError.setStyle("-fx-text-fill: red");
        }
        else {
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