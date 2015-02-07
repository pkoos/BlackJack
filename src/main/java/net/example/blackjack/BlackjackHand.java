package net.example.blackjack;

import java.util.ArrayList;

public class BlackjackHand implements Hand {
	private ArrayList<Card> blackjackHand;

	public BlackjackHand() {
		blackjackHand = new ArrayList<Card>();
	}

	// Works only with Blackjack, needs to be adjusted
	public void addCard(Card c) {
		blackjackHand.add(c);
		getScore();
	}

	public void checkHand() {
		for (int i = 0; i < blackjackHand.size(); i++) {
			System.out.println(blackjackHand.get(i));
		}
		getScore();
	}

	public int getHandSize() {
		return blackjackHand.size();
	}

	// And boom goes the dynamite!
	// This was originally calculateHandScore(),
	// and only works for Blackjack. This method
	// needs to be refactored to work with more
	// than one game. 2/6/15 3:26pm
	public int getScore() {
		int handScore = 0;
		boolean hasAce = false;
		int maxValue = blackjackHand.size();
		for (int i = 0; i < maxValue; i++) {
			if (blackjackHand.get(i).getCardRank() == Rank.Ace) {
				hasAce = true;
			}
			handScore += blackjackHand.get(i).getCardValue();
		}
		if (hasAce && handScore <= 11) {
			handScore += 10;
		}
		return handScore;
	}

}
