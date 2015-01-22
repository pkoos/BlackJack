package net.example.blackjack;

import java.util.Random;

public class Deck {
	final Card cards[];
	private static int cardCount = 0;
	int counter = 0;

	public Deck() {
		cards = new Card[52];
		for (int i = 0; i < 4; i++) {
			for (Rank r : Rank.values()) {
				cards[counter] = new Card(r);
				counter++;
			}
		}
	}

	public void shuffle() {
		int newI;
		Card temp;
		Random randIndex = new Random();

		for (int i = 0; i < 1000; i++) {
			newI = randIndex.nextInt(cards.length);
			temp = cards[(i % cards.length)];
			cards[newI] = cards[(i % cards.length)];
		}
	}

	public Card getTopCard() {
		Card temp = cards[cardCount];
		cardCount++;
		if (cardCount == 52) {
			this.shuffle();
			System.out.println("Out of cards, shuffling the deck");
		}
		return temp;
	}

}