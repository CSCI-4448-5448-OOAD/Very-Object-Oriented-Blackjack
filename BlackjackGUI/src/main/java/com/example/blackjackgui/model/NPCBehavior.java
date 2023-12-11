package com.example.blackjackgui.model;

public abstract class NPCBehavior {

    abstract boolean makeHitDecision(Hand dealerHand, Hand NPCHand);
}
