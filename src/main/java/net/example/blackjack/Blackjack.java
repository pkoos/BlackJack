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

		// This exception not working correctly, does not display correct
		// message
		try {
			playerLoop();
			dealerLoop();
		} catch (PlayerBustsException e) {
			System.out.println(e);
		}
		// playerLoop();
		// dealerLoop();
		System.out.println(calculateWinner(human, dealer) + " wins!");
	}

	private void playerLoop() throws PlayerBustsException {
		while ((this.getGameKeepGoing())) {
			if (over21(human)) {
				throw new PlayerBustsException(human);
			}
			human.hitOrStand(cards, this);
		}
	}

	private boolean over21(BlackjackPlayer player) {
		return player.checkScore() > 21;
	}

	private void dealerLoop() {
		dealer.checkCards();
		setGameKeepGoing(true);
		while (getGameKeepGoing()) {
			if (dealer.checkScore() > 16) {
				dealer.stand(this);
			} else {
				dealer.hit(cards.getTopCard());
			}
		}

	}

	private String calculateWinner(BlackjackPlayer p1, BlackjackPlayer p2) {

		if (p1.checkScore() > 21) {
			return p2.name;
		}
		if (p2.checkScore() > 21) {
			return p1.name;
		}
		if (p1.checkScore() == p2.checkScore()) {
			return "It's a push!";
		}
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

	public boolean bust(BlackjackPlayer p) {

		return p.checkScore() > 21;
	}

}