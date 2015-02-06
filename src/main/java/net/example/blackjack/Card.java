package net.example.blackjack;

public class Card {
	final Rank rank;
	// final Suit suit;
	private final int cardVal;
	// private final String COLOR;

	public Card(Rank r) {
		rank = r;
		cardVal = Math.min(10, rank.ordinal() + 1);
	}

	public int getCardValue() {
		return cardVal;
	}
	
	public Rank getCardRank() {
		return this.rank;
	}

	public String toString() {
		return "" + getCardRank() + " worth " + getCardValue() + ".";
	}
}
