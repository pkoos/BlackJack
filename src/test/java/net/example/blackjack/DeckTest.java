package net.example.blackjack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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

		// Act
		d.deal(4, player1, player2, player3);

		// Assert
		verify(player1, times(4)).putCards(any(Card.class));
		verify(player2, times(4)).putCards(any(Card.class));
		verify(player3, times(4)).putCards(any(Card.class));
		// deck is not shuffled, should pull king since 12 card dealt
		assertEquals(Rank.King, d.getTopCard().rank);
	}

	@Test
	public void brand_new_deck_is_in_sorted_order_by_rank() {
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

		assertEquals(52, d.getRemainingCardCount());
		d.getTopCard();
		assertEquals(51, d.getRemainingCardCount());
		d.getTopCard();
		assertEquals(50, d.getRemainingCardCount());
		d.getTopCard();
		assertEquals(49, d.getRemainingCardCount());
		d.getTopCard();
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
		int countAce = 0;
		int countTwo = 0;
		int countThree = 0;
		int countFour = 0;
		int countFive = 0;
		int countSix = 0;
		int countSeven = 0;
		int countEight = 0;
		int countNine = 0;
		int countTen = 0;
		int countJack = 0;
		int countQueen = 0;
		int countKing = 0;

		d.shuffle();

		assertEquals(4, new DeckTest().countTheCards(Rank.Ace, d, countAce));
		assertEquals(4, new DeckTest().countTheCards(Rank.Two, d, countTwo));
		assertEquals(4, new DeckTest().countTheCards(Rank.Three, d, countThree));
		assertEquals(4, new DeckTest().countTheCards(Rank.Four, d, countFour));
		assertEquals(4, new DeckTest().countTheCards(Rank.Five, d, countFive));
		assertEquals(4, new DeckTest().countTheCards(Rank.Six, d, countSix));
		assertEquals(4, new DeckTest().countTheCards(Rank.Seven, d, countSeven));
		assertEquals(4, new DeckTest().countTheCards(Rank.Eight, d, countEight));
		assertEquals(4, new DeckTest().countTheCards(Rank.Nine, d, countNine));
		assertEquals(4, new DeckTest().countTheCards(Rank.Ten, d, countTen));
		assertEquals(4, new DeckTest().countTheCards(Rank.Jack, d, countJack));
		assertEquals(4, new DeckTest().countTheCards(Rank.Queen, d, countQueen));
		assertEquals(4, new DeckTest().countTheCards(Rank.Queen, d, countKing));

	}

	public int countTheCards(Rank cardRank, Deck deck, int counter) {
		for (Card card : deck.cards) {
			if (card.rank == cardRank) {
				counter++;
			}
		}
		return counter;
	}

}