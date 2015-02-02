package net.example.blackjack;

import java.util.Scanner;

public class Player {
	final String name;
	private int playerScore;
	final Card[] hand;
	private int numCards;
	private Scanner input = new Scanner(System.in);
	private String playerInput;

	public Player(String name) {
		this.name = name;
		hand = new Card[11];
	}

	public void checkHand(Card[] hand) {
		for (Card c : hand) {
			if (c != null) {
				System.out.println(c);
				playerScore += c.getCardValue();
			}
		}
		System.out.println(this);
	}

	public void hitOrStand(Deck deck, Blackjack blackjack) {
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
		blackJack.setKeepGoing(false);
	}

	public void hit(Card c) {
		this.putCards(c);
		System.out.println(c);
		playerScore += c.getCardValue();
		System.out.println(this);
	}

	public void putCards(Card c) {
		this.hand[numCards++] = c;
	}

	// This method may never be used. If that's the case, then it can be
	// removed.
	private void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	
	public void addToPlayerScore(int addition) {
		this.playerScore += addition;
		
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public String toString() {
		return "Total Score: " + playerScore + ".";
	}
}