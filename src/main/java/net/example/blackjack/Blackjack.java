package net.example.blackjack;

import java.util.Random;

public class Blackjack extends CardGame {
	final BlackjackDeck cards;
	final BlackjackPlayer human, dealer;
	private boolean gameKeepGoing = true;

	public Blackjack() {
		cards = new BlackjackDeck(new Random());
		human = new BlackjackPlayer("Player");
		dealer = new BlackjackPlayer("Dealer");
	}

	public void play() {
        try {
            cards.shuffle();
            cards.deal(2, human, dealer);
            human.checkCards();
            System.out.println(human);
                playerLoop();
                dealerLoop();
        } catch (PlayerBustsException e) {

        }
        System.out.println(calculateWinner(human, dealer));
	}

	private void playerLoop() throws PlayerBustsException {
		while ((this.getGameKeepGoing())) {
			if (over21(human)) {
				throw new PlayerBustsException(human, "busts!");
			}
			human.hitOrStand(cards, this);
		}
	}

	private boolean over21(BlackjackPlayer player) {
		return player.checkScore() > 21;
	}

	private void dealerLoop() throws PlayerBustsException {
		dealer.checkCards();
		setGameKeepGoing(true);
		while (getGameKeepGoing()) {
            if(over21(dealer)) {
                throw new PlayerBustsException(dealer,"busts!");
            }
			if (dealer.checkScore() > 16) {
				dealer.stand(this);
			} else {
				dealer.hit(cards.getTopCard());
			}
		}

	}

	private String calculateWinner(BlackjackPlayer p1, BlackjackPlayer p2) {

        if (p1.checkScore() == p2.checkScore()) {
            return "It's a push!";
        }
		if (p1.checkScore() > 21) {
			return p2.name + " wins!";
		}
		if (p2.checkScore() > 21) {
			return p1.name + " wins!";
		}
		if (p1.checkScore() > p2.checkScore()) {
			return p1.name + " wins!";
		} else {
			return p2.name + " wins!";
		}
	}

	public void setGameKeepGoing(boolean keepGoing) {
		this.gameKeepGoing = keepGoing;
	}

	public boolean getGameKeepGoing() {
		return this.gameKeepGoing;
	}
    	public int setCardVal(Card c) {
		return Math.min(10, c.rank.ordinal() + 1);
	}

	public boolean bust(BlackjackPlayer p) {

		return p.checkScore() > 21;
	}

}