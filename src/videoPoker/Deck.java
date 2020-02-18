package videoPoker;

import java.util.LinkedList;
import java.util.Collections;

public class Deck {

	private LinkedList<Card> deck = new LinkedList<Card>();
	
	public Deck() {
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 13; j ++) {
				deck.add(new Card(j+1, i));
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < 52; i ++) {
			System.out.println("[" + (i+1) + "] " + deck.get(i));
		}
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card getCard(int index) {
		return deck.get(index);
	}
	
	public Card getTopCard() {
		Card topCard = deck.pop();
		deck.addLast(topCard);
		return topCard;
	}
}
