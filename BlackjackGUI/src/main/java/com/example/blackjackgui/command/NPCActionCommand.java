package com.example.blackjackgui.command;

import com.example.blackjackgui.GameTablePageController;
import com.example.blackjackgui.model.Dealer;
import com.example.blackjackgui.model.Player;

import java.util.ArrayList;
import java.util.List;

public class NPCActionCommand extends Command{
    GameTablePageController controller;
    Player curNPC;

    public NPCActionCommand(Dealer target, GameTablePageController controller, Player curNPC){
        super(target);
        this.controller = controller;
        this.curNPC = curNPC;
    }
    public boolean npcHit(){
        if(curNPC.getTotal() < 16) {
            //TODO MAKE A CALCULATION FUNCTION
            curNPC.drawCard(target.mainDeck); // player hits
            return true;//NPC HIT
        }
        return false; //NPC STAY
    }
    public boolean execute(){
        //todo make it return true for hit and false for stay
        // allow user to hit until it doesn't make senese
        boolean hitHappened = npcHit();
        if(hitHappened){
            controller.updateHandLabels();
            return true;
        }
        return false;//True for hit //False for Stay
    }
}
