package com.example.blackjackgui.command;

import com.example.blackjackgui.GameTablePageController;
import com.example.blackjackgui.model.Dealer;

public class HitCommand extends Command{

    GameTablePageController controller;

    public HitCommand(Dealer target, GameTablePageController controller){
        super(target);
        this.controller = controller;
    }

    public boolean execute(){
        if(!target.userHit()){
            return false;
        }

        //Update gametable Page controllers view
        controller.updateHands();

        return true;
    }
}
