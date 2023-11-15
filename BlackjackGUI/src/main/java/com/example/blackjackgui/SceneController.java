package com.example.blackjackgui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class SceneController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
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
    }



    //startAmountTxtField
}