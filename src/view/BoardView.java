package view;

import java.util.ArrayList;

import entities.Board;

public class BoardView {
	
	private Board board = new Board();	
	
	public BoardView() {
		board.createBoard();
	}

	public ArrayList<ArrayList<String>> getBoard() {
		return board.getBoard();
	}
	
	public void show() {
		System.out.println();
		for (ArrayList<String> item : board.getBoard()) {
			System.out.print("|");
			for (String subItem : item) {
				System.out.print(subItem + "|");
			}
			System.out.println();
		}
		System.out.println();
	}
}
