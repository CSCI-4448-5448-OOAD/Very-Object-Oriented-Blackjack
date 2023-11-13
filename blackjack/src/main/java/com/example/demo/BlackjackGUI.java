package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Loads the hello-view scene through the .fxml file
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StartView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 400); //xSize, ySize
        stage.setTitle("Blackjack GUI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}