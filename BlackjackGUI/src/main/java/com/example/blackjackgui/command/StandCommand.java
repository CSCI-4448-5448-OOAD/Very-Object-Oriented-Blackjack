package com.example.blackjackgui.command;

import com.example.blackjackgui.model.Dealer;
public class StandCommand extends Command{
    public StandCommand(Dealer target){
        super(target);
    }

    public boolean execute(){
        return target.stand();

        // TODO: reveal dealers card
    }
}
