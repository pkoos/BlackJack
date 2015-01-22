package net.example.blackjack;

public class Player {
	final String name;
	private int playerScore;
	final Card[] hand;
	private int numCards;

	public Player(String name) {
		this.name = name;
		hand = new Card[5];
	}

	public void checkHand(Card[] hand) {
		for (int i = 0; i < hand.length; i++) {
			Card temp = hand[i];
			if(temp != null) {
				System.out.println(temp);
				playerScore += temp.getCardValue();
			}
		}
		System.out.println(this);
	}

	public void stand(Blackjack blackJack) {
		blackJack.setKeepGoing(false);
	}

	public void hit(Card c) {
			this.putCards(c);
			System.out.println(c);
			playerScore += c.getCardValue();
			System.out.println(this);
	}
	
	public void putCards(Card c) {
		this.hand[numCards++] = c;
	}
	
	// This method may never be used. If that's the case, then it can be removed.
	private void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	
	public int getPlayerScore() {
		return playerScore;
	}
	
	public String toString() {
		return "Total Score: " + playerScore + ".";
	}
}