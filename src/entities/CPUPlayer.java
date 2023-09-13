package entities;

import enums.ComputerLevel;
import enums.PlayerChoice;

public class CPUPlayer extends Player{
	private ComputerLevel level;

	public CPUPlayer(PlayerChoice choice, int score, ComputerLevel level) {
		super(choice, score);
		this.level = level;
	}

	public ComputerLevel getLevel() {
		return level;
	}

	public void setLevel(ComputerLevel level) {
		this.level = level;
	}
	
}
