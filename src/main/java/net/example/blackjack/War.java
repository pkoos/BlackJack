package net.example.blackjack;

import java.util.Random;

public class War {
	final Deck cards;
	final Player human, computer;
	public War() {
		// This line needs to be corrected
		cards = new Deck(new Random(), new Blackjack());
		human = new Player("human");
		computer = new Player("computer");
		
	}
	
	public void play() {
		cards.shuffle();
		cards.deal(52,human.getHand(),computer.getHand());
		
	}

}
