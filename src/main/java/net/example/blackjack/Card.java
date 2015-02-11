package net.example.blackjack;

public class Card {
	final Rank rank;
	final Suit suit;
	private int cardVal;
	private String color;
	private boolean visible;

	public Card(Rank r, Suit s, int cardVal) {
		rank = r;
		suit = s;
		color = setColor(s);

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

	public Suit getCardSuit() {
		return this.suit;
	}

	public String getCardColor() {
		return this.color;
	}

	private String setColor(Suit s) {
		if (s == Suit.Club || s == Suit.Spade) {
			return "Black";
		} else {
			return "Red";
		}

	}

	public String toString() {
		StringBuffer sb = new StringBuffer();

		return sb.append(getCardRank()).append(" of ").append(getCardSuit())
				.append("s (").append(getCardColor()).append(") worth ")
				.append(getCardValue()).append(".").toString();

	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
