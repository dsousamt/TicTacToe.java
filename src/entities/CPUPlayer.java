package entities;

import enums.ComputerLevel;
import enums.PlayerChoice;

public class CPUPlayer extends Player{
	private ComputerLevel level;

	/*public CPUPlayer(PlayerChoice choice, int score, ComputerLevel level) {
		super(choice, score);
		this.level = level;
	}*/

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
	
	public PlayerChoice play() {
		if (this.level == ComputerLevel.HARD) {
			System.out.println("Jogada inteligente");
			return PlayerChoice.OPTION1;
		} else if (this.level == ComputerLevel.EASY) {
			System.out.println("Jogada aleatória");
			return PlayerChoice.OPTION2;
		} else {
			System.out.println("Não setou o level");
			return PlayerChoice.OPTION1;
		}
	}
	
}
