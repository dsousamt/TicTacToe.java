package controllers;

import enums.PlayerChoice;
import view.BoardView;

public class BoardController {	

	private BoardView boardView = new BoardView();
	
	public void showBoard() {
		boardView.show();
	}
	
	public boolean isPossible(int i, int j) {
		return boardView.getBoard().get(i).get(j).equals(" ");
	}
	
	public boolean verifyWin(String choice) {
		
		for (int row = 0; row < 3; row++) {
            if (boardView.getBoard().get(row).get(0).equals(choice) &&
            	boardView.getBoard().get(row).get(1).equals(choice) &&
            	boardView.getBoard().get(row).get(2).equals(choice)) {
                	return true;
            }
        }
		
		for (int column = 0; column < 3; column++) {
            if (boardView.getBoard().get(0).get(column).equals(choice) &&
            	boardView.getBoard().get(1).get(column).equals(choice) &&
            	boardView.getBoard().get(2).get(column).equals(choice)) {
                	return true;
            }
        }
		
		//primary diagonal
		if (boardView.getBoard().get(0).get(0).equals(choice) &&
            boardView.getBoard().get(1).get(1).equals(choice) &&
            boardView.getBoard().get(2).get(2).equals(choice)) {
                return true;
            }
		
		//secondary diagonal
		if (boardView.getBoard().get(0).get(2).equals(choice) &&
	        boardView.getBoard().get(1).get(1).equals(choice) &&
	        boardView.getBoard().get(2).get(0).equals(choice)) {
	            return true;
	        }
		
		return false;
	}
	
	public boolean verifyTie() {
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardView.getBoard().get(i).get(j).equals(" ")) {
                    return false;
                }
            }
        }
        return true;
	}
	
	public void addPlayerChoice(Integer i, Integer j, PlayerChoice c) {
		boardView.getBoard().get(i).set(j, c.value);
	}
	
}
