package com.example.blackjackgui.model;

public class NPCDealerBehavior extends NPCBehavior{
    @Override
    boolean makeHitDecision(Hand dealerHand, Hand NPCHand) {
        if(NPCHand.hasAce() && NPCHand.getTotal() == 17)
            return true;

        return NPCHand.getTotal() <= 16;
    }
}
