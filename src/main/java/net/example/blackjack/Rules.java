package net.example.blackjack;

public interface Rules {

	// Not all games use the same type of deck, so this will
	// add the correct deck to the GameSpace.
	public void addDeck(Deck d);
	
	// This controls how cards are dealt within the game.
	public Card deal(Deck d);
	
	// Name is weird, this is supposed to represent a round
	// within the game it represents.
	public void round();
	
	// This method will be used to determine which player
	// is the winner of the specific game and return that
	// player.
	public Player calculateWinner();
	

}
