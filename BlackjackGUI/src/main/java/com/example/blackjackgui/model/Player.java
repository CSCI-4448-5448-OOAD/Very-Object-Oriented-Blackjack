package com.example.blackjackgui.model;

public class Player {
    private Hand playerHand;

    private boolean stand;

    public Player(){
        stand = false;
        playerHand = new Hand();
    }

    public Hand getHand(){
        return this.playerHand;
    }

    public void resetHand(){
        playerHand.resetHand();
    }

    public Card drawCard(Deck deck){
        Card tmp = deck.pop();
        playerHand.addCard(tmp);
        return tmp;
    }
}
