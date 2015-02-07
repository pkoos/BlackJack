package net.example.blackjack;

import java.util.Random;

public class War {
	final Deck cards;
	final BlackjackPlayer human, computer;

	public War() {
		// This line needs to be corrected
		cards = new WarDeck(new Random());
		human = new BlackjackPlayer("human");
		computer = new BlackjackPlayer("computer");

	}

	public void play() {
		cards.shuffle();
		cards.deal(52, human, computer);

	}

}
