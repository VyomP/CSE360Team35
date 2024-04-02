package HealthcareApplicationPrototypeScenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PatientPortalScene extends Scene {

    public PatientPortalScene(Stage primaryStage) {
        super(new BorderPane(), 1920, 1080);

        BorderPane borderPane = (BorderPane) getRoot();
        borderPane.setPadding(new Insets(10));

        // Header with logo and title
        HBox header = new HBox(10);
        header.setAlignment(Pos.CENTER);
        Image logoImage = new Image(getClass().getResourceAsStream("/Resources/Icons/hospital.png"));
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitHeight(50); // Adjust height as needed
        logoImageView.setPreserveRatio(true);
        Label titleLabel = new Label("Little Devil's Healthcare");
        titleLabel.setStyle("-fx-font-weight: bold");
        header.getChildren().addAll(logoImageView, titleLabel);
        borderPane.setTop(header);

        // Left panel with calendar view for appointments
        VBox calendarView = new VBox(10);
        calendarView.setPadding(new Insets(10));
        calendarView.setMaxWidth(Double.MAX_VALUE);
        calendarView.setAlignment(Pos.TOP_CENTER);
        Label appointmentsLabel = new Label("Appointments");
        titleLabel.setStyle("-fx-font-weight: bold");
        Rectangle appointmentsOutline = new Rectangle(850, 800); // Adjust size as needed
        appointmentsOutline.setStroke(Color.BLACK);
        appointmentsOutline.setFill(null);
        calendarView.getChildren().addAll(appointmentsLabel, appointmentsOutline);
        borderPane.setLeft(calendarView);

        // Center area (main content)
        VBox mainContent = new VBox(10);
        mainContent.setAlignment(Pos.CENTER);
        borderPane.setCenter(mainContent);

        // Bottom right area with email section
        VBox emailSection = new VBox(10);
        emailSection.setPadding(new Insets(10));
        emailSection.setMaxWidth(Double.MAX_VALUE);
        emailSection.setAlignment(Pos.TOP_CENTER);
        Label emailLabel = new Label("Email Section");
        titleLabel.setStyle("-fx-font-weight: bold");
        Rectangle emailOutline = new Rectangle(400, 200);
        emailOutline.setStroke(Color.BLACK);
        emailOutline.setFill(null);
        emailSection.getChildren().addAll(emailLabel, emailOutline);
        borderPane.setBottom(emailSection);

        // Top right area with buttons to update content
        VBox buttonsSection = new VBox(10);
        buttonsSection.setPadding(new Insets(10));
        buttonsSection.setMaxWidth(Double.MAX_VALUE);
        buttonsSection.setAlignment(Pos.TOP_RIGHT);
        Label buttonsLabel = new Label("Summary and Medical Records Section");
        titleLabel.setStyle("-fx-font-weight: bold");
        Rectangle buttonsOutline = new Rectangle(400, 200); // Adjust size as needed
        buttonsOutline.setStroke(Color.BLACK);
        buttonsOutline.setFill(null);
        Button viewSummaryButton = new Button("View Summary");
        Button viewMedicalRecordsButton = new Button("View Medical Records");
        buttonsSection.getChildren().addAll(buttonsLabel, buttonsOutline, viewSummaryButton, viewMedicalRecordsButton);
        borderPane.setRight(buttonsSection);
    }
}
