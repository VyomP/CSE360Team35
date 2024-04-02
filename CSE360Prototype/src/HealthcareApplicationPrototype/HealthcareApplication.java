package HealthcareApplicationPrototype;

import javafx.application.Application;
import javafx.stage.Stage;
import HealthcareApplicationPrototypeScenes.LoginScene;

public class HealthcareApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Little Sundevil's Healthcare");
        primaryStage.setScene(new LoginScene(primaryStage));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}