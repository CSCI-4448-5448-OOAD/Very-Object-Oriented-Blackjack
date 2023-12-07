package com.example.blackjackgui.command;

import com.example.blackjackgui.GameTablePageController;
import com.example.blackjackgui.model.Dealer;
public class StandCommand extends Command{

    private GameTablePageController controller;
    public StandCommand(Dealer target, GameTablePageController controller){
        super(target);
        this.controller = controller;
    }

    public boolean execute(){
        return target.stand();
        // TODO: reveal dealers card
        controller.revealDealersCard();
    }
}
