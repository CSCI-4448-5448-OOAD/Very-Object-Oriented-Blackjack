package com.example.blackjackgui.command;

import com.example.blackjackgui.model.Dealer;

public abstract class Command {
    Dealer target;
    Controller controller;



    Command(Dealer target, Controller controller){
        this.target = target;
        this.controller = controller;
    }

    public abstract boolean execute();
}
