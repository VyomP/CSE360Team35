package HealthcareApplicationPrototypeScenes;

import HealthcareApplicationPrototypeScenes.*;

import HealthcareApplicationPrototypeModels.User;
import HealthcareApplicationPrototypeModels.Patient;
import HealthcareApplicationPrototypeModels.Doctor;
import HealthcareApplicationPrototypeModels.Nurse;
import HealthcareApplicationPrototypeModels.Receptionist;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginScene extends Scene {
    private TextField usernameField;
    private PasswordField passwordField;

    public LoginScene(Stage primaryStage) {
        super(new GridPane(), 1920, 1080);

        GridPane gridPane = (GridPane) getRoot();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Image image = new Image("Resources/Icons/hospital.png");
        ImageView imageView = new ImageView(image);

        gridPane.add(imageView, 0, 0, 2, 1);

        Label titleLabel = new Label("Login");
        titleLabel.setFont(Font.font("Arial", 24));
        titleLabel.setStyle("-fx-font-weight: bold");
        gridPane.add(titleLabel, 0, 1, 2, 1);
        

        Label usernameLabel = new Label("Username:");
        gridPane.add(usernameLabel, 0, 2);
        usernameField = new TextField();
        gridPane.add(usernameField, 1, 2);

        Label passwordLabel = new Label("Password:");
        gridPane.add(passwordLabel, 0, 3);
        passwordField = new PasswordField();
        gridPane.add(passwordField, 1, 3);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> handleLogin(primaryStage));
        gridPane.add(loginButton, 1, 4);
    }

    private void handleLogin(Stage primaryStage) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        Patient patient = new Patient(username, password);
        primaryStage.setScene(new PatientPortalScene(primaryStage));
        /*
         * 
         * Possibly redo with just a basic object with return of a label to which type of user the UI should populate to?
        Patient patient = new Patient(username, password);
        if (patient.login(username, password)) {
            primaryStage.setScene(new PatientPortalScene(primaryStage, patient));
            return;
        }

        Nurse nurse = new Nurse(username, password);
        if (nurse.login(username, password)) {
            primaryStage.setScene(new DoctorNursePortalScene(primaryStage, nurse));
            return;
        }

        Doctor doctor = new Doctor(username, password);
        if (doctor.login(username, password)) {
            primaryStage.setScene(new DoctorNursePortalScene(primaryStage, doctor));
            return;
        }

        */
    }

}
