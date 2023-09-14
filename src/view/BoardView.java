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
		
		System.out.print("  ");
		for (int column = 0; column < 3; column++) {
			System.out.print(column + " ");
		}
		
		System.out.println();
		
		int row = 0;
		for (ArrayList<String> item : board.getBoard()) {
			
			System.out.print(row);				
			
			System.out.print("|");
			for (String subItem : item) {
				System.out.print(subItem + "|");
			}
			
			row++;
			System.out.println();
		}
		
		System.out.println();
	}
}
