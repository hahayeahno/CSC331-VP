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
	static String WIN_TYPES[] = {"One Pair","Two Pair", "Three of a Kind", "Straight", "Flush", "Full House", "Four of a Kind", "Straight Flush", "Royal Flush"};	

	public static void main(String[] args) {
		Deck deck = new Deck();
		Hand hand = new Hand();
		
		deck.shuffle();
		deck.shuffle();
		deck.shuffle();
		deck.shuffle();
		deck.shuffle();
		deck.print();
		deal(hand, deck);
		hand.print();
		//deck.shuffle();	
	}
	
	public static void deal(Hand hand, Deck deck) {
		hand.setFirstCard(deck.getCard(0));
		hand.setSecondCard(deck.getCard(1));
		hand.setThirdCard(deck.getCard(2));
		hand.setFourthCard(deck.getCard(3));
		hand.setFifthCard(deck.getCard(4));
	}
	public static void checkWin(Hand hand) {
		boolean deleteme = false;
		if (deleteme) { // Royal Flush
			
		}
		else if (deleteme) { //Straight Flush
			
		}
		else if (deleteme) { //Four of a kind
			
		}
		else if (deleteme) { //Full house
			
		}
		else if (deleteme) { //Flush
			
		}
		else if (deleteme) { //Straight
			
		}
		else if (deleteme) { //three of a kind
			
		}
		else if (deleteme) { //two pair
			
		}
		else if (deleteme) { //pair (jack at least
			
		}
		else {
			
		}
	}
}
