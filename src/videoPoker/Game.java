package videoPoker;

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
 */

public class Game {
	final static String WIN_TYPES[] = {"You lose", "One Pair","Two Pair", "Three of a Kind", "Straight", "Flush", "Full House", "Four of a Kind", "Straight Flush", "Royal Flush"};	
	static String winType;
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		Hand hand = new Hand();
		
		deck.shuffle();
		//deck.print();
		deal(hand, deck);
		hand.print();
		hand.sort();
		hand.print();
		//deck.print();
			
	}
	
	public static void deal(Hand hand, Deck deck) {
		hand.setFirstCard(deck.getTopCard());
		hand.setSecondCard(deck.getTopCard());
		hand.setThirdCard(deck.getTopCard());
		hand.setFourthCard(deck.getTopCard());
		hand.setFifthCard(deck.getTopCard());
	}
	
	public static void swapCards() {
		//choose which cards to swap
		//swap them with a new card from deck
	}
	
	public static String checkWin(Hand hand) {
		
		if (isRoyalFlush(hand)) { // Royal Flush
			winType = WIN_TYPES[9];
		}
		else if (isStraightFlush(hand)) { //Straight Flush
			winType = WIN_TYPES[8];
		}
		else if (isFourOfAKind(hand)) { //Four of a kind
			winType = WIN_TYPES[7];
		}
		else if (isFullHouse(hand)) { //Full house
			winType = WIN_TYPES[6];
		}
		else if (isFlush(hand)) { //Flush
			winType = WIN_TYPES[5];
		}
		else if (isStraight(hand)) { //Straight
			winType = WIN_TYPES[4];
		}
		else if (isThreeOfAKind(hand)) { //three of a kind
			winType = WIN_TYPES[3];
		}
		else if (isTwoPair(hand)) { //two pair
			winType = WIN_TYPES[2];
		}
		else if (isPair(hand)) { //pair (jack at least
			winType = WIN_TYPES[1];
		}
		else { //you lose 
			winType = WIN_TYPES[0];
		}
		return winType;
	}
	
	public static boolean isRoyalFlush(Hand hand) {
		if (isStraightFlush(hand) && (hand.getFirstCard().getValue() == 10)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isStraightFlush(Hand hand) {
		if (isStraight(hand) && isFlush(hand)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isFourOfAKind(Hand hand) { //tedious
		if (true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isFullHouse(Hand hand) {
		return false;
	}
	
	public static boolean isFlush(Hand hand) {
		Card[] arr = hand.getArray();
		int suit = arr[0].getSuit();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].getSuit() != suit) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static boolean isStraight(Hand hand) {
		return false;
	}
	
	public static boolean isThreeOfAKind(Hand hand) {
		return false;
	}
	
	public static boolean isTwoPair(Hand hand) {
		return false;
	}
	
	public static boolean isPair(Hand hand) {
		return false;
	}
	
	public static void play() {
		
	}
}
