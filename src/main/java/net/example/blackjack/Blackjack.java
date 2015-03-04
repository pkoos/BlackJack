package net.example.blackjack;

import java.util.Random;
import java.util.Scanner;

public class Blackjack {
    final BlackjackDeck cards;
    final BlackjackPlayer human, dealer;
    private boolean gameKeepGoing = true;

    public Blackjack() {
        cards = new BlackjackDeck(new Random());
        human = new BlackjackPlayer("Player");
        dealer = new BlackjackPlayer("Dealer");
    }

    public void play() {
            cards.shuffle();
            cards.deal(2, human, dealer);
            human.checkCards();
            System.out.println(human);
            playerLoop();
            dealerLoop();
        System.out.println(calculateWinner(human, dealer));
    }

    public void turn(BlackjackDeck deck, BlackjackPlayer... playerList) {
        for(BlackjackPlayer person : playerList) {
            while(over21(person)) {

            }
        }
    }

    private void playerLoop() {

    }


    private boolean over21(BlackjackPlayer player) {
        return player.checkScore() > 21;
    }

    private void dealerLoop() {

    }


    private String calculateWinner(BlackjackPlayer p1, BlackjackPlayer p2) {

        if (p1.checkScore() == p2.checkScore()) {
            return "It's a push!";
        }
        if (p1.checkScore() > 21) {
            return p2.name + " wins!";
        }
        if (p2.checkScore() > 21) {
            return p1.name + " wins!";
        }
        if (p1.checkScore() > p2.checkScore()) {
            return p1.name + " wins!";
        } else {
            return p2.name + " wins!";
        }
    }

    public void setGameKeepGoing(boolean keepGoing) {
        this.gameKeepGoing = keepGoing;
    }

    public boolean getGameKeepGoing() {
        return this.gameKeepGoing;
    }

    private int setCardVal(Card c) {
        return Math.min(10, c.rank.ordinal() + 1);
    }

    public void hitOrStand(BlackjackDeck deck, BlackjackPlayer player) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine().toUpperCase();
        System.out.println("Would you like to HIT or STAND? >>>");

        switch (input) {

            case "HIT":
                System.out.println("Dealing a card.");
                player.hit(deck.getTopCard());
                break;
        }
    }

}