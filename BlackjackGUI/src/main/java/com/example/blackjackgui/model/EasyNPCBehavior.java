package com.example.blackjackgui.model;

public class EasyNPCBehavior extends NPCBehavior{

    @Override
    boolean makeHitDecision(Hand dealerHand, Hand NPCHand) {
        return (NPCHand.getTotal() < 21);
    }
}
