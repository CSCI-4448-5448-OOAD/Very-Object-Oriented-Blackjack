package com.example.blackjackgui.command;

import com.example.blackjackgui.GameTablePageController;
import com.example.blackjackgui.model.Dealer;

public class BetCommand extends Command{

    private int betAmmount;
    private GameTablePageController controller;
    public BetCommand(Dealer target, GameTablePageController controller){
        super(target);
        this.controller = controller;
        betAmmount = target.user.getMinBet();
    }

    public BetCommand(Dealer target, GameTablePageController controller, int customBetAmount){
        super(target);
        this.controller = controller;
        betAmmount = customBetAmount;
    }

    public void setBetAmmount(int betAmmount){
        this.betAmmount = betAmmount;
    }

    public boolean execute(){
        // updating the state of the game to begin dealing 2 cards per person
        if(!target.bet(betAmmount)) {
            return false;
        }

        // update the GameTablePageContollers card view
        controller.startingDeal();
        controller.updateHandLabels();

        return true;
    }
}
