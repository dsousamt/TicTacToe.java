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
				boardController.resetBoard();
				this.newGame();
				break;
			case 2:
				this.changeDifficulty();
				System.out.println("Dificuldade alterada!");
				break;
			case 3:
				this.setUserName();
				System.out.println("Nome alterado para " + humanPlayer.getName());
				break;
			}
		}
	}

	public void newGame() {
		stillPlaying = true;
		if (humanPlayer.getName() == null) {
			this.setUserName();
		}
		
		System.out.println("\nTudo pronto, " + humanPlayer.getName());
		this.askChoice();
		while (stillPlaying) {
			this.newRound();				
			if (stillPlaying == false) {
				break;
			}
		}		
		this.startGame();
	}
	
	public void newRound() {
		
		boardController.showBoard();
		System.out.print("Qual é a sua jogada (Linha, Coluna)? ");
		System.out.print("\nLinha: ");
		int row = this.sc.nextInt();
		System.out.print("\nColuna: ");
		int col = this.sc.nextInt();
		humanPlayer.play(row, col);
		PlayerChoice userChoice = humanPlayer.getChoice();
		
		int userRow = humanPlayer.getRow(), userCol = humanPlayer.getCol();		
		if (boardController.isPossible(userRow, userCol)) {
			boardController.addPlayerChoice(userRow, userCol, userChoice);
			isTheEnd(userChoice);
		}
		
		cpuPlayer.play();
		int cpuRow = cpuPlayer.getRow(), cpuCol = cpuPlayer.getCol();
		boolean possibleChoice = boardController.isPossible(cpuRow, cpuCol);
		while (possibleChoice != true) {
			cpuPlayer.play();
			if (boardController.isPossible(cpuPlayer.getRow(), cpuPlayer.getCol())) {
				break;
			}
		}		
		boardController.addPlayerChoice(cpuPlayer.getRow(), cpuPlayer.getCol(), cpuPlayer.getChoice());
		isTheEnd(cpuPlayer.getChoice());
	}
	
	private void isTheEnd(PlayerChoice c) {
		if (boardController.verifyWin(c.value)) {			
			if (humanPlayer.getChoice() == c) {
				System.out.println( "Parabéns " + humanPlayer.getName() + ", você venceu!");				
			} else {
				System.out.println( "Que pena, você perdeu essa :(");
			} 
			boardController.showBoard();
			stillPlaying = false;
		} else if (boardController.verifyTie()) {
			System.out.println("Empate - Ninguém ganhou");
			boardController.showBoard();
			stillPlaying = false;
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
