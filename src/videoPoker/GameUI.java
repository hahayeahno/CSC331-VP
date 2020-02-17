package videoPoker;

import java.util.Scanner;

public class GameUI {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Game game = new Game();
		
		String player = getName();
		int credits = getCredits();
		int bet;
		boolean keepPlaying = true;
		while(keepPlaying) {
			game.play();
			System.out.println("You currently have " + credits + " credits, would you like to keep playing? (Y/N)");
			if (!input.next().trim().equalsIgnoreCase("Y")) {
				keepPlaying = false;
			}
		}
		System.out.println(player);
		System.out.println(credits);
		

	}
	
	public static String getName() {
		System.out.println("Please enter your name:");
		String name = input.nextLine();
		return name;
	}
	
	public static int getCredits() {
		System.out.println("How many credits do you want to start with?");
		int credits = Integer.parseInt(input.nextLine()); //make user safe
		return credits;
	}

}
