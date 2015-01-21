package net.example.blackjack;

import java.util.Scanner;

public class Blackjack {
	private Scanner input = new Scanner(System.in);
	private String playerInput = "";
	final Deck cards;
	final Player human, dealer;

	public Blackjack() {
		cards = new Deck();
		human = new Player("Player");
		dealer = new Player("Dealer");
	}

	public void play() {
		cards.shuffle();
		cards.deal(human, dealer);
		human.checkHand(human.hand);
		System.out.println("Would you like to HIT or STAND? >>>");
		playerInput = input.nextLine().toUpperCase();
		hitOrStand(human, playerInput);
	}

	public void hitOrStand(Player player, String answer) {
		
		switch (answer) {

		case "HIT":
			System.out.println("Dealing a card.");
			player.hit(cards.getTopCard());
			break;
		case "STAND":
			System.out.println("Standing");
			player.stand();
			break;
		default:
			System.out.println("I didn't understand, please type HIT or STAND");
		}
		
	}

	private Player calculateWinner(Player p1, Player p2) {
		if (p1.getPlayerScore() > p2.getPlayerScore()) {
			return p1;
		} else {
			return p2;
		}
	}

}
