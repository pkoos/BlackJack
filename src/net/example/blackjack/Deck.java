package net.example.blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	final ArrayList<Card> deck = new ArrayList<Card>();
	//final Card cards[];
	private static int cardCount = 0;

	
	// I need to find a way to get all the cards in the deck using ArrayList.
	public Deck() {
		//int counter = 0;
		//cards = new Card[52];
		for (int i = 0; i < 4; i++) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r));
				System.out.println(deck.get(i));
				//cards[i] = new Card(r);
				//counter++;
				//System.out.println(cards[i]);
			}
		}
	}

	// credit goes to
	// http://pages.cs.wisc.edu/~hasti/cs302/examples/Exception/Deck.java
	public void shuffle() {
		int newI;
		Card temp;
		Random randIndex = new Random();

		for (int i = 0; i < 52; i++) {
			newI = randIndex.nextInt(deck.size());
			temp = deck.get(i);
			deck.add(newI,temp);
			temp = deck.get(newI);
		}
	}

	public Card getTopCard() {
		Card temp = deck.get(cardCount);
		cardCount++;
		if (cardCount == 52) {
			this.shuffle();
			System.out.println("Out of cards, shuffling the deck");
		}
		return temp;
	}
	
	public void deal(Player p1, Player p2) {
		for(int i = 0;i<2;i++) {
			p1.putCards(getTopCard());
			p2.putCards(getTopCard());
		}
	}
	
	
	
}