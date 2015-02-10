package net.example.blackjack;

import java.util.Random;

public class Blackjack extends CardGame {
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
		System.out.println(calculateWinner(human, dealer) + " wins!");
	}

	// This method needs to be reworked, it is currently broken
	private void playerLoop() {
		while ((!over21(human) && this.getGameKeepGoing())) {
			human.hitOrStand(cards, this);
		}
	}

	private boolean over21(BlackjackPlayer player) {
		return player.checkScore() > 21;
	}

	private void dealerLoop() {
		dealer.setKeepGoing(true);
		while (getGameKeepGoing()) {
			if (dealer.checkScore() > 16) {
				dealer.stand(this);
			} else {
				dealer.hit(cards.getTopCard());
			}
		}

	}

	private String calculateWinner(BlackjackPlayer p1, BlackjackPlayer p2) {
		if (p1.checkScore() > p2.checkScore()) {
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