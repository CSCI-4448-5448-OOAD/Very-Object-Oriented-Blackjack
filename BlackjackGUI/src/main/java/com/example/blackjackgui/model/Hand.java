package com.example.blackjackgui.model;

import java.util.List;

public class Hand {
    private List<Card> cards;

    public void addCard(Card addedCard){
        cards.add(addedCard);
    }

    public Card getCard(int index){
        return cards.get(index);
    }

    public int getTotal(){
        int total = 0;
        for(Card currentCard : cards){
            total += currentCard.getRank();
        }
        return total;
    }

    public int getSize(){
        return cards.size();
    }

    public void resetHand(){
        cards.clear();
    }
}
