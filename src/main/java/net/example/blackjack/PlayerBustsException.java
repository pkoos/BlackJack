package net.example.blackjack;

public class PlayerBustsException extends RuntimeException {
	public PlayerBustsException(BlackjackPlayer p) {
		System.out.println(this);
	}

	public String toString(BlackjackPlayer p) {
		return p.getName() + " busts!";
	}
}
