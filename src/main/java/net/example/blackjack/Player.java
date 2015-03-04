package net.example.blackjack;


public abstract class Player {
    final String name;
    BlackjackHand cards = new BlackjackHand();
    public Player(String name) {
        this.name = name;
    }


}
