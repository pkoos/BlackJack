package net.example.blackjack;

import java.util.Random;

public class BlackjackDeck implements Deck {
	final Card cards[];
	private int cardCount = 0;
	private Random random;

	public BlackjackDeck(Random randNum) {
		this.random = randNum;
		int counter = 0;
		cards = new Card[52];
		for(Suit s : Suit.values()) {
			for(Rank r : Rank.values()) {
				cards[counter] = new Card(r,s,Math.min(10, r.ordinal() +1));
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

	public void deal(int numCards, BlackjackPlayer... players) {
		for (int i = 0; i < numCards; i++) {
			for (BlackjackPlayer person: players) {
				person.requestCard(getTopCard());
			}
		}
	}

	public int getRemainingCardCount() {
		return cards.length - cardCount;
	}

}