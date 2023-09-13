package enums;

public enum PlayerChoice {
	
	OPTION1("x"),
	OPTION2("o");
	
	public final String label;

	private PlayerChoice(String label) {
		this.label = label;
	}	
	
}
