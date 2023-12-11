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

    /**
     *
     * @param dealerHandValue value of the dealers hand
     */
    public void makeDecision(int dealerHandValue){
        int playerHandValue = playerHand.getTotal();

        // implement chart, if hitting, draw card
    }

    public Card drawCard(Deck deck){
        Card tmp = deck.pop();
        playerHand.addCard(tmp);
        return tmp;
        //going to circumvent this in hand.java instead.
    }
    public int getTotal(){
        return getHand().getTotal();
    }
}
