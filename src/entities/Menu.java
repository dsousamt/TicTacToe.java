package entities;

public class Menu {
	protected int option;

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}
	
	public void showMenu() {
		System.out.println("*****************************************************");
		System.out.println("                                                     ");
		System.out.println("                     Jogo da Velha                   ");
		System.out.println("                                                     ");
		System.out.println("*****************************************************");
		System.out.println("                                                     ");
		System.out.println("            1 - Começar novo jogo                    ");
		System.out.println("            2 - Alterar dificuldade                  ");
		System.out.println("            3 - Editar nome                          ");
		System.out.println("            0 - Sair                                 ");
		System.out.println("                                                     ");
		System.out.println("*****************************************************");
		System.out.println("Entre com a opção desejada:                          ");
		System.out.println("                                                     ");
	}
	
}
