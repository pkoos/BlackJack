package net.example.blackjack;

public interface Hand {
	public void addCard(Card c);

	public void checkHand();

	public int getHandSize();
}
