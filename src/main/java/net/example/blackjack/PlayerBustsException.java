package net.example.blackjack;

public class PlayerBustsException extends Exception {
    public PlayerBustsException(BlackjackPlayer p, String message) {
        System.out.println(p.getName() + " " + message);

    }

}
