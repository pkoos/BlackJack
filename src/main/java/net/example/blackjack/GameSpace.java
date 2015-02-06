package net.example.blackjack;

public interface GameSpace {
	// This includes all the cards that are not part of a deck.
	// I can use countCards from Deck somehow or implement it
	// in another way.
	public int cardsInPlay();

	// This is the method that puts the player into the GameSpace
	// one at a time. This might be implemented as some type of
	// Player collection
	public void addPlayer(Player p);

	// Not sure how to implement this, thinking 2d Collection
	// of some type.
	public void checkVisibleCards();

	// This will load the rules of the game chosen into the
	// GameSpace.
	public void addGameLogic(Logic l);

}
