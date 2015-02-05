package net.example.blackjack;

import java.util.Random;

public class Blackjack {
	final Deck cards;
	final Player human, dealer;
	private boolean gameKeepGoing = true;

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
	
	// This method needs to be reworked, it is currently broken
	private void playerLoop() {
		while ((!over21(human) && this.getKeepGoing())) {
			human.hitOrStand(cards, this);
		}
	}

	private boolean over21(Player player) {
		return player.showHand().calculateHandScore() > 21;
	}

	private void dealerLoop() {
		dealer.setKeepGoing(true);
		while (dealer.getKeepGoing()) {
			if (dealer.showHand().calculateHandScore() > 16) {
				dealer.stand(this);
			} else {
				dealer.hit(cards.getTopCard());
			}
		}

	}

	private String calculateWinner(Player p1, Player p2) {
		if (p1.showHand().calculateHandScore() > p2.showHand()
				.calculateHandScore()) {
			return p1.name;
		} else {
			return p2.name;
		}
	}

	public void setKeepGoing(boolean keepGoing) {
		this.gameKeepGoing = keepGoing;
	}

	public boolean getGameKeepGoing() {
		return this.gameKeepGoing;
	}

	public void blackjackRound(Player... player) {
		while(getGameKeepGoing()) {
			if(over21(player)) {
				setGameKeepGoing(false);
				System.out.println("Player loses!");
			}
			if(over21(dealer)) {
				setGameKeepGoing(false);
				System.out.println("Dealer loses!");
			}
			playerLoop();
			dealerLoop();
		
		}
	}

}