package controllers;

import java.util.Scanner;

import entities.CPUPlayer;
import entities.HumanPlayer;
import entities.Menu;
import entities.Player;
import exceptions.InvalidOptionException;

public class GameController {
	
	private BoardController board = new BoardController();
	private HumanPlayer user = new HumanPlayer();
	private CPUPlayer cpu = new CPUPlayer();
	private Menu menu = new Menu();
	private boolean gameRunning;
	private Scanner sc = new Scanner(System.in);	
	
	public void startGame() {
		gameRunning = true;
		menu.showMenu(this, board, user);
	}

	public void newGame() {
		
		if (!user.hasUserName()) {
			System.out.print("\nQual seu nome? ");
			user.setName(this.sc.nextLine());
		}		
		System.out.print("\n" + user.getName() + ", quer ser X ou O ? ");
		String userchoice = sc.next();
		user.defineChoice(userchoice);
		cpu.defineChoice(userchoice.equalsIgnoreCase("X")? "O" : "X");
		
		do {
			this.newRound();
		} while (gameRunning == true);
		
		this.startGame();
	}
	
	public void newRound() {
		
		board.showBoard();		
		System.out.print("Qual é a sua jogada (Linha, Coluna)? ");
		int row = this.sc.nextInt();
		int col = this.sc.nextInt();
		user.defineCoordinates(row, col);
		
		if (board.isPossible(user.getRow(), user.getCol())) {
			board.addPlayerChoice(user.getRow(), user.getCol(), user.getChoice());
			gameEnded(user);
		}		
		do {
			cpu.defineCoordinates();
		} while (board.isPossible(cpu.getRow(), cpu.getCol()) == false);
		board.addPlayerChoice(cpu.getRow(), cpu.getCol(), cpu.getChoice());
		
		gameEnded(cpu);
	}
	
	private void gameEnded(Player p) {		
		if (board.hasWinner(p) || board.verifyTie()) {
			board.showBoard();
			board.finalMessage(p);
			gameRunning = false;
		}
	}
	
	public void changeLevel() {
		System.out.print("Qual o nível de dificuldade desejado (Easy / Hard)? ");		
		cpu.defineComputerLevel(this.sc.next());
		throw new InvalidOptionException("Escolha entre 'Easy' e 'Hard'");
	}
}
