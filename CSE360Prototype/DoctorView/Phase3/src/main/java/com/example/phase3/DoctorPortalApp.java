package com.example.phase3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DoctorPortalApp extends Application {
    private DoctorPortalMessagingView messagingView;
    private DoctorPortalAppointmentsView appointmentsView;

    @Override
    public void start(Stage primaryStage) throws Exception {
        TabPane tabPane = new TabPane();
        messagingView = new DoctorPortalMessagingView();
        appointmentsView = new DoctorPortalAppointmentsView();

        tabPane.getTabs().addAll(
                new Tab("Messaging", messagingView),
                new Tab("Appointments", appointmentsView)
        );

        // Load doctor login details from the text file
        try {
            List<String> doctorLoginData = Files.readAllLines(Paths.get("doctors.txt"));
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
            List<String> messageData = Files.readAllLines(Paths.get("messages.txt"));
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
        messagingView.messageList.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                DoctorPortalMessagingView.Message selectedMessage = messagingView.messageList.getSelectionModel().getSelectedItem();
                if (selectedMessage != null && selectedMessage.urgency.equals("Urgent")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Urgent Message");
                    alert.setHeaderText("Patient: " + selectedMessage.patientID);
                    alert.setContentText("Subject: " + selectedMessage.subject + "\n\nMessage: " + selectedMessage.message);
                    alert.showAndWait();
                }
            }
        });

        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Doctor Portal");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}