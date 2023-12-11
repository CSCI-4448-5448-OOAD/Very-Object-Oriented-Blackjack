package com.example.blackjackgui.command;
import com.example.blackjackgui.GameTablePageController;
import com.example.blackjackgui.model.Dealer;

public class ResetCommand extends Command{

    public GameTablePageController controller;
    public ResetCommand(Dealer target, GameTablePageController controller){
        super(target);
        this.controller = controller;
    }
    @Override
    public boolean execute() {
//        target.checkEndCondition();
//        controller.clearCards(int playerMoney);
        return false;
    }
}
