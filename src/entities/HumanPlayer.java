package entities;

import enums.PlayerChoice;

public class HumanPlayer extends Player{
	
	private String name;

	public HumanPlayer(PlayerChoice choice, int score, String name) {
		super(choice, score);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
