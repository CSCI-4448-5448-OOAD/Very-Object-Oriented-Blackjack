package com.example.blackjackgui.model;

public class Player {

    private Hand playerHand;
    private NPCBehavior hitBehavior;

    public Player(String difficulty){
        if(difficulty.equals("Easy"))
            hitBehavior = new EasyNPCBehavior();

        else if(difficulty.equals("Dealer"))
            hitBehavior = new NPCDealerBehavior();

        else
            hitBehavior = new NormalNPCBehavior();

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
    public boolean makeDecision(Hand dealerHand){
        return hitBehavior.makeHitDecision(dealerHand,this.playerHand);
    }

    public Card drawCard(Deck deck){
        Card tmp = deck.pop();
        playerHand.addCard(tmp);
        return tmp;
    }
    public int getTotal(){
        return getHand().getTotal();
    }
}
