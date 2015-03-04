package net.example.blackjack;

public class HumanPlayer extends Player implements PlayerAction{

    public HumanPlayer(String name) {
        super(name);
    }

    public boolean act() {
        return true;
    }
}
