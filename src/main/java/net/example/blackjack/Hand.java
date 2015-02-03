package net.example.blackjack;

import java.util.ArrayList;
import java.util.Iterator;

public class Hand {
	private ArrayList<Card> hand;
	private int handScore;

	public Hand() {
		hand = new ArrayList<Card>();
	}

	public void addCardToHand(Card c) {
		hand.add(c);
	}

	public void checkHand() {
		for (int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i));
			handScore += hand.get(i).getCardValue();
		}
	}

	public void calculateAceScore() {

	}

	public void initialHandScore(int handScore) {

	}

	public void changeHandScore() {

	}

	public int getHandScore() {

		return handScore;
	}

	public int getHandSize() {
		return hand.size();
	}
}
