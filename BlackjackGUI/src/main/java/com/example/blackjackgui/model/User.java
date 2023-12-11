package com.example.blackjackgui.model;

public class User extends Player{

    private static final User userInstance = new User();
    private String playerName;
    private int playerMoney;
    private int minBet;
    private int currentBet;
    PlayerAction actionType;

    private User(){
        super("None");
        this.playerMoney = 0;
        this.playerName = "None";
        this.currentBet = 0;
        this.minBet = 0;

        // TODO: instantiate actionType
        // actionType =
    }



    public static User getInstance(){
        return userInstance;
    }


    public String getPlayerName(){
        return playerName;
    }
    public Integer getPlayerMoney(){
        return playerMoney;
    }
    public void setPlayerMoney(Integer newMoney){
        playerMoney = newMoney;
    }
    public void setPlayerName(String newName){
        playerName = newName;
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

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public void setActionType(PlayerAction actionType) {
        this.actionType = actionType;
    }

    public boolean bet(int bet){
        if(bet >= minBet && bet <= playerMoney){ //if money is in bounds
            playerMoney = playerMoney - bet;
            currentBet = bet;
            return true;
        }
        return false;
    }

}
