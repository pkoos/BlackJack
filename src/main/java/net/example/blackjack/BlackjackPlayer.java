package net.example.blackjack;

public class BlackjackPlayer extends Player {
	private BlackjackHand handOfCards = new BlackjackHand();

	public BlackjackPlayer(String name) {
		super(name);
	}

	public void requestCard(Card c) {
		handOfCards.addCard(c);
	}


	public void stand(Blackjack blackJack) {
		blackJack.setGameKeepGoing(false);
	}

	public void hit(Card c) {
		System.out.println(c);
		handOfCards.addCard(c);
		System.out.println(this);
	}

	public int checkScore() {
		return handOfCards.getScore();
	}

	public String toString() {
		return "Total Score: " + checkScore() + ".";
	}

	public void checkCards() {
		handOfCards.checkHand();
	}

	public String getName() {
		return this.name;
	}

}