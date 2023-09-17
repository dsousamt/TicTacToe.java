package enums;

public enum PlayerChoice {
	
	X("X"),
	O("O");
	
	public final String value;

	private PlayerChoice(String value) {
		this.value = value;
	}	
	
}
