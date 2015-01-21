package net.example.blackjack;

public class Player {
	final String name;
	private int playerScore;
	protected Card[] handOfCards = new Card[5];

	public Player(String name) {
		this.name = name;
	}

	/*
	 * public void doubleDown() {
	 * 
	 * }
	 */

	public void checkHand(Card[] cards) {
		for (int i = 0; i < cards.length; i++) {
			System.out.println(cards[i]);
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
		this.handOfCards[handOfCards.length-1] = c;
	}
	
	// This method may never be used. If that's the case, then it can be removed.
	private void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	
	public int getPlayerScore() {
		return playerScore;
	}
}