package com.mycompany.parkingmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ParkingManager extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/parkingmanager/ui/parking_ui.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setTitle("Parking Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
