package controllers;

import view.BoardView;

public class BoardController {	

	private BoardView boardView = new BoardView();
	
	public void showBoard() {
		boardView.show();
	}
	
	public boolean isPossible(int i, int j) {
		if (boardView.getBoard().get(i).get(j).equals(" ")) {			
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifyWin() {
		// verifica se alguem acertou a sequencia
		return false;
	}
	
	public boolean verifyTie() {
		return false;
	}
	
	public void changeBoard(Integer i, Integer j) {
		boardView.getBoard().get(i).set(j, "X");
	}
}
