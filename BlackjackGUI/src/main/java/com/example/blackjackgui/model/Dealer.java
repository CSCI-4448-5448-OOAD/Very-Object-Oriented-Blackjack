package com.example.blackjackgui.model;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    public Deck mainDeck;
//    public Hand dealerHand;
    public String npcDifficulty;
    public User user;
    public List<Player> npcList = new ArrayList<>();

    public Dealer(int numDecks, int minBet, int numNPCs, int startingAmount, String playerName, String npcDifficulty){
        // initialize deck, user, and dealer hand.
        this.mainDeck = new Deck(numDecks);
        this.user = User.getInstance(); // get user instance
        this.npcDifficulty = npcDifficulty;
        // set user attributes
        user.setPlayerMoney(startingAmount);
        user.setPlayerName(playerName);
        user.setMinBet(minBet);

//        this.dealerHand = new Hand();
        // create a list of players
        for(int i = 0; i < numNPCs; i++){
            this.npcList.add(new Player(npcDifficulty));
        }
        this.npcList.add(new Player("Dealer")); //THIS IS WHERE DEALER HAND IS GOING
    }
    // initial deal, gives each player, including npcs, two cards
    public void deal() {//deals the first two cards to the player
        for (int i = 0; i < 2; i++) {
            user.drawCard(mainDeck);
            for (Player npc : npcList){
                npc.drawCard(mainDeck);
                //LAST NPC IS DEALER
            }
//            this.dealerDrawCard(mainDeck);
        }
    }
//    public Card dealerDrawCard(Deck deck){
//        Card tmp = deck.pop();
//        dealerHand.addCard(tmp);
//        return tmp;
//    }
//    public void dealerResetHand(){
//        dealerHand.resetHand();
//    }


    // when it is a npc's turn, they hit if they are under 21 no matter what
//    public boolean npcChoice(){
//        for(Player npc : npcList){
//            npc.makeDecision(dealerHand.getTotal());
//        }
//        return
//    }

    public void updateLoss(){
        throw new UnsupportedOperationException("TODO");
    }

    public boolean userHit(){
        if(user.getTotal() < 21) {
            user.drawCard(mainDeck); // player hits
           // npcHit(); // rest of npcs have the opportunity to hit
            return true;
        }
        // player cannot hit, as his total is above 21, bad state
        return false;
    }

    // called when the player is done betting
    //todo fix after we update hit deal
    public boolean stand(){
        if(user.getTotal() > 21)
            return false; // bad state, should have busted

        // npcs make their decisions based on chart

        // dealer hits until total
        while(npcList.get(npcList.size() - 1).getTotal() <= 16)
            npcList.get(npcList.size() - 1).drawCard(this.mainDeck);
            //draw a card to the dealer hand
        if(npcList.get(npcList.size() - 1).getTotal() >= 21){
            // player wins, dealer busts
            playerWin();
        }

        // if dealer reveals higher hand he wins
        if(npcList.get(npcList.size() - 1).getTotal() > user.getTotal()) {
            // dealer wins
            dealerWin();
        }
        else if (npcList.get(npcList.size() - 1).getTotal() < user.getTotal()){
            // player wins
            playerWin();
        }

        // deck and hands are reset
        mainDeck.shuffle();
        user.resetHand();
        for(Player npc : npcList){
            npc.resetHand();
        }
        return true;
    }

    // case where the player wins
    private void playerWin(){
        user.setPlayerMoney((int)(0.5 * user.getCurrentBet()) + user.getPlayerMoney());
    }

    private void dealerWin(){
        user.setPlayerMoney((int)(user.getPlayerMoney() - user.getCurrentBet()));
    }

    public boolean bet(int betAmount){
        // make sure bet is possible
        if((betAmount >= user.getMinBet()) && (betAmount <= user.getPlayerMoney())){
            //if bet amount is greater than minimum && Less than Current balance
            user.bet(betAmount);
            deal();
            return true;
        }
        return false;
    }
    public void setNumDecks(Integer newNum){
        this.mainDeck = new Deck(newNum);
    }
    public Hand getNPCHand(int i){
        return npcList.get(i).getHand();
    }
    public void saveAndExit(){
        throw new UnsupportedOperationException("TODO");
    }
    public boolean npcHit(Player curNPC){
        int startingVal = curNPC.getTotal();
        //check if dealer//
        //curNPC.makeDecision();
        Player dealer = npcList.get(npcList.size() - 1);
        while(curNPC.makeDecision(dealer.getHand())){
            //TODO MAKE A CALCULATION FUNCTION curNPC.makeDecusion(dealerHand);
            // for npc's check if curNPC is the dealer.[list.size()-1] and do different calculation for hit
            Card tmp = this.mainDeck.pop();
            curNPC.getHand().addCard(tmp);
            //if curHand is dealer. if target.hand == curHand
        }
        if(curNPC.getTotal() > startingVal){ //if We did HIT
            return true;
        }
        return false; //NPC STAY
    }
}