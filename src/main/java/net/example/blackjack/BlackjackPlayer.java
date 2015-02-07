package net.example.blackjack;

import java.util.Scanner;

public class BlackjackPlayer implements Player{
	final String name;
	private BlackjackHand handOfCards = new BlackjackHand();
	private Scanner input = new Scanner(System.in);
	private String playerInput;
	private boolean keepGoing = true;

	public BlackjackPlayer(String name) {
		this.name = name;
	}

	public void requestCard(Card c) {
		handOfCards.addCard(c);
	}

	public void hitOrStand(BlackjackDeck deck, Blackjack blackjack) {
		System.out.println(this);
		System.out.println("Would you like to HIT or STAND? >>>");
		playerInput = input.nextLine().toUpperCase();

		switch (playerInput) {

		case "HIT":
			System.out.println("Dealing a card.");
			this.hit(deck.getTopCard());
			break;
		case "STAND":
			System.out.println("Standing");
			this.stand(blackjack);
			System.out.println(this);
			break;
		default:
			System.out.println("I didn't understand, please type HIT or STAND");
		}
	}

	public void stand(Blackjack blackJack) {
		blackJack.setGameKeepGoing(false);
	}

	public void hit(Card c) {
		System.out.println(c);
		handOfCards.addCard(c);
		System.out.println(this);
	}

	public BlackjackHand getHand() {
		return handOfCards;
	}

	public String toString() {
		return "Total Score: " + handOfCards.getScore()
				+ ".";
	}

	public boolean getKeepGoing() {
		return keepGoing;
	}

	public void setKeepGoing(boolean keepGoing) {
		this.keepGoing = keepGoing;
	}
}