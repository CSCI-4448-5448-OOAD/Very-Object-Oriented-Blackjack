package com.example.blackjackgui.model;

import java.util.List;

public class Dealer {
    Deck mainDeck;
    Hand dealerHand;
    User user;
    List<Player> npcList;

    public Dealer(int numDecks, int minBet, int numNPCs, int startingAmount, String playerName){

        // initialize deck, user, and dealer hand.
        this.mainDeck = new Deck(numDecks);
        this.user = new User(playerName,startingAmount,minBet);
        this.dealerHand = new Hand();

        // create a list of players
        for(int i = 0; i < numNPCs; i++)
            npcList.add(new Player());
    }

    // initial deal, gives each player, including npcs, two cards
    public void deal() {
        for(int i = 0; i < 2; i++) {
            user.drawCard(mainDeck);
            for (Player npc : npcList)
                npc.drawCard(mainDeck);
        }
    }



    // TODO: For whenever a card is dealt to a player the table
    public void updatePlayerHand(){
        throw new UnsupportedOperationException("TODO");
    }

    // For when the player makes their decision to hit or stay
    // it iterates to the next npc or dealer
    public void updateTurn(){
        throw new UnsupportedOperationException("TODO");
    }

    // Update balance of winners
    public void updatePayout(){
        throw new UnsupportedOperationException("TODO");
    }

    // update balance of losers
    public void updateLoss(){
        throw new UnsupportedOperationException("TODO");
    }

    public void minBet(){
        throw new UnsupportedOperationException("TODO");
    }

    public void customBet(int bet) {
        throw new UnsupportedOperationException("TODO");
    }

    public void playerHit(){
        throw new UnsupportedOperationException("TODO");
    }

    public void saveAndExit(){
        throw new UnsupportedOperationException("TODO");
    }
}