package com.example.blackjackgui.model;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> CardStack;

    public Deck(int numDecks){
        // initialize stack
        CardStack = new Stack<Card>();

        // add 52 cards per deck
        for(int decks = 0; decks < numDecks; decks++) {
            for (int i = 0; i < 13; i++) {
                CardStack.push(new Card(i, Suit.CLUB));
                CardStack.push(new Card(i, Suit.HEART));
                CardStack.push(new Card(i, Suit.DIAMOND));
                CardStack.push(new Card(i, Suit.SPADE));
            }
        }

        //shuffle deck
        shuffle();
    }

    public Card pop(){
        return CardStack.pop();
    }

    public void shuffle(){
        Collections.shuffle(CardStack);
    }
}
