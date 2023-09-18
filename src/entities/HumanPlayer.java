package entities;

import exceptions.InvalidOptionException;

public class HumanPlayer extends Player{
	
	private String name;
	
	public HumanPlayer() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean hasUserName() {
		if (this.name == null)
			return false;
		else
			return true;
	}
	
	@Override
	public void defineCoordinates(int r, int c) {
		super.columnValue = c;
		super.rowValue = r;
		if ((r < 0 || r > 2) || (c < 0 || c > 2)) {
			throw new InvalidOptionException("As coordenadas não são válidas");
		}
	}

	@Override
	public void defineCoordinates() {}

}
