package com.example.blackjackgui.model;

public class User extends Player{

    private String playerName;
    private int playerMoney;
    private int minBet;

    PlayerAction actionType;

    public User(String playerName, int startingMoney, int minBet){
        // TODO: make hand with factory?
        super();
        this.playerMoney = startingMoney;
        this.playerName = playerName;

        // TODO: instantiate actionType
        // actionType =
    }

    public int getTotal(){
        return getHand().getTotal();
    }

}
