package videoPoker;

import java.util.LinkedList;
import java.util.Collections;

public class Deck {

	//private Card[] deck = new Card[52];
	private LinkedList<Card> deck = new LinkedList<Card>();
	
	public Deck() {
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 13; j ++) {
				//deck[(i*13)+j] = new Card(j + 1, i);
				deck.add(new Card(j+1, i));
			}
		}
	}
	
	public void print() {
		//LinkedList<Card> temp = deck;
		for (int i = 0; i < 52; i ++) {
			System.out.println("[" + (i+1) + "] " + deck.get(i));
		}
	}
	/*
	public void shuffle() { //original shuffle, realized there is a shuffle in java.util.Collections specifically for lists
		int index;
		for (int i = 0; i < 52; i ++) {
			index = (int)(Math.random() * (deck.size() - i)); //iterate through, swapping the current card with a random card ahead of it
			//Card temp = deck[i];
			//deck[i] = deck[index];
			//deck[index] = temp;
			Card temp = deck.get(i);
			deck.set(i, deck.get(index));
			deck.set(index, temp);
		}
	}
	*/
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public void sort() {
		
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
