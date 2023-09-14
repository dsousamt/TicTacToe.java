package entities;

import java.util.Random;

import enums.ComputerLevel;

public class CPUPlayer extends Player{
	
	private ComputerLevel level;
	
	public ComputerLevel getLevel() {
		return level;
	}

	public void defineComputerLevel(String level) {
		if (level.equalsIgnoreCase("hard")) {
			this.level = ComputerLevel.HARD;
		} else {
			this.level = ComputerLevel.EASY;			
		}
	}
	
	public int randomChoice() {
		return new Random().ints(0,2).findFirst().getAsInt();
	}
	
	@Override
	public void play(int column, int row) {}

	@Override
	public void play() {
		super.columnValue = randomChoice();
		super.rowValue = randomChoice();
	}
}
