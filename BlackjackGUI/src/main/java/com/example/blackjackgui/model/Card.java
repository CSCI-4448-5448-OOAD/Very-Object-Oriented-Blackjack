package com.example.blackjackgui.model;

public class Card {
    private final int rank;
    private final Suit suit;

    public Card(int rank, Suit suit){
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public int getRank(){
        return this.rank;
    }
}
