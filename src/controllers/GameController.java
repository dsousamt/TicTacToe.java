package controllers;

import java.util.Scanner;

import entities.CPUPlayer;
import entities.HumanPlayer;

public class GameController {
	
	private HumanPlayer humanPlayer = new HumanPlayer();
	private CPUPlayer cpuPlayer = new CPUPlayer();
	private BoardController boardController = new BoardController();
	private boolean endGame;
	
	public GameController() {}

	public void startGame() {
		Scanner sc = new Scanner(System.in);		
		boardController.showBoard();
		
		System.out.print("Qual o seu nome? ");
		humanPlayer.setName(sc.nextLine());
		
		System.out.print("Qual o nível de dificuldade desejado (Easy / Hard)? ");		
		cpuPlayer.defineComputerLevel(sc.next());
		
		System.out.print("A partida terá quantas rodadas? ");
		for (int i = 1; i <= sc.nextInt(); i++) {
			System.out.println("Rodada " + i + ", " + humanPlayer.getName());
			this.newRound();
		}
		
		sc.close();
	}
	
	public void newRound() {
		Scanner sc = new Scanner(System.in);
		boardController.showBoard();
		System.out.print("Qual é a sua jogada (Coluna, Linha)? ");
		humanPlayer.play(sc.nextInt(), sc.nextInt());
		sc.skip("\\R");
		
		int xHuman = humanPlayer.getColumnValue();
		int yHuman = humanPlayer.getRowValue();
		if (boardController.isPossible(xHuman, yHuman)) {
			System.out.println("é possivel Human");
			boardController.changeBoard(yHuman, xHuman);
		} else {
			System.out.print("Jogada impossível");
			this.newRound();
		}
		
		System.out.print(humanPlayer.getName() + " jogou");
		boardController.showBoard();
		
		cpuPlayer.play();
		while (!boardController.isPossible(cpuPlayer.getColumnValue(), cpuPlayer.getRowValue())) {
			cpuPlayer.play();			
		}
		
		boardController.changeBoard(cpuPlayer.getColumnValue(), cpuPlayer.getRowValue());
		
		System.out.print("CPU jogou");
		boardController.showBoard();
		
		if (boardController.verifyWin()) {
			System.out.println("Houve um vencedor");
			endGame = true;
		} else if (boardController.verifyTie()) {
			System.out.println("Empate - Ninguém ganhou");	
			endGame = true;
		}
		
		sc.close();
	}
}
