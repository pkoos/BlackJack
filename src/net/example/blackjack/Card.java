package net.example.blackjack;

public class Card {
	final Rank rank;
	private int cardVal;

	public Card(Rank r) {
		rank = r;
		this.setCardValue();
	}
	
	public void setCardValue() {
		switch(rank) {
		case Ace:
			cardVal = 1;
			break;
		case Two:
			cardVal = 2;
			break;
		case Three:
			cardVal = 3;
			break;
		case Four:
			cardVal = 4;
			break;
		case Five: 
			cardVal = 5;
			break;
		case Six:
			cardVal = 6;
			break;
		case Seven:
			cardVal = 7;
			break;
		case Eight:
			cardVal = 8;
			break;
		case Nine:
			cardVal = 9;
			break;
		case Ten:
			cardVal = 10;
			break;
		case Jack:
			cardVal = 10;
			break;
		case Queen:
			cardVal = 10;
			break;
		case King:
			cardVal = 10;
			break;
		}
	}
	
	public int getCardValue() {
		return cardVal;
	}
	
	public String toString() {
		return "" + this.rank + " worth " + this.cardVal + ".";
	}
}
