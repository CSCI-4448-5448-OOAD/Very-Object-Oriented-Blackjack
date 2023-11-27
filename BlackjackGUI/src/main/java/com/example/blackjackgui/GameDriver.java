package com.example.blackjackgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameDriver extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Setup
        Parent root = FXMLLoader.load(getClass().getResource("StartingPage.fxml"));
        Image icon = new Image("https://static.thenounproject.com/png/15599-200.png");
        stage.getIcons().add(icon);
        stage.setTitle("BlackjackGUI");
        stage.setScene(new Scene(root));
        stage.show();
        //NOTE Most Game Logic held in GameTableController.java
    }

    public static void main(String[] args) {
        launch();
    }
}