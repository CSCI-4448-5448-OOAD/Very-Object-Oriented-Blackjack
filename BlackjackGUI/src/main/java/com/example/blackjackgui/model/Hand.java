package com.example.blackjackgui.model;

import java.util.List;
import java.util.ArrayList;

public class Hand {
    public List<Card> cards;

    public Hand(){
        cards = new ArrayList<Card>();
    }

    public void addCard(Card addedCard){
        cards.add(addedCard);
    }

    public Card getCard(int index){
        return cards.get(index);
    }
    public Card getLastCard(){
        return cards.get(cards.size() -1);
    }

    /**
     * @return highest card value that isn't a bust
     */
    public int getTotal(){
        int total = 0;
        for(Card currentCard : cards){
            total += currentCard.getRank();
        }
        return total;
    }

    /**
     * @return String of all possible hand combinations
     */
    public String getTotalString(){
        return "";
    }

    public int getSize(){
        return cards.size();
    }

    public void resetHand(){
        cards.clear();
    }
}
