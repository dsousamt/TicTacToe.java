package controllers;

import java.util.List;

import entities.HumanPlayer;
import entities.Player;
import enums.PlayerChoice;
import view.BoardView;

public class BoardController {	

	private BoardView board = new BoardView();
	
	public void showBoard() {
		board.show();
	}
	
	public boolean isPossible(int i, int j) {
		return board.getBoard().get(i).get(j).equals(" ");
	}
	
	public boolean hasWinner(Player p) {
		
		for (int row = 0; row < 3; row++) {
            if (board.getBoard().get(row).get(0).equals(p.getChoice().value) &&
            	board.getBoard().get(row).get(1).equals(p.getChoice().value) &&
            	board.getBoard().get(row).get(2).equals(p.getChoice().value)) {
                	return true;
            }
        }
		
		for (int column = 0; column < 3; column++) {
            if (board.getBoard().get(0).get(column).equals(p.getChoice().value) &&
            	board.getBoard().get(1).get(column).equals(p.getChoice().value) &&
            	board.getBoard().get(2).get(column).equals(p.getChoice().value)) {
                	return true;
            }
        }
		
		//primary diagonal
		if (board.getBoard().get(0).get(0).equals(p.getChoice().value) &&
            board.getBoard().get(1).get(1).equals(p.getChoice().value) &&
            board.getBoard().get(2).get(2).equals(p.getChoice().value)) {
                return true;
            }
		
		//secondary diagonal
		if (board.getBoard().get(0).get(2).equals(p.getChoice().value) &&
	        board.getBoard().get(1).get(1).equals(p.getChoice().value) &&
	        board.getBoard().get(2).get(0).equals(p.getChoice().value)) {
	            return true;
	        }
		
		return false;
	}
	
	public void finalMessage(Player p) {
		if (this.verifyTie()) {
			System.out.println("Empate - Ninguém ganhou\n\n");
		}
		else if (p instanceof HumanPlayer) {
			System.out.println("Parabéns, você venceu!\n\n");
		} else{
			System.out.println("Que pena, você perdeu essa :(\n\n");
		}
	}
	
	public boolean verifyTie() {
		boolean hasEmptySpaces = board.getBoard().stream()
				.flatMap(List::stream)
                .anyMatch(str -> !str.equals(" "));
		return !hasEmptySpaces;
	}
	
	public void addPlayerChoice(Integer i, Integer j, PlayerChoice c) {
		board.getBoard().get(i).set(j, c.value);
	}
	
	public void resetBoard() {
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.getBoard().get(i).set(j, " ");
            }
        }
	}	
}
