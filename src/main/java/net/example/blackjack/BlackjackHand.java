package net.example.blackjack;

import java.util.ArrayList;

public class BlackjackHand  {
	private ArrayList<Card> blackjackHand;

	public BlackjackHand() {
		blackjackHand = new ArrayList<Card>();
	}

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
