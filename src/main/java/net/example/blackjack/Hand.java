package net.example.blackjack;

import java.util.ArrayList;

public class Hand  {
	private ArrayList<Card> hand;

	public Hand() {
		hand = new ArrayList<Card>();
	}

	// Works only with Blackjack, needs to be adjusted
	public void addCardToHand(Card c) {
		hand.add(c);
		calculateBlackjackHandScore();
	}

	public void checkHand() {
		for (int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i));
		}
		calculateBlackjackHandScore();
	}

	public int getHandSize() {
		return hand.size();
	}

	// And boom goes the dynamite!
	// This was originally calculateHandScore(),
	// and only works for Blackjack. This method
	// needs to be refactored to work with more
	//than one game. 2/6/15 3:26pm
	public int calculateBlackjackHandScore() {
		int handScore = 0;
		boolean hasAce = false;
		int maxValue = hand.size();
		for (int i = 0; i < maxValue; i++) {
			if (hand.get(i).getCardRank() == Rank.Ace) {
				hasAce = true;
			}
			handScore += hand.get(i).getCardValue();
		}
		if (hasAce && handScore <= 11) {
			handScore += 10;
		}
		return handScore;
	}

}
