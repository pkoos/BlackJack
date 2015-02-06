package net.example.blackjack;

import java.util.ArrayList;

public class BlackjackGamespace implements GameSpace {
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private BlackjackLogic blackjackLogic = new BlackjackLogic();

	
	public BlackjackGamespace(BlackjackLogic blackjackLogic, Player... players) {
		for(Player person : players) {
			addPlayer(person);
		}
		this.blackjackLogic = blackjackLogic;
	}

	@Override
	public int cardsInPlay() {
		// This includes all cards that are not in the deck
		return 0;
	}

	@Override
	public void addPlayer(Player p) {
		playerList.add(p);		
	}

	@Override
	public void checkVisibleCards() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addGameLogic(Logic l) {
		// TODO Auto-generated method stub
		
	}

}
