package net.example.blackjack;

public class Blackjack {
	final Deck cards;
	final Player human, dealer;
	private boolean keepGoing = true;

	public Blackjack() {
		cards = new Deck();
		human = new Player("Player");
		dealer = new Player("Dealer");
	}

	public void play() {
		cards.shuffle();
		cards.deal(2, human, dealer);
		human.checkHand(human.hand);
		playerLoop();
		dealerLoop();
		System.out.println(calculateWinner(human, dealer) + " wins!");
	}
	private void playerLoop() {
		while ((human.getPlayerScore() <= 21) && keepGoing) {
			human.hitOrStand(cards, this);
		}
	}

	private void dealerLoop() {
		boolean keepGoing = true;
		while (keepGoing) {
			if (dealer.getPlayerScore() > 16) {
				dealer.stand(this);

			} else {
				dealer.hit(cards.getTopCard());
			}
		}

	}

	private Player calculateWinner(Player p1, Player p2) {
		if (p1.getPlayerScore() > p2.getPlayerScore()) {
			return p1;
		} else {
			return p2;
		}
	}

	public void setKeepGoing(boolean keepGoing) {
		this.keepGoing = keepGoing;
	}

}