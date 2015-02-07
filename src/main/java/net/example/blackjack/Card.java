package net.example.blackjack;

public class Card {
	final Rank rank;
	// final Suit suit;
	private int cardVal;
	// private final String COLOR;
	private boolean visible;

	public Card(Rank r, int cardVal) {
		rank = r;

		this.cardVal = cardVal;
	}

	public int getCardValue() {
		return cardVal;
	}

	public void setCardValue(int cardVal) {
		this.cardVal = cardVal;
	}

	public Rank getCardRank() {
		return this.rank;
	}

	public String toString() {
		return "" + getCardRank() + " worth " + getCardValue() + ".";
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
