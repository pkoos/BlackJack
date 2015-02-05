package net.example.blackjack;

import java.util.ArrayList;

public class Hand implements HandInterface {
	private ArrayList<Card> hand;

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

	public int getHandSize() {
		return hand.size();
	}

	// And boom goes the dynamite!
	public int calculateHandScore() {
		int handScore = 0;
		boolean hasAce = false;
		int maxValue = hand.size();
		for (int i = 0; i < maxValue; i++) {
			if(hand.get(i).getCardRank() == Rank.Ace) {
				hasAce = true;
			}
			handScore += hand.get(i).getCardValue();
		}
		if(hasAce && handScore <= 11) {
			handScore +=10;
		}
		return handScore;
	}
	
}
