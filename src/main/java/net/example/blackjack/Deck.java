package net.example.blackjack;

import java.util.Random;

public class Deck {
	final Card cards[];
	private int cardCount = 0;
	private Random random;
	
	// The deck needs to get some information from 
	// the game rules, which isn't receiving currently
	public Deck(Random randNum, CardGame gametype) {
		this.random = randNum;
		int counter = 0;
		cards = new Card[52];
		for (int i = 0; i < 4; i++) {
			for (Rank r : Rank.values()) {
				// This line needs to be fixed to operate and
				// link to Blackjack
				cards[counter] = new Card(r,10);
				counter++;
			}
		}
	}

	public void shuffle() {
		Card tempCard;
		int newA;
		int newB;

		for (int i = 0; i < 1000; i++) {
			newA = random.nextInt(cards.length);
			newB = random.nextInt(cards.length);

			tempCard = cards[newA];
			cards[newA] = cards[newB];
			cards[newB] = tempCard;
		}
	}

	public Card getTopCard() {
		Card temp = cards[cardCount];
		cardCount++;
		if (cardCount == 52) {
			this.shuffle();
			System.out.println("Out of cards, shuffling the deck");
			cardCount = 0;
		}
		return temp;
	}

	public void deal(int numCards, Hand... listOfHands) {
		for (int i = 0; i < numCards; i++) {
			for (Hand playerHand : listOfHands) {
				playerHand.addCardToHand(getTopCard());
			}
		}
	}

	public int getRemainingCardCount() {
		return cards.length - cardCount;
	}

}