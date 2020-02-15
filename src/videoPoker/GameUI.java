package videoPoker;

import java.util.Scanner;

public class GameUI {

	public static void main(String[] args) {
		Game game = new Game();
		
		String player = getName();
		int credits = getCredits();
		
		game.play();

	}
	
	public static String getName() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your name:");
		String name = input.nextLine();
		input.close();
		return name;
	}
	
	public static int getCredits() {
		Scanner input = new Scanner(System.in);
		System.out.println("How many credits do you want to start with?");
		int credits = input.nextInt(); //make user safe
		input.close();
		return credits;
	}

}
