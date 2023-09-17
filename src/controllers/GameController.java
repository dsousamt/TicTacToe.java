package controllers;

import java.util.Scanner;

import entities.CPUPlayer;
import entities.HumanPlayer;
import entities.Menu;
import enums.PlayerChoice;

public class GameController {
	
	private Scanner sc = new Scanner(System.in);	
	private HumanPlayer humanPlayer = new HumanPlayer();
	private CPUPlayer cpuPlayer = new CPUPlayer();
	private BoardController boardController = new BoardController();
	private Menu menu = new Menu();
	private boolean stillPlaying = true;
	
	public GameController() {}
	
	public void startGame() {
		while (true) {
			menu.showMenu();
			menu.setOption(sc.nextInt());
			sc.skip("\\R");
			
			if (menu.getOption() == 0) {
				System.exit(0);
			}
			
			switch (menu.getOption()) {
			case 1:
				this.newGame();
				break;
			case 2:
				this.changeDifficulty();
				System.out.println("Dificuldade alterada!");
				break;
			case 3:
				this.setUserName();
				System.out.println("Nome alterado!");
				break;
			}
		}
	}

	public void newGame() {
		
		if (humanPlayer.getName() == null) {
			this.setUserName();
		}
		
		System.out.print("Deseja jogar quantas partidas? ");
		int nRound = sc.nextInt();
		for (int i = 1; i <= nRound; i++) {			
			System.out.println("\nPartida " + i + ", " + humanPlayer.getName());
			this.askChoice();
			while (stillPlaying) {
				this.newRound();				
				if (stillPlaying == false) {
					break;
				}
			}
			stillPlaying = true;
		}
		this.startGame();
	}
	
	public void newRound() {
		
		boardController.showBoard();
		System.out.print("Qual é a sua jogada (Linha, Coluna)? ");
		humanPlayer.play(this.sc.nextInt(), this.sc.nextInt());
		PlayerChoice userChoice = humanPlayer.getChoice();
		this.sc.skip("\\R");
		
		int userRow = humanPlayer.getRow(), userCol = humanPlayer.getCol();		
		if (boardController.isPossible(userRow, userCol)) {
			boardController.addPlayerChoice(userRow, userCol, userChoice);
		}
		
		if (!isTheEnd(userChoice)) {
			cpuPlayer.play();
			int cpuRow = cpuPlayer.getRow(), cpuCol = cpuPlayer.getCol();
			boolean possibleChoice = boardController.isPossible(cpuRow, cpuCol);
			while (possibleChoice != true) {
				cpuPlayer.play();
				if (boardController.isPossible(cpuRow, cpuCol)) {
					break;
				}
			}		
			boardController.addPlayerChoice(cpuRow, cpuCol, cpuPlayer.getChoice());
			if (isTheEnd(cpuPlayer.getChoice())) {
				stillPlaying = false;
			}
			isTheEnd(cpuPlayer.getChoice());
		} else {
			stillPlaying = false;
		}		
	}
	
	private boolean isTheEnd(PlayerChoice c) {
		if (boardController.verifyWin(c.value)) {			
			if (humanPlayer.getChoice() == c) {
				System.out.println( "Parabéns " + humanPlayer.getName() + ", você venceu!");				
			} else {
				System.out.println( "Que pena, você perdeu essa :(");
			} 
			boardController.showBoard();
			return true;
		} else if (boardController.verifyTie()) {
			System.out.println("Empate - Ninguém ganhou");
			boardController.showBoard();
			return true;
		} else {
			return false;
		}
	}
	
	private void askChoice() {
		System.out.print("Você quer ser X ou O ? ");
		String choice = sc.next();
		if (choice.equalsIgnoreCase(PlayerChoice.X.value)) {
			humanPlayer.setChoice(PlayerChoice.X);
			cpuPlayer.setChoice(PlayerChoice.O);
		} else if (choice.equalsIgnoreCase(PlayerChoice.O.value)) {
			humanPlayer.setChoice(PlayerChoice.O);
			cpuPlayer.setChoice(PlayerChoice.X);
		}
	}
	
	private void changeDifficulty() {
		System.out.print("Qual o nível de dificuldade desejado (Easy / Hard)? ");		
		cpuPlayer.defineComputerLevel(this.sc.next());
	}
	
	private void setUserName() {
		System.out.print("Qual o seu nome? ");
		humanPlayer.setName(this.sc.nextLine());
	}
}
