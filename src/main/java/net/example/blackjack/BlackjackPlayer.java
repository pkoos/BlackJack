package net.example.blackjack;

public class BlackjackPlayer extends Player implements PlayerAction {
	private BlackjackHand handOfCards = new BlackjackHand();
    final String name;

	public BlackjackPlayer(String name) {
		this.name = name;
	}

	public void getCard(Card c) {
		handOfCards.addCard(c);
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

    @Override
    public boolean hit(String input) {
        return input.equals("Y");
    }
}