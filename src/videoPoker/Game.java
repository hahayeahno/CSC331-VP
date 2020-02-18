package videoPoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.util.string;
/*
 * winning hands:				odds			payout:		condition:
 * pair jacks or better 		1.36:1			1:1			a pair higher than a jack
 * two pair						20.0:1			2:1			2 pairs of any rank (3,3 and 6,6)
 * three of a kind				46.3:1			3:1			3 cards of the same rank
 * Straight						254:1			4:1			5 cards of sequential rank
 * Flush						508:1			6:1			5 cards of the same suit
 * Full house					693:1			9:1			3 of a kind and a pair
 * Four of a kind				4164:1			25:1		4 cards of the same rank
 * Straight Flush				72192:1			50:1		Straight of one suit
 * Royal Flush					649739:1		250:1		Ace high straight of one suit(10,jack,queen,king,ace)
 * 
 * Rules:
 * 1: shuffle deck
 * 2: player makes bet before getting cards
 * 3: deal top five cards to hand
 * 4: pick which cards to keep
 * 5: replace cards with next cards on deck
 * 6: check if win, pay if yes
 * 7: play again?
 * 
 * Game flow:
 * 1. input player name and starting credits
 * 2. create and shuffle deck
 * 3. bet
 * 4. deal top 5 cards to hand
 * 5. ask to keep/redeal
 * 6. redeal
 * 7. check win conditions, royal down to pair
 * 			this is because many of the higher hands contain the lower hands, don't want someone with a full house to get the pay for a pair
 * 8. shuffle cards again
 * 9. check if player wants to cash out or play again.
 * 10. kill or repeat
 * 
 * 
 * 
 * todo: swap cards, payout
 */

public class Game {
	final static String WIN_TYPES[] = {"You lose", "One Pair","Two Pair", "Three of a Kind", "Straight", "Flush", "Full House", "Four of a Kind", "Straight Flush", "Royal Flush"};	
	//static String winType;
	private Deck deck = new Deck();
	private Hand hand = new Hand();
	
	public Game() {
		deck = new Deck();
		hand = new Hand();
	}
	
	public void deal(Hand hand, Deck deck) {
		hand.setFirstCard(deck.getTopCard());
		hand.setSecondCard(deck.getTopCard());
		hand.setThirdCard(deck.getTopCard());
		hand.setFourthCard(deck.getTopCard());
		hand.setFifthCard(deck.getTopCard());
	}
	
	public void swapCards(Hand hand) {
		//choose which cards to swap
		//swap them with a new card from deck
		List<Integer> toSwap = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter which cards you would like to swap as comma separated integers (ex. 1, 2, 4)");
		String input = in.nextLine();			//TODO: Make user-proof
		if (input.length() > 0) {
			String [] strToSwap = input.split(", ");
		
			
			for (int i = 0; i < strToSwap.length; i++) {
				toSwap.add(Integer.parseInt(strToSwap[i]));
			}
		
			System.out.println(toSwap.toString());
			for (int i = 0; i < toSwap.size(); i++) {
				int cardnum = toSwap.get(i);
				if (cardnum == 1) {
					hand.setFirstCard(deck.getTopCard());
				}
				else if (cardnum == 2) {
					hand.setSecondCard(deck.getTopCard());
				}
				else if (cardnum == 3) {
					hand.setThirdCard(deck.getTopCard());
				}
				else if (cardnum == 4) {
					hand.setFourthCard(deck.getTopCard());
				}
				else if (cardnum == 5) {
					hand.setFifthCard(deck.getTopCard());
				}
				else {
				
				}
			}

		}
		
	}
	
	public String checkWin(Hand hand) {
		String winType;
		if (isRoyalFlush(hand)) { 
			winType = WIN_TYPES[9];
		}
		else if (isStraightFlush(hand)) { 
			winType = WIN_TYPES[8];
		}
		else if (isFourOfAKind(hand)) { 
			winType = WIN_TYPES[7];
		}
		else if (isFullHouse(hand)) { 
			winType = WIN_TYPES[6];
		}
		else if (isFlush(hand)) { 
			winType = WIN_TYPES[5];
		}
		else if (isStraight(hand)) { 
			winType = WIN_TYPES[4];
		}
		else if (isThreeOfAKind(hand)) { 
			winType = WIN_TYPES[3];
		}
		else if (isTwoPair(hand)) { 
			winType = WIN_TYPES[2];
		}
		else if (isPair(hand)) { 
			winType = WIN_TYPES[1];
		}
		else {  
			winType = WIN_TYPES[0];
		}
		return winType;
	}
	
	public boolean isRoyalFlush(Hand hand) {
		hand.sortByRank();
		if (isStraightFlush(hand) && (hand.getFirstCard().getValue() == 1)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isStraightFlush(Hand hand) { 
		if (isStraight(hand) && isFlush(hand)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFourOfAKind(Hand hand) { 
		hand.sortByRank();
		Card[] arr = hand.getArray();
		
		if (arr[0].getValue() == arr [1].getValue()) {
			for (int i = 1; i < arr.length - 1; i++) {
				if (arr[i].getValue() != arr[i-1].getValue()) {
					return false;
				}
			}
			return true;
		}
		else {
			for (int i = 2; i < arr.length; i ++) {
				if (arr[i].getValue() != arr[i-1].getValue()) {
					return false;
				}
			}
			return true;
		}
	}
	
	public boolean isFullHouse(Hand hand) { 
		hand.sortByRank();
		Card[] arr = hand.getArray();
		if (arr[0].getValue() == arr[2].getValue()) {
			if (arr[0].getValue() == arr[1].getValue()) {
				if (arr[3].getValue() == arr[4].getValue()) {
					return true;
				}
			}
		}
		else if (arr[0].getValue() == arr[1].getValue()) {
			if (arr[2].getValue() == arr[3].getValue()) {
				if (arr[3].getValue() == arr[4].getValue()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isFlush(Hand hand) { 
		Card[] arr = hand.getArray();
		int suit = arr[0].getSuit();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].getSuit() != suit) {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean isStraight(Hand hand) { 
		hand.sortByRank();
		Card[] arr = hand.getArray();
		
		if(arr[1].getValue() == 10) { //when the straight starts at 10, it will wrap around to ace, which is valued at 1 and not 14. needs special case
			for (int i = 2; i < arr.length; i ++) {
				if (arr[i].getValue() != arr[i-1].getValue() + 1) {
					return false;
				}
			}
			if (arr[0].getValue() != 1) {
				return false;
			}
		}
		else { //literally every other case
			for (int i = 1; i < arr.length; i++) {
				if(arr[i].getValue() != arr[i-1].getValue() + 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isThreeOfAKind(Hand hand) { 
		hand.sortByRank();
		Card[] arr = hand.getArray();
		if ((arr[0].getValue() == arr[1].getValue()) && (arr[1].getValue() == arr[2].getValue())) {
			return true;
		}
		else if ((arr[1].getValue() == arr[2].getValue()) && (arr[2].getValue() == arr[3].getValue())) {
			return true;
		}
		else if ((arr[2].getValue() == arr[3].getValue()) && (arr[3].getValue() == arr[4].getValue())) {
			return true;
		}
		return false;
	}
	
	public boolean isTwoPair(Hand hand) { 
		hand.sortByRank();
		Card[] arr = hand.getArray();
		if (arr[0].getValue() == arr[1].getValue()) {
			if (arr[2].getValue() == arr[3].getValue()) {
				return true;
			}
			if (arr[3].getValue() == arr[4].getValue()) {
				return true;
			}
		}
		else if (arr[1].getValue() == arr[2].getValue()) {
			if (arr[3].getValue() == arr[4].getValue()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isPair(Hand hand) { 
		hand.sortByRank();
		Card[] arr = hand.getArray();
		for (int i = 0; i < arr.length -1; i++) {
			if ((arr[i].getValue() == arr[i+1].getValue())) {
				if (((arr[i].getValue() > 10)) || (arr[i].getValue() == 1)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String play() {
		deck.shuffle();
		deal(hand, deck);
		hand.sortByRank();
		hand.print();
		System.out.println();
		
		swapCards(hand);
		hand.sortByRank();
		hand.print();
		
		System.out.println(checkWin(hand));
		return checkWin(hand); //only for the play tests, might remove later
	}
	
	public void testWins() {
		String str;
		int[] testWins = {0,0,0,0,0,0,0,0,0,0};
		
		for (int i = 0; i < 100000; i++) {
			str = play();
			for (int j = 0; j < WIN_TYPES.length; j++) {
				if(WIN_TYPES[j] == str) {
					testWins[j] = testWins[j] + 1;
				}
			}
		}
		System.out.println("loss: \t\t" + testWins[0]);
		System.out.println("pair: \t\t" + testWins[1]);
		System.out.println("2pair: \t\t" + testWins[2]);
		System.out.println("3kind: \t\t" + testWins[3]);
		System.out.println("str8: \t\t" + testWins[4]);
		System.out.println("flush: \t\t" + testWins[5]);
		System.out.println("fullhouse: \t" + testWins[6]);
		System.out.println("4kind: \t\t" + testWins[7]);
		System.out.println("str8flush: \t" + testWins[8]);
		System.out.println("royal: \t\t" + testWins[9]);
		
	}
}
