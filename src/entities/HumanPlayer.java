package entities;

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
	
	@Override
	public void play(int row, int column) {
		super.columnValue = column;
		super.rowValue = row;
	}

	@Override
	public void play() {}

}
