package com.example.blackjackgui.model;

public class Player {
    private Hand playerHand;

    public Player(){
        playerHand = new Hand();
    }

    public Hand getHand(){
        return this.playerHand;
    }

    public Card drawCard(Deck deck){
        Card tmp = deck.pop();
        playerHand.addCard(deck.pop());
        return tmp;
    }
}
