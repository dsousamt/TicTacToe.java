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
		
		/*System.out.print("Qual o nível de dificuldade desejado (Easy / Hard)? ");		
		cpuPlayer.defineComputerLevel(this.sc.next());*/
		
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
		System.out.print("Qual é a sua jogada (Linha, Coluna)? ");
		humanPlayer.play(this.sc.nextInt(), this.sc.nextInt());
		this.sc.skip("\\R");
		
		int columnHuman = humanPlayer.getColumnValue();
		int rowHuman = humanPlayer.getRowValue();
		if (boardController.isPossible(rowHuman, columnHuman)) {
			boardController.addPlayerChoice(rowHuman, columnHuman, "X");
			/*if (boardController.verifyWin("X")) {
				System.out.println("Você venceu");
				boardController.showBoard();
				endGame = true;
			}*/
		} else {
			System.out.print("Jogada impossível");
			this.newRound();
		}
		
		System.out.print(humanPlayer.getName() + " jogou");
		boardController.showBoard();
		
		cpuPlayer.play();
		boolean randomLoop = boardController.isPossible(cpuPlayer.getRowValue(), cpuPlayer.getColumnValue());
		while (!randomLoop) {
			cpuPlayer.play();
			if (boardController.isPossible(cpuPlayer.getRowValue(), cpuPlayer.getColumnValue())) {
				break;
			}
		}
		
		boardController.addPlayerChoice(cpuPlayer.getRowValue(), cpuPlayer.getColumnValue(), "O");
		System.out.print("CPU jogou");
		
		boardController.showBoard();
		
		/*if (boardController.verifyWin("O")) {
			System.out.println("Você perdeu");
			boardController.showBoard();
			endGame = true;
		} else*/if (boardController.verifyTie()) {
			System.out.println("Empate - Ninguém ganhou");	
			boardController.showBoard();
			endGame = true;
		}
		
	}
}
