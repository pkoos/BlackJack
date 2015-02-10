package net.example.blackjack;

public interface DeckInterface {
	public Card getTopCard();

	public void shuffle();
	
	// This might be better named as putBackCard
	public void addCard();
}
