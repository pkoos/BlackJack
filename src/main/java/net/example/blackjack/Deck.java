package net.example.blackjack;

public interface Deck {
	public void shuffle();

	public Card getTopCard();

	public void deal(int numCards, BlackjackPlayer... players);

	public int getRemainingCardCount();
}
