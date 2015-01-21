package net.example.blackjack;

import java.util.Scanner;

public class Blackjack {
	private Scanner input = new Scanner(System.in);
	private String playerInput = "";
	final Deck cards;
	final Player human, dealer;
	private boolean keepGoing = true;

	public Blackjack() {
		cards = new Deck();
		human = new Player("Player");
		dealer = new Player("Dealer");
	}

	public void play() {
		cards.shuffle();
		cards.deal(human, dealer);
		human.checkHand(human.hand);
		playerLoop();
		dealerLoop();
		System.out.println(calculateWinner(human, dealer) + " wins!");
	}

	public void hitOrStand(Player player) {
		System.out.println("Would you like to HIT or STAND? >>>");
		playerInput = input.nextLine().toUpperCase();
		switch (playerInput) {

		case "HIT":
			System.out.println("Dealing a card.");
			player.hit(cards.getTopCard());
			break;
		case "STAND":
			System.out.println("Standing");
			player.stand(this);
			System.out.println(player);
			break;
		default:
			System.out.println("I didn't understand, please type HIT or STAND");
		}

	}

	private void playerLoop() {
		while ((human.getPlayerScore() <= 21) && keepGoing) {
			hitOrStand(human);
		}
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

}
