package entities;

import java.util.Random;

import enums.ComputerLevel;
import exceptions.InvalidOptionException;

public class CPUPlayer extends Player{
	
	private ComputerLevel level;
	
	public ComputerLevel getLevel() {
		return level;
	}

	public void defineComputerLevel(String level) {
		if (level.equalsIgnoreCase("hard")) {
			this.level = ComputerLevel.HARD;
		} else if (level.equalsIgnoreCase("easy")) {
			this.level = ComputerLevel.EASY;			
		} else {
			throw new InvalidOptionException("Escolha entre 'Easy' e 'Hard'");
		}
		System.out.println("Dificuldade alterada para " + this.level + " !");
	}
	
	public int randomChoice() {
		return new Random().nextInt(0, 3);
	}
	
	@Override
	public void defineCoordinates(int row, int column) {}

	@Override
	public void defineCoordinates() {
		super.columnValue = randomChoice();
		super.rowValue = randomChoice();
	}
}
