package HealthcareApplicationPrototypeScenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LandingScene extends Scene {
    public LandingScene(Stage primaryStage) {
        super(new VBox(), 1920, 1080);

        VBox vBox = (VBox) getRoot();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);

        Label titleLabel = new Label("Little Sundevil's Healthcare");

        Button patientPortalButton = new Button("Patient Portal");
        patientPortalButton.setOnAction(event -> primaryStage.setScene(new PatientPortalScene(primaryStage)));

        Button doctorNursePortalButton = new Button("Doctor/Nurse Portal");
        doctorNursePortalButton.setOnAction(event -> primaryStage.setScene(new DoctorNursePortalScene(primaryStage)));

        vBox.getChildren().addAll(titleLabel, patientPortalButton, doctorNursePortalButton);
    }
}