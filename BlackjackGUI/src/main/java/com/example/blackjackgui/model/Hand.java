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
        int numAces = 0;
        for(Card currentCard : cards){

            int rank = currentCard.getRank();

            if(rank == 1){// aces
                numAces++;
                total += 11;
            }

            else if(rank <= 10) {// number cards
                total += rank;
            }

            else{// face cards
                total += 10;
            }

            while(numAces > 0 && total > 21){
                total -= 10;
                numAces--;
            }
        }

        return total;
    }

    public boolean hasAce(){
        for(Card card : cards) {
            if(card.getRank() == 1)
                return true;
        }
        return false;
    }

    public int getSize(){
        return cards.size();
    }

    public void resetHand(){
        cards.clear();
    }
}
