package entities;

import java.util.ArrayList;

public class Board {
	protected ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();

	public ArrayList<ArrayList<String>> getBoard() {
		return board;
	}

	public void createBoard() {
		for (int i = 0; i < 3; i++) {
			board.add(new ArrayList<String>());
			for (int j = 0; j < 3; j++) {
				board.get(i).add(" ");
			}
		}
	}
}

