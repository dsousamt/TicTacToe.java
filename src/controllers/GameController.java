package controllers;

import java.util.Scanner;

import entities.CPUPlayer;
import entities.HumanPlayer;

public class GameController {
	
	private Scanner sc = new Scanner(System.in);	
	private HumanPlayer humanPlayer = new HumanPlayer();
	private CPUPlayer cpuPlayer = new CPUPlayer();
	private BoardController boardController = new BoardController();
	private boolean endGame;
	
	public GameController() {}

	public void startGame() {
		
		System.out.print("Qual o seu nome? ");
		humanPlayer.setName(this.sc.nextLine());
		
		System.out.print("Qual o nível de dificuldade desejado (Easy / Hard)? ");		
		cpuPlayer.defineComputerLevel(this.sc.next());
		
		System.out.print("A partida terá quantas rodadas? ");
		int nRound = sc.nextInt();
		for (int i = 1; i <= nRound; i++) {
			
			while (!endGame) {
				System.out.println("\nRodada " + i + ", " + humanPlayer.getName());
				this.newRound();
			}
		}
	}
	
	public void newRound() {
		boardController.showBoard();
		System.out.print("Qual é a sua jogada (Coluna, Linha)? ");
		humanPlayer.play(this.sc.nextInt(), this.sc.nextInt());
		this.sc.skip("\\R");
		
		int xHuman = humanPlayer.getColumnValue();
		int yHuman = humanPlayer.getRowValue();
		if (boardController.isPossible(xHuman, yHuman)) {
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
		
		if (boardController.verifyWin()) {
			System.out.println("Houve um vencedor");
			boardController.showBoard();
			endGame = true;
		} else if (boardController.verifyTie()) {
			System.out.println("Empate - Ninguém ganhou");	
			boardController.showBoard();
			endGame = true;
		}
	}
}
