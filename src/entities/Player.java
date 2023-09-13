package entities;

import enums.PlayerChoice;

public abstract class Player {
	
	protected PlayerChoice choice;
	protected int score;
	
	public Player() {
	}

	public Player(PlayerChoice choice, int score) {
		this.choice = choice;
		this.score = score;
	}

	public PlayerChoice getChoice() {
		return choice;
	}

	public void setChoice(PlayerChoice choice) {
		this.choice = choice;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	
	
}
