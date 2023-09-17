package entities;

import enums.PlayerChoice;

public abstract class Player {
	
	protected int columnValue;
	protected int rowValue;
	protected PlayerChoice choice;
	
	public Player() {}
	
	public int getCol() {
		return columnValue;
	}

	public int getRow() {
		return rowValue;
	}	

	public PlayerChoice getChoice() {
		return choice;
	}

	public void setChoice(PlayerChoice choice) {
		this.choice = choice;
	}

	public abstract void play();

	public void play(int column, int row) {}
}
