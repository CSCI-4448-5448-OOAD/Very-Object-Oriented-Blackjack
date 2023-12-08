package com.example.blackjackgui.model;

public class Card {
    private final int rank;
    private final Suit suit;

    String[] cardNums;
    String[] cardSuits;

    public Card(int rank, Suit suit){
        this.suit = suit;
        this.rank = rank;
        //14 Labels
        cardNums = new String[]{"None","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        cardSuits = new String[]{"♠","♣","♥","♦"};
    }

    public Suit getSuit(){
        return this.suit;
    }

    public int getRank(){
        return this.rank;
    }

    public String getCardString(){
        return cardNums[this.rank] + cardSuits[this.suit.ordinal()];
    }
}