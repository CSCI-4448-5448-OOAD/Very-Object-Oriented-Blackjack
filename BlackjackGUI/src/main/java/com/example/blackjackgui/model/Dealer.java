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

    public boolean endCondition(){
        //
        if(dealerHand.getTotal() > user.getTotal()){
            throw new UnsupportedOperationException("TODO");
        }
        return false;
    }

    // called when the player is done betting
    public boolean stand(){
        if(user.getTotal() > 21)
            return false; // bad state, should have busted

        while(dealerHand.getTotal() < 17){
            Card tmp = mainDeck.pop();
            dealerHand.addCard(mainDeck.pop());
        }
        throw new UnsupportedOperationException("TODO");

    }

    public boolean bet(int betAmount){
        if(betAmount >= user.getMinBet()){
            user.bet(betAmount);
            return true;
        }
        return false;
    }

    public void saveAndExit(){
        throw new UnsupportedOperationException("TODO");
    }
}