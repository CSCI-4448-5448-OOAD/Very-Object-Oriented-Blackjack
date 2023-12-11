package com.example.blackjackgui.model;

public class NormalNPCBehavior extends NPCBehavior{

    /**
     * Implements a blackjack hit stay chart
     * @param dealerHand set of cards dealer posesses
     * @param NPCHand the NPC's hand
     * @return true if hit, false if stay
     */
    public boolean makeHitDecision(Hand dealerHand, Hand NPCHand){
        int npcTotal = NPCHand.getTotal();

        // soft 17 or less
        if(NPCHand.hasAce() && npcTotal <= 17)
            return true;

        // ace and 7
        if(NPCHand.getSize() == 2 && NPCHand.hasAce() && (NPCHand.getCard(0).getRank() == 7 || NPCHand.getCard(1).getRank() == 7))
            return true;

        // hard values
        if(npcTotal <= 11)
            return true;

        else if(npcTotal >= 17)
            return false;

        else if(npcTotal == 12) {
            int upCardRank = dealerHand.getCard(0).getRank();

            return (upCardRank <= 3 || upCardRank >= 7);
        }
        else if(npcTotal >= 13 && npcTotal <= 16) {
            int upCardRank = dealerHand.getCard(0).getRank();

            return (upCardRank >= 7);
        }
        else
            return false;
    }
}
