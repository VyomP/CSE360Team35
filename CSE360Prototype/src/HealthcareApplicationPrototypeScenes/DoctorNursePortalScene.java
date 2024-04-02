package HealthcareApplicationPrototypeScenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DoctorNursePortalScene extends Scene {
    public DoctorNursePortalScene(Stage primaryStage) {
        super(new VBox(), 1920, 1080);

        VBox vBox = (VBox) getRoot();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);

        Label titleLabel = new Label("Doctor/Nurse Portal");

        Button recordVitalsButton = new Button("Record Vitals");
        Button viewMedicalRecordsButton = new Button("View Medical Records");
        Button viewAppointmentsButton = new Button("View Appointments");

        vBox.getChildren().addAll(titleLabel, recordVitalsButton, viewMedicalRecordsButton, viewAppointmentsButton);
    }
}