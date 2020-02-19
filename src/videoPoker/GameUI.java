package videoPoker;

import java.util.Scanner;

public class GameUI {

	Scanner input = new Scanner(System.in);
	final String[][] PAYOUT_TABLE = 
			{{"You lose", "0"}, {"One Pair", "1"}, {"Two Pair", "2"}, {"Three of a Kind", "3"}, {"Straight", "4"}, 
			{"Flush", "6"}, {"Full House", "9"}, {"Four of a Kind", "25"}, {"Straight Flush", "50"}, {"Royal Flush", "250"}};
	String player;
	int credits;
	
	public static void main(String[] args) {
		GameUI gui = new GameUI();
		gui.play();
	}
	
	public int getBet() {
		System.out.println("What would you like to bet on this hand?");
		int num = getIntInput();
		if (num > credits) {
			System.out.println("Sorry, you can't bet more credits than you have. Please try again.");
			return getBet();
		}
		credits -= num;
		return num;
	}
	
	public String getName() {
		System.out.println("Please enter your name:");
		String name = input.nextLine().trim();
		return name;
	}
	
	public int getCredits() {
		System.out.println("How many credits do you want to start with?");
		int credits = getIntInput();
		return credits;
	}

	public int payout(int bet, String winType) {
		for (int i = 0; i < PAYOUT_TABLE.length; i++) {
			if (PAYOUT_TABLE[i][0].equalsIgnoreCase(winType)) {
				return Integer.parseInt(PAYOUT_TABLE[i][1]) * bet;
			}
		}
		return 0;
	}
	
	public int getIntInput() {
		try {
			String in = input.nextLine();
			int num = Integer.parseInt(in);
			return num;
		}
		catch (Exception e) {
			System.out.println("It doesn't look like you entered a number. Please try again.");
			return getIntInput();
		}
		
	}
	
	public void play() {
		Game game = new Game();
		
		player = getName();
		credits = getCredits();
		int bet;
		String winType;
		
		boolean keepPlaying = true;
		while(keepPlaying && credits > 0) {
			bet = getBet();
			
			winType = game.play();
			credits += payout(bet, winType);
			
			System.out.println("You currently have " + credits + " credits, would you like to keep playing? (Y/N)");
			if (!input.nextLine().trim().equalsIgnoreCase("Y")) {
				keepPlaying = false;
			}
		}
		System.out.println("Congratulations, " + player + "! You ended with " + credits + " credits!");
	}
	
	public void testPlay() {
		Game game = new Game();
		game.testWins();
	}
}

