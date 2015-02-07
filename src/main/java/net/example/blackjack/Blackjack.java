package net.example.blackjack;

import java.util.Random;

public class Blackjack extends CardGame {
	final Deck cards;
	final Player human, dealer;
	private boolean gameKeepGoing = true;

	public Blackjack() {
		cards = new Deck(new Random(), this);
		human = new Player("Player");
		dealer = new Player("Dealer");
	}

	public void play() {
		cards.shuffle();
		cards.deal(2, human.getHand(), dealer.getHand());
		human.getHand().checkHand();
		playerLoop();
		dealerLoop();
		System.out.println(calculateWinner(human, dealer) + " wins!");
	}

	// This method needs to be reworked, it is currently broken
	private void playerLoop() {
		while ((!over21(human) && this.getGameKeepGoing())) {
			human.hitOrStand(cards, this);
		}
	}

	private boolean over21(Player player) {
		return player.getHand().calculateBlackjackHandScore() > 21;
	}

	private void dealerLoop() {
		dealer.setKeepGoing(true);
		while (dealer.getKeepGoing()) {
			if (dealer.getHand().calculateBlackjackHandScore() > 16) {
				dealer.stand(this);
			} else {
				dealer.hit(cards.getTopCard());
			}
		}

	}

	private String calculateWinner(Player p1, Player p2) {
		if (p1.getHand().calculateBlackjackHandScore() > p2.getHand()
				.calculateBlackjackHandScore()) {
			return p1.name;
		} else {
			return p2.name;
		}
	}

	public void setGameKeepGoing(boolean keepGoing) {
		this.gameKeepGoing = keepGoing;
	}

	public boolean getGameKeepGoing() {
		return this.gameKeepGoing;
	}

	public void blackjackRound() {
		while (getGameKeepGoing()) {
			if (over21(human)) {
				setGameKeepGoing(false);
				System.out.println("Player loses!");
			}
			if (over21(dealer)) {
				setGameKeepGoing(false);
				System.out.println("Dealer loses!");
			}
			playerLoop();
			dealerLoop();

		}
	}

	public int setCardVal(Card c) {
		return Math.min(10, c.rank.ordinal() + 1);
	}

}