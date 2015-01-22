package net.example.blackjack;

public class Card {
	final Rank rank;
	private final int cardVal;

	public Card(Rank r) {
		rank = r;
		cardVal = Math.min(10, rank.ordinal() + 1);
	}

	public int getCardValue() {
		return cardVal;
	}

	public String toString() {
		return "" + this.rank + " worth " + this.cardVal + ".";
	}
}
