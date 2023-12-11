package com.example.blackjackgui;
import com.example.blackjackgui.model.*;
import com.example.blackjackgui.command.*;

import javafx.animation.FadeTransition;
import javafx.fxml.Initializable;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class GameTablePageController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Command currentCommand;
    Dealer dealer;
    //User user;
    public void switchToStartingPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartingPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //TODO need to load a dealer instead

    public void loadDealer(int numDecks, int minBet, int numNPCs, int startingAmount, String playerName){
        this.dealer = new Dealer(numDecks, minBet, numNPCs, startingAmount, playerName);
        cardsRemaining.setText(Integer.toString(dealer.mainDeck.getCardStack().size()) + " - Cards Remaining");
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
    Button minBetButton;
    @FXML
    Button customBetButton;
    @FXML
    Button hitButton;
    @FXML
    Button stayButton;
    public void enableStartingButtons(){
        //Enables betting buttons. Disables play buttons
        minBetButton.setDisable(false);//enabled
        customBetButton.setDisable(false);//enabled
        hitButton.setDisable(true);//disabled
        stayButton.setDisable(true);//disabled
    }
    public void enablePlayButtons(){
        minBetButton.setDisable(true);//disabled
        customBetButton.setDisable(true);//disabled
        hitButton.setDisable(false);//enabled
        stayButton.setDisable(false);//enabled
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
    List<Hand> HandList = new ArrayList<Hand>();
    @FXML
    Label p1HandLabel;
    @FXML
    Label NPC1HandLabel;
    @FXML
    Label NPC2HandLabel;
    @FXML
    Label NPC3HandLabel;
    @FXML
    Label NPC4HandLabel;
    @FXML
    Label DealerHandLabel;
    List<Label> HandLabelList = new ArrayList<Label>();
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
                NPC1Label.setText(null);
                NPC2Label.setText(null);
                NPC3Label.setText(null);
                NPC4Label.setText(null);
                StartingCardSlotList.add(p1CardSlot1);
                StartingCardSlotList.add(DealerCardSlot1);

                StartingCardSlotList.add(p1CardSlot2);
                StartingCardSlotList.add(DealerCardSlot2);

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
    @FXML
    Label cardsRemaining;
    public void minBet(ActionEvent event) throws InterruptedException {
        //account for bet
        currentCommand = new BetCommand(dealer,this);
        if (!currentCommand.execute()){
           // improper bet, display somehow
        }
        else{
            // disable betting for the rest of the round
        }
//        dealer.bet(dealer.user.getMinBet());//Subtract from user total, Deal invis cards
    }

    /**
     * TODO Custom bet button handler
     */
    @FXML
    TextField customBetField;
    public void customBet(ActionEvent event) throws InterruptedException {
        //account for bet
        int customBet = Integer.parseInt(customBetField.getText());
        currentCommand = new BetCommand(dealer,this, customBet);
        if (!currentCommand.execute()){ //if false
            // improper bet, display somehow
            //TODO throw an error or message for invalid bet.

        }
        else{//if true
            // disable betting for the rest of the round
        }
//        dealer.bet(dealer.user.getMinBet());//Subtract from user total, Deal invis cards
    }

    /**
     * TODO Hit button handler
     */
    public void userHit(ActionEvent event) throws InterruptedException{
        currentCommand = new HitCommand(dealer,this);
        if (!currentCommand.execute()){ //if false
            // improper bet, display somehow
            //TODO throw an error or message for invalid bet.
        }
        else{//if true
            // disable betting for the rest of the round
            //display the new card()
            dealSingleCard(dealer.user.getHand().getCard(2).getCardString(),p1CardSlot3);
        }
    }

    /**
     * TODO Stay button handler
     */



    public void startingDeal(){
        //TODO chop this.
        currentBalanceLabel.setText(Integer.toString(dealer.user.getPlayerMoney()));//set balance label
        AtomicInteger cardSlotIDX = new AtomicInteger(0);
        AtomicInteger cardFirstSecond = new AtomicInteger(0);
        new Thread(()->{
            for(int ib = 0; ib<2; ib++){ //Loop 1 time for card 1. Loop 2nd time for card 2
                for(Hand curHand : HandList){ //looping through the different players
                    Platform.runLater(() -> {
                        try {
                            //cardFirstSecond mod 2 gives either 0 or 1 for the card index we want
                            String cardString = curHand.getCard((cardFirstSecond.get()%2)).getCardString();
                            dealSingleCard(cardString,StartingCardSlotList.get(cardSlotIDX.get()));
                            //perform deal card
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    try {Thread.sleep(1000);} catch (InterruptedException ex) { ex.printStackTrace();}
                    cardSlotIDX.getAndIncrement();
                }
                cardFirstSecond.getAndIncrement();
            }
        }).start();
        cardsRemaining.setText(Integer.toString(dealer.mainDeck.getCardStack().size()) + " - Cards Remaining");
        enablePlayButtons();
    }

//    public void startingCardDeal(Dealer dealer){
//        //TODO NOTE: The cards here are just for visuals. Real cards will b held w/in their
//        //todo own classes.
/////////////////////////////////
//        new Thread(()->{ //use another thread so long process does not block gui
//            for(AnchorPane cardSlot : StartingCardSlotList)   {
//                //update gui using fx thread
//                Platform.runLater(() -> {
//                    try {
//                        dealSingleCard(cardSlot);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//                try {Thread.sleep(1000);} catch (InterruptedException ex) { ex.printStackTrace();}
//            }
//        }).start();
//
//    }
    //dealSingleCard is a helper for any action that needs to deal a card
    //TODO Currently deals random card values. need to implement player parameter to read hand value
    public void dealSingleCard(String cardString, AnchorPane cardSlot) throws InterruptedException {
        String[] cardNums = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] cardSuits = new String[]{"♥","♦","♠","♣"};
        Random rand = new Random();
        int numIdx = rand.nextInt(13);
        int suitIdx = rand.nextInt(4);


        Label sampleCard;
        if(cardSlot != DealerCardSlot2){
//            sampleCard = new Label(cardNums[numIdx]+cardSuits[suitIdx]);
            sampleCard = new Label(cardString);


        }else{
            sampleCard = new Label(""); //Hidden dealer card
        }
        sampleCard.getStylesheets().add(getClass().getResource("CardStyling.css").toExternalForm());
        if(cardString.contains("♥") || cardString.contains("♦")){
            sampleCard.getStyleClass().add("redCard");
        }else{
            sampleCard.getStyleClass().add("blackCard");
        }
        if(cardSlot == DealerCardSlot3){ //calculate the offset for generating an additional card
            Integer cardsInSlot = cardSlot.getChildren().size();
            double offset = 16*cardsInSlot;
            cardSlot.getChildren().add(sampleCard);
            sampleCard.setLayoutX(offset); //Horizontal Card Stack offset
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

    //Builds a list of all the 3rd card slots
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

    public void loadHandList(int npcNumber){
        //loads hand list in accordance with the table order
        HandList.add(dealer.user.getHand()); //load user hand
        HandLabelList.add(p1HandLabel);
        for(int i = 0; i < npcNumber; i++){
            HandList.add(dealer.getNPCHand(i)); //add each npc hand
        }
        switch(npcNumber) {
            case 0:
                //no npcs
                HandList.add(dealer.dealerHand); //add the dealer
                HandLabelList.add(DealerHandLabel);
                break;
            case 1:
                HandLabelList.add(NPC1HandLabel);

                HandList.add(dealer.dealerHand); //add the dealer
                HandLabelList.add(DealerHandLabel);
                break;
            case 2:
                HandLabelList.add(NPC1HandLabel);
                HandLabelList.add(NPC2HandLabel);

                HandList.add(dealer.dealerHand); //add the dealer
                HandLabelList.add(DealerHandLabel);
                break;
            case 3:
                HandLabelList.add(NPC1HandLabel);
                HandLabelList.add(NPC2HandLabel);
                HandLabelList.add(NPC3HandLabel);

                HandList.add(dealer.dealerHand); //add the dealer
                HandLabelList.add(DealerHandLabel);
                break;
            case 4:
                HandLabelList.add(NPC1HandLabel);
                HandLabelList.add(NPC2HandLabel);
                HandLabelList.add(NPC3HandLabel);
                HandLabelList.add(NPC4HandLabel);

                HandList.add(dealer.dealerHand); //add the dealer
                HandLabelList.add(DealerHandLabel);
                break;
        }//load npcHandLabels
;
    }
    public void updateHandLabels(){
        //loop through user, npc list, and dealer
        int curNPC = 0;
        p1HandLabel.setText(Integer.toString(dealer.user.getHand().getTotal())) ;
        for(int i=0; i<HandLabelList.size(); i++){
            if(i > 0 && i<(HandLabelList.size()-1)){ // updates only the npc labels
                //updates when i between 1 and idx of last element
                HandLabelList.get(i).setText(Integer.toString(dealer.npcList.get(curNPC).getHand().getTotal()));
                curNPC++;
            }else{

            }
        }
        DealerHandLabel.setText(Integer.toString(dealer.dealerHand.getTotal()));
    }
    /**
     * TODO Update Hand value labels
     */

    public String returnHandString(){
        return "lol";
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
