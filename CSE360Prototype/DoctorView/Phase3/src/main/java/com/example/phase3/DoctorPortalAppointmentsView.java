package com.example.phase3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DoctorPortalAppointmentsView extends BorderPane {
    ObservableList<Appointment> appointments = FXCollections.observableArrayList();
    ListView<Appointment> appointmentList;

    public DoctorPortalAppointmentsView() {
        // Create UI controls
        Text inputPatientDetailsText = new Text("Input Patient Details:");
        inputPatientDetailsText.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        TextField patientIDField = new TextField();
        patientIDField.setPromptText("Patient ID");

        Text doctorLoginText = new Text("Doctor Login:");
        doctorLoginText.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");

        VBox doctorLoginBox = new VBox(10, doctorLoginText, usernameField, passwordField, loginButton);
        doctorLoginBox.setPadding(new Insets(10));

        VBox leftSideBox = new VBox(10, inputPatientDetailsText, patientIDField, doctorLoginBox);
        leftSideBox.setPadding(new Insets(10));

        GridPane patientInfoGrid = new GridPane();
        patientInfoGrid.setHgap(10);
        patientInfoGrid.setVgap(5);
        patientInfoGrid.setPadding(new Insets(10));
        patientInfoGrid.add(new Text("Patient Name: Jane Doe"), 0, 0);
        patientInfoGrid.add(new Text("Phone Number: (513)-631-4893"), 0, 1);
        patientInfoGrid.add(new Text("Insurance Provider: [Provider]"), 0, 2);

        GridPane vitalsGrid = new GridPane();
        vitalsGrid.setHgap(10);
        vitalsGrid.setVgap(5);
        vitalsGrid.setPadding(new Insets(10));
        vitalsGrid.add(new Text("Vitals From Current Visit:"), 0, 0);
        vitalsGrid.add(new Text("Temperature (t) -"), 0, 1);
        vitalsGrid.add(new Text("Weight (lb.) -"), 0, 2);
        vitalsGrid.add(new Text("Height (ft' in\") -"), 0, 3);
        vitalsGrid.add(new Text("Blood Pressure (mmHg) -"), 0, 4);

        VBox healthConditionsBox = new VBox(5);
        healthConditionsBox.setPadding(new Insets(10));
        healthConditionsBox.getChildren().addAll(
                new Text("Health Conditions:"),
                new Text("- Condition 1"),
                new Text("- Condition 2")
        );

        VBox medicationBox = new VBox(5);
        medicationBox.setPadding(new Insets(10));
        medicationBox.getChildren().addAll(
                new Text("Medication:"),
                new Text("- Medication 1"),
                new Text("- Medication 2")
        );

        TextArea doctorNotesArea = new TextArea();
        doctorNotesArea.setPromptText("Doctor's Notes:");

        GridPane physicalTestResultsGrid = new GridPane();
        physicalTestResultsGrid.setHgap(10);
        physicalTestResultsGrid.setVgap(5);
        physicalTestResultsGrid.setPadding(new Insets(10));
        physicalTestResultsGrid.add(new Text("Physical Test Results:"), 0, 0);
        physicalTestResultsGrid.add(new Text("- Reflexes: [Good/Bad/Decent]"), 0, 1);
        physicalTestResultsGrid.add(new Text("- Other Findings"), 0, 2);
        physicalTestResultsGrid.add(new Text("- Etc."), 0, 3);

        GridPane pharmacyOrderGrid = new GridPane();
        pharmacyOrderGrid.setHgap(10);
        pharmacyOrderGrid.setVgap(5);
        pharmacyOrderGrid.setPadding(new Insets(10));
        pharmacyOrderGrid.add(new Text("Pharmacy Order Request:"), 0, 0);
        pharmacyOrderGrid.add(new Text("Product Name    Description   Pharmacy"), 0, 1);

        Button addOrderButton = new Button("Add Order");
        Button confirmOrderButton = new Button("Confirm Order");
        HBox pharmacyButtonsBox = new HBox(10, addOrderButton, confirmOrderButton);

        appointmentList = new ListView<>(appointments);

        VBox appointmentsBox = new VBox(10, new Text("Appointments:"), appointmentList);
        appointmentsBox.setPadding(new Insets(10));

        // Arrange containers in border pane
        setLeft(leftSideBox);
        setCenter(new VBox(10, doctorNotesArea, physicalTestResultsGrid));
        setRight(new VBox(10, healthConditionsBox, medicationBox, pharmacyOrderGrid, pharmacyButtonsBox, appointmentsBox));

        // Set up event handlers
        appointmentList.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Appointment selectedAppointment = appointmentList.getSelectionModel().getSelectedItem();
                if (selectedAppointment != null) {
                    // Load patient data based on the selected appointment
                    // Update the UI with the loaded patient data
                    loadPatientData(selectedAppointment.patientID);
                }
            }
        });
    }

    void addAppointments(Appointment... appointments) {
        this.appointments.addAll(appointments);
    }

    private void loadPatientData(String patientID) {
        try {
            // Read patient data from the text file
            List<String> patientData = Files.readAllLines(Paths.get("patients.txt"));
            for (String line : patientData) {
                String[] fields = line.split(",");
                if (fields[0].equals(patientID)) {
                    // Update the UI with the loaded patient data
                    // ...
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Appointment {
        String patientName;
        String patientID;
        String dateTime;

        Appointment(String patientName, String patientID, String dateTime) {
            this.patientName = patientName;
            this.patientID = patientID;
            this.dateTime = dateTime;
        }

        @Override
        public String toString() {
            return patientName + " (" + patientID + ") - " + dateTime;
        }
    }
}