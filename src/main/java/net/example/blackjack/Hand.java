package net.example.blackjack;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand;
	private int handScore;

	public Hand() {
		hand = new ArrayList<Card>();
	}

	// This method isn't actually adding the card to
	// the hand.
	public void addCardToHand(Card c) {
		hand.add(c);
		calculateHandScore();
	}

	public void checkHand() {
		for (int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i));
		}
		calculateHandScore();
	}

	public int getHandScore() {
		return handScore;
	}

	public int getHandSize() {
		return hand.size();
	}

	private void calculateHandScore() {
		handScore = 0;
		int maxValue = hand.size();
		for (int i = 0; i < maxValue; i++) {
			handScore += hand.get(i).getCardValue();
		}
	}

}
