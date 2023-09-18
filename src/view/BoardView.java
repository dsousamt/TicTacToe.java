package view;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

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
		System.out.println("\n  0 1 2");
		AtomicInteger lineCount = new AtomicInteger(0);
		board.getBoard().stream()
			.forEach((e) -> {
				System.out.print(lineCount.getAndIncrement());
				System.out.print("|");
				e.forEach((j) -> System.out.print(j + "|"));
		        System.out.println();
			});
		System.out.println();
	}
	
}
