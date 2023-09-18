package entities;

import java.util.Scanner;

import controllers.BoardController;
import controllers.GameController;
import exceptions.InvalidOptionException;

public class Menu {
	protected int option;
	private Scanner sc = new Scanner(System.in);

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;		
	}
	
	public void showMenu(GameController gameController, BoardController boardController, HumanPlayer user) {
		while (true) {
			System.out.println("**************************************");
			System.out.println("*           Jogo da Velha            *");
			System.out.println("**************************************");
			System.out.println(" 1 - Começar novo jogo                ");
			System.out.println(" 2 - Alterar dificuldade              ");
			System.out.println(" 3 - Editar nome                      ");
			System.out.println(" 0 - Sair                             ");
			System.out.println("**************************************");
			System.out.print("Entre com a opção desejada: ");
			this.setOption(sc.nextInt());
			sc.skip("\\R");			
			
			switch (this.getOption()) {
			case 1:
				boardController.resetBoard();
				gameController.newGame();
				break;
			case 2:
				gameController.changeLevel();
				System.out.println("Dificuldade alterada!");
				break;
			case 3:
				System.out.print("Qual seu nome? ");
				user.setName(this.sc.nextLine());
				System.out.println("Nome alterado para " + user.getName());
				break;
			} 
			if (this.getOption() == 0) {
				sc.close();
				System.exit(0);
			} else {
				throw new InvalidOptionException("Opção inválida");
			}
		}
	}
	
}
