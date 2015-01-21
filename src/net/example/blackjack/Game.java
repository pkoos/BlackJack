package net.example.blackjack;

public class Game {
	public static void main(String args[]) {
		System.out.println("Game started...");

		Blackjack game = new Blackjack();
		game.play();
		//Deck d = new Deck();
		//d.shuffle(); 
	}
	
}
