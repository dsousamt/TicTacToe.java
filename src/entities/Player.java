package entities;

import enums.PlayerChoice;
import exceptions.InvalidOptionException;

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
	
	public void defineChoice(String choice) {
		//this.choice = choice;
		
		if (choice.equalsIgnoreCase(PlayerChoice.X.value)) {
			this.choice = PlayerChoice.X;
		} else if (choice.equalsIgnoreCase(PlayerChoice.O.value)) {
			this.choice = PlayerChoice.O;
		} else {
			throw new InvalidOptionException("Apenas 'X' ou 'O' é permitido");
		}
	}

	public abstract void defineCoordinates();

	public void defineCoordinates(int column, int row) {}
}
