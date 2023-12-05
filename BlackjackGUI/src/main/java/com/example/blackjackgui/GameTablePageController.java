package com.example.blackjackgui;
import com.example.blackjackgui.model.*;

import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;

import java.io.IOException;

public class GameTablePageController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    //User user;
    public void switchToStartingPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartingPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //TODO need to load a dealer instead
    Dealer dealer;
    public void loadDealer(int numDecks, int minBet, int numNPCs, int startingAmount, String playerName){
        this.dealer = new Dealer(numDecks, minBet, numNPCs, startingAmount, playerName);

    }

    @FXML
    Label currentBalanceLabel;
    Integer currentBalance;
    public void displayBalance(Integer balance){
        currentBalanceLabel.setText(String.valueOf(balance));
        this.currentBalance = balance;
    }

    @FXML
    Label minBetLabel;
    public void displayMinBet(Integer newMinBet){
        minBetLabel.setText(String.valueOf(newMinBet));
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
    private AnchorPane p1CardSlot1;
    @FXML
    private AnchorPane p1CardSlot2;
    @FXML
    private AnchorPane p1CardSlot3; //Maybe call this additional slot?
    @FXML
    Label NPC1Label;
    @FXML
    AnchorPane NPC1CardSlot1;
    @FXML
    AnchorPane NPC1CardSlot2;
    @FXML
    AnchorPane NPC1CardSlot3;
    @FXML
    Label NPC2Label;
    @FXML
    AnchorPane NPC2CardSlot1;
    @FXML
    AnchorPane NPC2CardSlot2;
    @FXML
    AnchorPane NPC2CardSlot3;
    @FXML
    Label NPC3Label;
    @FXML
    AnchorPane NPC3CardSlot1;
    @FXML
    AnchorPane NPC3CardSlot2;
    @FXML
    AnchorPane NPC3CardSlot3;
    @FXML
    Label NPC4Label;
    @FXML
    AnchorPane NPC4CardSlot1;
    @FXML
    AnchorPane NPC4CardSlot2;
    @FXML
    AnchorPane NPC4CardSlot3;
    @FXML
    AnchorPane DealerCardSlot1;
    @FXML
    AnchorPane DealerCardSlot2;
    @FXML
    AnchorPane DealerCardSlot3;
    List<AnchorPane> StartingCardSlotList = new ArrayList<AnchorPane>();
    //CardSlotList populated through displayNPCs. Auto Loaded through newGamePage
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
                StartingCardSlotList.add(p1CardSlot1);
                StartingCardSlotList.add(NPC1CardSlot1);
                StartingCardSlotList.add(DealerCardSlot1);

                StartingCardSlotList.add(p1CardSlot2);
                StartingCardSlotList.add(NPC1CardSlot2);
                StartingCardSlotList.add(DealerCardSlot2);

                break;
            case 2:
                NPC1Label.setText("NPC1");
                NPC2Label.setText("NPC2");
                NPC3Label.setText(null);
                NPC4Label.setText(null);
                StartingCardSlotList.add(p1CardSlot1);
                StartingCardSlotList.add(NPC1CardSlot1);
                StartingCardSlotList.add(NPC2CardSlot1);
                StartingCardSlotList.add(DealerCardSlot1);

                StartingCardSlotList.add(p1CardSlot2);
                StartingCardSlotList.add(NPC1CardSlot2);
                StartingCardSlotList.add(NPC2CardSlot2);
                StartingCardSlotList.add(DealerCardSlot2);

                break;
            case 3:
                NPC1Label.setText("NPC1");
                NPC2Label.setText("NPC2");
                NPC3Label.setText("NPC3");
                NPC4Label.setText(null);
                StartingCardSlotList.add(p1CardSlot1);
                StartingCardSlotList.add(NPC1CardSlot1);
                StartingCardSlotList.add(NPC2CardSlot1);
                StartingCardSlotList.add(NPC3CardSlot1);
                StartingCardSlotList.add(DealerCardSlot1);

                StartingCardSlotList.add(p1CardSlot2);
                StartingCardSlotList.add(NPC1CardSlot2);
                StartingCardSlotList.add(NPC2CardSlot2);
                StartingCardSlotList.add(NPC3CardSlot2);
                StartingCardSlotList.add(DealerCardSlot2);

                break;
            case 4:
                NPC1Label.setText("NPC1");
                NPC2Label.setText("NPC2");
                NPC3Label.setText("NPC3");
                NPC4Label.setText("NPC4");
                StartingCardSlotList.add(p1CardSlot1);
                StartingCardSlotList.add(NPC1CardSlot1);
                StartingCardSlotList.add(NPC2CardSlot1);
                StartingCardSlotList.add(NPC3CardSlot1);
                StartingCardSlotList.add(NPC4CardSlot1);
                StartingCardSlotList.add(DealerCardSlot1);

                StartingCardSlotList.add(p1CardSlot2);
                StartingCardSlotList.add(NPC1CardSlot2);
                StartingCardSlotList.add(NPC2CardSlot2);
                StartingCardSlotList.add(NPC3CardSlot2);
                StartingCardSlotList.add(NPC4CardSlot2);
                StartingCardSlotList.add(DealerCardSlot2);

                break;
        }
    }


    @FXML
    private AnchorPane playerHandArea;
    //@FXML private AnchorPane panelLoadLabel;
    @FXML
    private AnchorPane dealerHandArea;

    //TODO Need to start making a function to encapsulate the glackjack logic
    //todo START WITH finding out how many players there are and dealing two cards to each
    @FXML
    Label currentActionLabel;
    public void minBet(ActionEvent event) throws InterruptedException {
        startingCardDeal();
    }
    public void startingCardDeal(){
        //TODO NOTE: The cards here are just for visuals. Real cards will b held w/in their
        //todo own classes.
///////////////////////////////
        new Thread(()->{ //use another thread so long process does not block gui
            for(AnchorPane cardSlot : StartingCardSlotList)   {
                //update gui using fx thread
                Platform.runLater(() -> {
                    try {
                        dealSingleCard(cardSlot);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
                try {Thread.sleep(1000);} catch (InterruptedException ex) { ex.printStackTrace();}
            }
        }).start();

    }
    //dealSingleCard is a helper for any action that needs to deal a card
    //TODO Currently deals random card values. need to implement player parameter to read hand value
    public void dealSingleCard(AnchorPane cardSlot) throws InterruptedException {
        String[] cardNums = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] cardSuits = new String[]{"♥","♦","♠","♣"};
        Random rand = new Random();
        int numIdx = rand.nextInt(13);
        int suitIdx = rand.nextInt(4);
        Label sampleCard;
        if(cardSlot != DealerCardSlot2){
            sampleCard = new Label(cardNums[numIdx]+cardSuits[suitIdx]);
        }else{
            sampleCard = new Label(""); //Hidden dealer card
        }
        sampleCard.getStylesheets().add(getClass().getResource("CardStyling.css").toExternalForm());
        if(cardSuits[suitIdx].equals("♥") || cardSuits[suitIdx].equals("♦")){
            sampleCard.getStyleClass().add("redCard");
        }else{
            sampleCard.getStyleClass().add("blackCard");
        }
        if(cardSlot == DealerCardSlot3){
            Integer cardsInSlot = cardSlot.getChildren().size();
            double offset = 16*cardsInSlot;
            cardSlot.getChildren().add(sampleCard);
            sampleCard.setLayoutX(offset); //Horizeontal Card Stack offset
        }else{
            Integer cardsInSlot = cardSlot.getChildren().size();
            double offset = 16*cardsInSlot;
            cardSlot.getChildren().add(sampleCard);
            sampleCard.setLayoutY(offset); //Vertical Card stack offset
        }

        FadeTransition ft = new FadeTransition(Duration.millis(1000), sampleCard);
        ft.setFromValue(0.1);
        ft.setToValue(1.0);
        ft.setCycleCount(1); //Timeline.INDEFINITE
        ft.setAutoReverse(true);
        ft.play();
    }
    public void userHit(ActionEvent event) throws InterruptedException{
        dealSingleCard(p1CardSlot3);
    }
//    public void dealHitCard(AnchorPane pane) throws InterruptedException{
//        String[] cardNums = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
//        String[] cardSuits = new String[]{"♥","♦","♠","♣"};
//        Random rand = new Random();
//        int numIdx = rand.nextInt(13);
//        int suitIdx = rand.nextInt(4);
//        Label sampleCard;
//        if(pane != DealerCardSlot2){
//            sampleCard = new Label(cardNums[numIdx]+cardSuits[suitIdx]);
//        }else{
//            sampleCard = new Label(""); //Hidden dealer card
//        }
//        sampleCard.getStylesheets().add(getClass().getResource("CardStyling.css").toExternalForm());
//        if(cardSuits[suitIdx].equals("♥") || cardSuits[suitIdx].equals("♦")){
//            sampleCard.getStyleClass().add("redCard");
//        }else{
//            sampleCard.getStyleClass().add("blackCard");
//        }
//        Integer cardsInSlot = pane.getChildren().size();
//        double offset = 16*cardsInSlot;
//        pane.getChildren().add(sampleCard);
//        sampleCard.setLayoutY(offset);
//        FadeTransition ft = new FadeTransition(Duration.millis(1000), sampleCard);
//        ft.setFromValue(0.1);
//        ft.setToValue(1.0);
//        ft.setCycleCount(1); //Timeline.INDEFINITE
//        ft.setAutoReverse(true);
//        ft.play();
//
//    }

    public void testNPCHitDeal(ActionEvent event) throws InterruptedException{
        ArrayList<AnchorPane> npcHitSlotList = buildHitSlotList(dealer.npcList.size());
        //Makes a list of all the hit card areas for the npc's and Dealer
        Random rand = new Random();
        new Thread(()->{ //use another thread so long process does not block gui
            //+1 to account for the dealer
            for(int k = 0; k<dealer.npcList.size()+1; k++){
                int numIdx = rand.nextInt(4);

                AnchorPane pane = npcHitSlotList.get(k);
                for(int i =0; i < numIdx+1; i++ ){
                    Platform.runLater(() -> {
                        try {
//                            dealHitCard(hitCardSlot);
                            dealSingleCard(pane);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    try {Thread.sleep(1000);} catch (InterruptedException ex) { ex.printStackTrace();}
                }
                //update gui using fx thread
            }
        }).start();
    }
    public ArrayList<AnchorPane> buildHitSlotList(Integer npcListSize){
        ArrayList<AnchorPane> npcHitSlotList = new ArrayList<AnchorPane>();
        switch (npcListSize) {
            case 0:
                npcHitSlotList.add(DealerCardSlot3);
                break;
            case 1:
                npcHitSlotList.add(NPC1CardSlot3);
                npcHitSlotList.add(DealerCardSlot3);
                break;
            case 2:
                npcHitSlotList.add(NPC1CardSlot3);
                npcHitSlotList.add(NPC2CardSlot3);
                npcHitSlotList.add(DealerCardSlot3);
                break;
            case 3:
                npcHitSlotList.add(NPC1CardSlot3);
                npcHitSlotList.add(NPC2CardSlot3);
                npcHitSlotList.add(NPC3CardSlot3);
                npcHitSlotList.add(DealerCardSlot3);
                break;
            case 4:
                npcHitSlotList.add(NPC1CardSlot3);
                npcHitSlotList.add(NPC2CardSlot3);
                npcHitSlotList.add(NPC3CardSlot3);
                npcHitSlotList.add(NPC4CardSlot3);
                npcHitSlotList.add(DealerCardSlot3);
                break;
        }
        return npcHitSlotList;

    }


    //TODO Delete testDealer stuff later. Used to test that dealer properly instantiates from NPGcontroller
    @FXML
    Label dealerTestLabel;
    public void testDealer(ActionEvent event) throws InterruptedException{
        //Dealer testDealer = new Dealer(1, 2, 2, 1, "Stingo");

        dealerTestLabel.setText(dealer.user.getPlayerName());
    }

    @Override //Populates the Choice box for the # of decks the player wants
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO NOTE no way to get the parameters set before the initialize runs.

    }
}
