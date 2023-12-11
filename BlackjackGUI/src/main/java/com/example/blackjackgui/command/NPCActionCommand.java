package com.example.blackjackgui.command;

import com.example.blackjackgui.GameTablePageController;
import com.example.blackjackgui.model.Card;
import com.example.blackjackgui.model.Dealer;
import com.example.blackjackgui.model.Hand;
import com.example.blackjackgui.model.Player;

import java.util.ArrayList;
import java.util.List;

public class NPCActionCommand extends Command{
    GameTablePageController controller;
    Player curNPC;
//    Hand curHand;

    public NPCActionCommand(Dealer target, GameTablePageController controller, Player curNPC){
        super(target);
        this.controller = controller;
        this.curNPC = curNPC;
//        this.curHand = curHand;
    }
    public boolean npcHit(){
        int startingVal = curNPC.getTotal();
        while(curNPC.getTotal() < 30) {
            //TODO MAKE A CALCULATION FUNCTION
            // for npc's check if curNPC is the dealer.[-1] and do different calculation for hit
            Card tmp = target.mainDeck.pop();
            curNPC.getHand().addCard(tmp);
            //if curHand is dealer. if target.hand == curHand
        }
        if(curNPC.getTotal() > startingVal){ //if We did HIT
            return true;
        }
        return false; //NPC STAY
    }
    public boolean execute(){
        //todo make it return true for hit and false for stay
        // allow user to hit until it doesn't make senese
        boolean hitHappened = npcHit();
        if(hitHappened){
            //controller.updateHandLabels();
            return true;
        }
        return false;//True for hit //False for Stay
    }
}
