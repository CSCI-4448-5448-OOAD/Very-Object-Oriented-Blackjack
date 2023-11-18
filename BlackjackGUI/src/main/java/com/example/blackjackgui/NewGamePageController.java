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
    TextField currentBalanceTextField; //The starting balance of the player
    @FXML
    TextField playerNameTextField;
    @FXML
    Label alertLabel;
    @FXML
    TextField minBetTextField;


    public void switchToGameTablePage(ActionEvent event) throws IOException {
        //TODO will need to send the data from our fields to the next scene
        //Collect all player/game info
        //String startingBalance = currentBalanceLabel.getText(); //Get starting Balance
        int startingBalance;
        int minBet;
        String gamblerName = playerNameTextField.getText();
        try {
            startingBalance = Integer.parseInt(currentBalanceTextField.getText());
            minBet = Integer.parseInt(minBetTextField.getText());
            if(startingBalance < 0 || minBet < 0){ //Verify balance isn't negative
                alertLabel.setText("ERROR: Negative numbers. Positive integers only!");
            } else if (minBet > startingBalance) {
                alertLabel.setText("ERROR: Min bet cannot exceed starting balance.");

            } else if (gamblerName.isEmpty()) { //Prevent null usernames
                alertLabel.setText("ERROR: Enter a name please.");
            } else{
                LoadGameTable(startingBalance, gamblerName, minBet, event);
            }
        }
        catch (NumberFormatException e){
            alertLabel.setText("ERROR: Starting balance only takes positive integers.");
        }
        catch (Exception e) {//Any other error from the staring balance
            alertLabel.setText("error");
        }

    }

    //Helper Function
    public void LoadGameTable(int startingBalance, String gamblerName, int minBet, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameTablePage.fxml"));
        root = loader.load();
        //Instance of game page controller
        GameTablePageController gameTableCon = loader.getController();
        //Call gamePageController functions to populate the next page.
        gameTableCon.displayBalance(startingBalance);
        gameTableCon.displayMinBet(minBet);
        gameTableCon.displayName(gamblerName);

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
