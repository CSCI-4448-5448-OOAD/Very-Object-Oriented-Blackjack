package com.example.blackjackgui.model;

public class User extends Player{

    private String playerName;
    private int playerMoney;
    private int minBet;

    private int currentBet;

    PlayerAction actionType;

    public User(String playerName, int startingMoney, int minBet){
        //
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
    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String newName){
        playerName = newName;
    }
    public Integer getPlayerMoney(){
        return playerMoney;
    }
    public void setPlayerMoney(Integer newMoney){
        playerMoney = newMoney;
    }


    public int getMinBet(){
        return minBet;
    }
    public void setMinBet(int newMin){
        minBet = newMin;
    }
    public int getCurrentBet(){
        return currentBet;
    }
    public void setCurrentBet(Integer newBet){
        currentBet = newBet;
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
