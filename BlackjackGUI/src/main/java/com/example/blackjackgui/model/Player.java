package com.example.blackjackgui.model;

public class Player {
    private Hand playerHand;
    private int playerMoney;

    PlayerAction actionType;

    public Player(int startingMoney){
        // TODO: make hand with factory?
        playerHand = new Hand();
        this.playerMoney = startingMoney;

        // TODO: instantiate actionType
        // actionType =
    }

    public int getTotal(){
        return playerHand.getTotal();
    }

    public Hand getHand(){
        return this.playerHand;
    }
}
