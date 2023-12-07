package com.example.blackjackgui.command;

import com.example.blackjackgui.model.Dealer;

public class HitCommand extends Command{

    public HitCommand(Dealer target){
        super(target);
    }

    public boolean execute(){
        return target.userHit();
    }
}
