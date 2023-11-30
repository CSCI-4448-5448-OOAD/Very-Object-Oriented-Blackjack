package com.example.blackjackgui.command;

import com.example.blackjackgui.model.Dealer;

public class BetCommand extends Command{

    int betAmmount;
    public BetCommand(Dealer target){
        super(target);
        betAmmount = 0;
    }

    public void setBetAmmount(int betAmmount) {
        this.betAmmount = betAmmount;
    }

    public boolean execute(){
        return target.bet(betAmmount);
    }
}
