//Done by Prateek

package DoctorPortal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DoctorPortalMessagingView extends BorderPane {
    ObservableList<Message> messages = FXCollections.observableArrayList();
    public ListView<Message> messageList;
    TextArea messageDetailsArea;

    public DoctorPortalMessagingView() {
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

        messageList = new ListView<>(messages);
        messageList.setCellFactory(param -> new MessageListCell());

        messageDetailsArea = new TextArea();
        messageDetailsArea.setPromptText("Message Details");

        VBox messagesBox = new VBox(10, messageList, messageDetailsArea);
        messagesBox.setPadding(new Insets(10));

        // Arrange containers in border pane
        setLeft(leftSideBox);
        setCenter(messagesBox);

        // Set up event handlers
        messageList.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Message selectedMessage = messageList.getSelectionModel().getSelectedItem();
                if (selectedMessage != null) {
                    messageDetailsArea.setText("Patient ID: " + selectedMessage.patientID + "\n\nSubject: " + selectedMessage.subject + "\n\nMessage: " + selectedMessage.message);
                } else {
                    messageDetailsArea.clear();
                }
            }
        });
    }

    public void addMessages(Message... messages) {
        this.messages.addAll(messages);
        // Write messages to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("messages.txt", true))) {
            for (Message message : messages) {
                writer.write(message.patientID + "," + message.urgency + "," + message.subject + "," + message.message);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Message {
        String patientID;
        String urgency;
        String subject;
        String message;

        public Message(String patientID, String urgency, String subject, String message) {
            this.patientID = patientID;
            this.urgency = urgency;
            this.subject = subject;
            this.message = message;
        }
        
        public String getPatientID() {
        	return patientID;
        }
        
        public String getUrgency() {
        	return urgency;
        }
        
        public String getSubject() {
        	return subject;
        }
        
        public String getMessage() {
        	return message;
        }
    }

    public static class MessageListCell extends ListCell<Message> {
        @Override
        protected void updateItem(Message msg, boolean empty) {
            super.updateItem(msg, empty);
            if (empty || msg == null) {
                setText(null);
            } else {
                HBox hbox = new HBox(
                        new Text(msg.patientID + " - "),
                        new Text(msg.urgency + " - "),
                        new Text(msg.subject + " - "),
                        new Text("*" + msg.message + "*")
                );
                hbox.setSpacing(5);
                setGraphic(hbox);
            }
        }
    }
}