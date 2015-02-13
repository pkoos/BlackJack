package net.example.blackjack;

import java.util.Collection;

public abstract class Deck<T> {
  abstract T[] getValidCards();

	public void shuffle() { ... }

	public T getTopCard() { ... }

	public void deal(int numCards, Collection<T>... targetHands) {
    ...
  }

	public int getRemainingCardCount() {
    ...
  }
}

interface UnoCard {
  ...
}

class UnoDeck extends Deck<UnoCard> {
  @Override UnoCard[] getValidCards() {
    return new UnoCard[0];
  }
}
