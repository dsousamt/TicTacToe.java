package entities;

public abstract class Player {
	
	protected int columnValue;
	protected int rowValue;
	protected int score;
	
	public Player() {}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	
	
	public int getColumnValue() {
		return columnValue;
	}

	public int getRowValue() {
		return rowValue;
	}

	public abstract void play();

	public void play(int column, int row) {}
}
