package com.example.blackjackgui.command;

import com.example.blackjackgui.model.Dealer;

public abstract class Command {
    Dealer target;

    Command(Dealer target){
        this.target = target;
    }

    // if execute returns true, the action was a success, and the view can be updated,
    // otherwise do nothing
    public abstract boolean execute();
}
