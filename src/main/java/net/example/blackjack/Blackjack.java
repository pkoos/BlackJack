package net.example.blackjack;

import java.util.Random;

public class Blackjack {
	final Deck cards;
	final Player human, dealer;
	private boolean keepGoing = true;

	public Blackjack() {
		cards = new Deck(new Random());
		human = new Player("Player");
		dealer = new Player("Dealer");
	}

	public void play() {
		cards.shuffle();
		cards.deal(2, human, dealer);
		human.checkHand(human.hand);
		playerLoop();
		dealerLoop();
		System.out.println(calculateWinner(human, dealer) + " wins!");
	}

	private void playerLoop() {
		while ((!over21(human) && this.getKeepGoing())) {
			human.hitOrStand(cards, this);
		}
	}

	private boolean over21(Player player) {
		return player.getPlayerScore() > 21;
	}

	private void dealerLoop() {
		boolean keepGoing = true;
		while (keepGoing) {
			if (dealer.getPlayerScore() > 16) {
				dealer.stand(this);
			} else {
				dealer.hit(cards.getTopCard());
			}
		}

	}

	private Player calculateWinner(Player p1, Player p2) {
		if (p1.getPlayerScore() > p2.getPlayerScore()) {
			return p1;
		} else {
			return p2;
		}
	}

	public void setKeepGoing(boolean keepGoing) {
		this.keepGoing = keepGoing;
	}
	
	public  boolean getKeepGoing() {
		return this.keepGoing;
	}

}