package com.example.blackjackgui.model;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    Deck mainDeck;
    Hand dealerHand;
    public User user;
    List<Player> npcList = new ArrayList<>();

    public Dealer(int numDecks, int minBet, int numNPCs, int startingAmount, String playerName){
        // initialize deck, user, and dealer hand.
        this.mainDeck = new Deck(numDecks);
        this.user = new User(playerName,startingAmount,minBet);
        this.dealerHand = new Hand();
        // create a list of players
        for(int i = 0; i < numNPCs; i++){
            this.npcList.add(new Player());
        }
    }
    // initial deal, gives each player, including npcs, two cards
    public void deal() {
        for (int i = 0; i < 2; i++) {
            user.drawCard(mainDeck);
            for (Player npc : npcList)
                npc.drawCard(mainDeck);
        }
    }



    // Update balance of winners
    public void updatePayout(){
        throw new UnsupportedOperationException("TODO");
    }

    // when it is a npc's turn, they hit if they are under 21 no matter what
    public void npcHit(){
        for(Player npc : npcList){
            if(npc.getHand().getTotal() < 21)
                npc.drawCard(mainDeck);
        }
    }

    public void updateLoss(){
        throw new UnsupportedOperationException("TODO");
    }

    public boolean playerHit(){
        if(user.getTotal() < 21) {
            user.drawCard(mainDeck); // player hits
            npcHit(); // rest of npcs have the opportunity to hit
            return true;
        }
        // player cannot hit, as his total is above 21, bad state
        return false;
    }

    // called when the player is done betting
    public boolean stand(){
        if(user.getTotal() > 21)
            return false; // bad state, should have busted

        // npcs make their decisions based on chart

        // dealer hits until total
        while(dealerHand.getTotal() <= 16)
            dealerHand.addCard(mainDeck.pop());

        if(dealerHand.getTotal() >= 21){
            // player wins, dealer busts
            playerWin();
        }

        // if dealer reveals higher hand he wins
        if(dealerHand.getTotal() > user.getTotal()) {
            // dealer wins
            dealerWin();
        }
        else if (dealerHand.getTotal() < user.getTotal()){
            // player wins
            playerWin();
        }

        // deck and hands are reset
        mainDeck.shuffle();
        user.resetHand();
        for(Player npc : npcList){
            npc.resetHand();
        }
        return true;
    }

    // case where the player wins
    private void playerWin(){
        user.setPlayerMoney((int)(0.5 * user.getCurrentBet()) + user.getPlayerMoney());
    }

    private void dealerWin(){
        user.setPlayerMoney((int)(user.getPlayerMoney() - user.getCurrentBet()));
    }

    public boolean bet(int betAmount){
        // make sure bet is possible
        if(betAmount >= user.getMinBet()){
            user.bet(betAmount);
            deal();
            return true;
        }
        return false;
    }
    public void setNumDecks(Integer newNum){
        this.mainDeck = new Deck(newNum);
    }
    public void saveAndExit(){
        throw new UnsupportedOperationException("TODO");
    }
}