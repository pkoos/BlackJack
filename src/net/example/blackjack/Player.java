package net.example.blackjack;

public class Player {
	final String name;
	private int playerScore;
	protected Card[] hand = new Card[5];

	public Player(String name) {
		this.name = name;
	}

	/*
	 * public void doubleDown() {
	 * 
	 * }
	 */

	public void checkHand(Card[] hand) {
		for (int i = 0; i < hand.length; i++) {
			Card temp = hand[i];
			System.out.println(temp);
			System.out.println(playerScore);
		}
		System.out.println("Total score: " + playerScore);
	}

	public void stand() {

	}

	public void hit(Card c) {
			this.putCards(c);
	}
	
	public void putCards(Card c) {
		this.hand[hand.length-1] = c;
	}
	
	// This method may never be used. If that's the case, then it can be removed.
	private void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	
	public int getPlayerScore() {
		return playerScore;
	}
}