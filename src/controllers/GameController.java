package controllers;

import java.util.Scanner;

import entities.CPUPlayer;
import entities.HumanPlayer;
import enums.ComputerLevel;

public class GameController {
	
	private HumanPlayer humanPlayer = new HumanPlayer();
	private CPUPlayer cpuPlayer = new CPUPlayer();
	private BoardController boardController = new BoardController();
	private boolean hasWinner;
	
	public GameController() {}

	public void startGame() {
		Scanner sc = new Scanner(System.in);		
		
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
		boardController.showBoard();
		
	}
	
	public boolean verifyWin() {
		return false;
	}
	
	public boolean verifyTie() {
		return false;
	}
	

}
