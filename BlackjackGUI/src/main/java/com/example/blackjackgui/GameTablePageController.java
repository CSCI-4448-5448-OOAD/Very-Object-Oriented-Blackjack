package com.example.blackjackgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    @FXML
    Label deckNumberLabel;
    public void displayDeckNumber(Integer deckNumber){
        deckNumberLabel.setText(Integer.toString(deckNumber) + "- Deck Shoe");
    }

    @FXML
    Label NPC1Label;
    @FXML
    AnchorPane NPC1CardSlot1;
    @FXML
    AnchorPane NPC1CardSlot2;

    @FXML
    Label NPC2Label;
    @FXML
    AnchorPane NPC2CardSlot1;
    @FXML
    AnchorPane NPC2CardSlot2;
    @FXML
    Label NPC3Label;
    @FXML
    AnchorPane NPC3CardSlot1;
    @FXML
    AnchorPane NPC3CardSlot2;
    @FXML
    Label NPC4Label;
    @FXML
    AnchorPane NPC4CardSlot1;
    @FXML
    AnchorPane NPC4CardSlot2;
    List<AnchorPane> CardSlotList = new ArrayList<AnchorPane>();
    //Populating this list so the game can more easily know where to deal cards
    public void displayNPCs(Integer npcNumber){
//        List<Label> NPCLabelList = new ArrayList<Label>();
//        NPCLabelList.add(NPC1Label);
//        NPCLabelList.add(NPC2Label);
//        NPCLabelList.add(NPC3Label);
//        NPCLabelList.add(NPC4Label);
        switch(npcNumber) {
            case 0:
                // No Game Players
                break;
            case 1:
                NPC1Label.setText("NPC1");
                NPC2Label.setText(null);
                NPC3Label.setText(null);
                NPC4Label.setText(null);
                CardSlotList.add(p1CardSlot1);
                CardSlotList.add(NPC1CardSlot1);
                CardSlotList.add(p1CardSlot2);
                CardSlotList.add(NPC1CardSlot2);
                break;
            case 2:
                NPC1Label.setText("NPC1");
                NPC2Label.setText("NPC2");
                NPC3Label.setText(null);
                NPC4Label.setText(null);
                CardSlotList.add(p1CardSlot1);
                CardSlotList.add(NPC1CardSlot1);
                CardSlotList.add(NPC2CardSlot1);
                CardSlotList.add(p1CardSlot2);
                CardSlotList.add(NPC1CardSlot2);
                CardSlotList.add(NPC2CardSlot2);
                break;
            case 3:
                NPC1Label.setText("NPC1");
                NPC2Label.setText("NPC2");
                NPC3Label.setText("NPC3");
                NPC4Label.setText(null);
                CardSlotList.add(p1CardSlot1);
                CardSlotList.add(NPC1CardSlot1);
                CardSlotList.add(NPC2CardSlot1);
                CardSlotList.add(NPC3CardSlot1);
                CardSlotList.add(p1CardSlot2);
                CardSlotList.add(NPC1CardSlot2);
                CardSlotList.add(NPC2CardSlot2);
                CardSlotList.add(NPC3CardSlot2);
                break;
            case 4:
                NPC1Label.setText("NPC1");
                NPC2Label.setText("NPC2");
                NPC3Label.setText("NPC3");
                NPC4Label.setText("NPC4");
                CardSlotList.add(p1CardSlot1);
                CardSlotList.add(NPC1CardSlot1);
                CardSlotList.add(NPC2CardSlot1);
                CardSlotList.add(NPC3CardSlot1);
                CardSlotList.add(NPC4CardSlot1);
                CardSlotList.add(p1CardSlot2);
                CardSlotList.add(NPC1CardSlot2);
                CardSlotList.add(NPC2CardSlot2);
                CardSlotList.add(NPC3CardSlot2);
                CardSlotList.add(NPC4CardSlot2);
                break;

        }

    }


    @FXML
    private AnchorPane playerHandArea;
    //@FXML private AnchorPane panelLoadLabel;

    @FXML
    private AnchorPane dealerHandArea;
    @FXML
    private AnchorPane p1CardSlot1;
    @FXML
    private AnchorPane p1CardSlot2;
    @FXML
    private AnchorPane p1CardSlot3;


    //TODO Need to start making a function to encapsulate the glackjack logic
    //todo START WITH finding out how many players there are and dealing two cards to each
    public int counter = 0;
    public void createCard(ActionEvent event){
        //♥♦♠♣ Suit resource
        Label sampleCard = new Label("7♠");
        //Label sampleCard = new Label("7&spades");

        sampleCard.getStylesheets().add(getClass().getResource("CardStyling.css").toExternalForm());
        sampleCard.getStyleClass().add("sampleCard");


        //playerHandArea.getChildren().add(sampleCard);
        if(counter < 1){
            p1CardSlot1.getChildren().add(sampleCard);

        }else{
            p1CardSlot2.getChildren().add(sampleCard);
        }
        counter++;

    }

    public void minBet(ActionEvent event) throws InterruptedException {
        //TODO NOTE: The cards here are just for visuals. Real cards will b held w/in their
        //todo own classes.
        for(AnchorPane cardSlot : CardSlotList){
            //♥♦♠♣ Suit resource
            dealSingleCard(cardSlot);//can change this to take whatever value is generated from the card classes
            Thread.sleep(500); //TODO Doesn't delay correctly. Waits and then displays all
        }
    }
    public void dealSingleCard(AnchorPane cardSlot) throws InterruptedException {
        String[] cardNums = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] cardSuits = new String[]{"♥","♦","♠","♣"};
        Random rand = new Random();
        int numIdx = rand.nextInt(13);
        int suitIdx = rand.nextInt(4);
        Label sampleCard = new Label(cardNums[numIdx]+cardSuits[suitIdx]);
        sampleCard.getStylesheets().add(getClass().getResource("CardStyling.css").toExternalForm());
        sampleCard.getStyleClass().add("sampleCard");
        cardSlot.getChildren().add(sampleCard);

    }
}
