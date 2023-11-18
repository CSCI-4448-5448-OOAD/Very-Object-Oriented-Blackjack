package com.example.blackjackgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class NewGamePageController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField startingBalanceTextField;
    public void switchToGameTablePage(ActionEvent event) throws IOException {
        //TODO will need to send the data from our fields to the next scene
        String startingBalance = startingBalanceTextField.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameTablePage.fxml"));
        root = loader.load();
        GameTablePageController gameTableCon = loader.getController();
        gameTableCon.displayBalance(startingBalance);
        //root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameTablePage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToStartingPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartingPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    @FXML
    private ChoiceBox<Integer> deckNumberChoice;
    private Integer[] deckOptions = {1, 2, 3, 4, 5};
    @FXML
    private ChoiceBox<Integer> npcNumberChoice;
    private Integer[] npcOptions = {0,1, 2, 3, 4}; //Up to 4 possible NPCs at the table
    @Override //Populates the Choice box for the # of decks the player wants
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deckNumberChoice.getItems().addAll(deckOptions);
        npcNumberChoice.getItems().addAll(npcOptions);
        //TODO MAKE ANOTHER SCENE CONTROLLER FOR SCENE 1. do this so we can link pg 1 and 2
    }
}
