package com.example.blackjackgui.model;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cardStack;
    private Stack<Card> discardStack;

    public Deck(int numDecks){
        // initialize stack
        cardStack = new Stack<Card>();

        // add 52 cards per deck
        for(int decks = 0; decks < numDecks; decks++) {
            for (int i = 1; i <= 13; i++) {
                cardStack.push(new Card(i, Suit.CLUB));
                cardStack.push(new Card(i, Suit.HEART));
                cardStack.push(new Card(i, Suit.DIAMOND));
                cardStack.push(new Card(i, Suit.SPADE));
            }
        }

        //shuffle deck
        shuffle();
    }

    public Card pop(){
        Card tmp = cardStack.pop();
        discardStack.push(tmp);
        return tmp;
    }

    public void shuffle(){
        //TODO CANNOT USE .isEmpty() !!! USE .empty() for Stack var.
        // remove each element from the discard stack and add to card stack
        while (!discardStack.isEmpty()) {
            Card item = discardStack.pop();
            cardStack.push(item);
        }

        Collections.shuffle(cardStack);
    }
}
