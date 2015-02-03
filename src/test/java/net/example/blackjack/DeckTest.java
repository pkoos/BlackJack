package net.example.blackjack;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Random;

import org.junit.Test;

public class DeckTest {

	@Test
	public void can_deal_an_arbitrary_number_of_cards_to_a_list_of_players() {
		// Arrange
		Deck d = new Deck(new Random());
		Player player1 = mock(Player.class);
		Player player2 = mock(Player.class);
		Player player3 = mock(Player.class);
		Player players[] = { player1, player2, player3 };
		// Act
		d.deal(4, player1.showHand(), player2.showHand(), player3.showHand());

		// Assert
		for (Player person : players) {
			verify(person, times(4)).showHand().addCardToHand(any(Card.class));
		}
		// deck is not shuffled, should pull king since 12 card dealt
		assertEquals(Rank.King, d.getTopCard().rank);
	}

	@Test
	public void is_in_sorted_order_by_rank_when_created() {
		// Arrange/Act
		Deck d = new Deck(new Random());

		// Assert
		assertEquals(Rank.Ace, d.getTopCard().rank);
		assertEquals(Rank.Two, d.getTopCard().rank);
		assertEquals(Rank.Three, d.getTopCard().rank);
		assertEquals(Rank.Four, d.getTopCard().rank);
		assertEquals(Rank.Five, d.getTopCard().rank);
		assertEquals(Rank.Six, d.getTopCard().rank);
		assertEquals(Rank.Seven, d.getTopCard().rank);
		assertEquals(Rank.Eight, d.getTopCard().rank);
		assertEquals(Rank.Nine, d.getTopCard().rank);
		assertEquals(Rank.Ten, d.getTopCard().rank);
		assertEquals(Rank.Jack, d.getTopCard().rank);
		assertEquals(Rank.Queen, d.getTopCard().rank);
		assertEquals(Rank.King, d.getTopCard().rank);
		assertEquals(Rank.Ace, d.getTopCard().rank);
	}

	@Test
	public void shuffle_maintains_the_current_size() {
		Deck d = new Deck(new Random());

		d.shuffle();

		assertEquals(52, d.getRemainingCardCount());
	}

	@Test
	public void remainingCardCount_decreases_by_the_number_of_cards_pulled() {
		Deck d = new Deck(new Random());

		for (int i = 0; i < 51; i++) {
			assertEquals(52 - i, d.getRemainingCardCount());
			d.getTopCard();
		}

	}

	@Test
	public void shuffle_randomizes_the_order_of_cards() {
		Random r = new Random();
		r.setSeed(12L);
		Deck d = new Deck(r);

		d.shuffle();

		assertEquals(Rank.Nine, d.getTopCard().rank);
		assertEquals(Rank.Three, d.getTopCard().rank);
		assertEquals(Rank.Queen, d.getTopCard().rank);
		assertEquals(Rank.King, d.getTopCard().rank);
		assertEquals(Rank.Eight, d.getTopCard().rank);
	}

	@Test
	public void shuffle_maintains_four_of_each_card_rank() {
		Random r = new Random();
		r.setSeed(12L);
		Deck d = new Deck(r);

		d.shuffle();

		for (Rank rank : Rank.values()) {
			assertEquals(4, countTheCards(rank, d));
		}

		assertEquals(4, new DeckTest().countTheCards(Rank.Ace, d));

	}

	public int countTheCards(Rank cardRank, Deck deck) {
		int counter = 0;
		for (Card card : deck.cards) {
			if (card.rank == cardRank) {
				counter++;
			}
		}
		return counter;
	}

}