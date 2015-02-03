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
		cards.deal(2, human.showHand(), dealer.showHand());
		human.showHand().checkHand();
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
		return player.showHand().getHandScore() > 21;
	}

	// This is an infinite loop at this point, the
	// score isn't updating correctly.
	private void dealerLoop() {
		keepGoing = true;
		while (keepGoing) {
			if (dealer.showHand().getHandScore() > 16) {
				dealer.stand(this);
			} else {
				dealer.hit(cards.getTopCard());
			}
		}

	}

	private String calculateWinner(Player p1, Player p2) {
		if (p1.showHand().getHandScore() > p2.showHand().getHandScore()) {
			return p1.name;
		} else {
			return p2.name;
		}
	}

	public void setKeepGoing(boolean keepGoing) {
		this.keepGoing = keepGoing;
	}

	public boolean getKeepGoing() {
		return this.keepGoing;
	}

}