package com.example.blackjackgui.model;

public class User extends Player{

    private String playerName;
    private int playerMoney;
    private int minBet;

    private int currentBet;

    PlayerAction actionType;

    public User(String playerName, int startingMoney, int minBet){
        // TODO: make hand with factory?
        super();
        this.playerMoney = startingMoney;
        this.playerName = playerName;
        this.currentBet = 0;
        this.minBet = minBet;

        // TODO: instantiate actionType
        // actionType =
    }

    public int getTotal(){
        return getHand().getTotal();
    }

    public int getMinBet(){
        return minBet;
    }
    
    public boolean bet(int bet){
        if(bet >= minBet && bet < playerMoney){
            playerMoney -= bet;
            currentBet = bet;
            return true;
        }
        return false;
    }

}
