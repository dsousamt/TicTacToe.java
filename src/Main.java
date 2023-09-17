import controllers.GameController;
import exceptions.InvalidOptionException;

public class Main {
	public static void main(String[] args) {
		
		try {
			GameController ticTacToe = new GameController();		
			ticTacToe.startGame();
		} catch (InvalidOptionException e) {
			System.out.println("Erro: " + e.getMessage());
		}	
		
	}
}
