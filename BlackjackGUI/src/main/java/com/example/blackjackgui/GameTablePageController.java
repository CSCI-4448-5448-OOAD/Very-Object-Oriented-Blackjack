package com.example.blackjackgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GameTablePageController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToStartingPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartingPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    Label currentBalanceLabel;
    public void displayBalance(Integer balance){
        currentBalanceLabel.setText(String.valueOf(balance));
    }

    @FXML
    Label minBetLabel;
    public void displayMinBet(Integer minBet){
        minBetLabel.setText(String.valueOf(minBet));
    }

    @FXML
    Label playerNameTextField;
    public void displayName(String gamblerName){
        playerNameTextField.setText("Player: " + gamblerName);
    }
}
