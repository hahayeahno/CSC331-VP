package videoPoker;

public class Deck {

	private Card[] deck = new Card[52];
	
	public Deck() {
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 13; j ++) {
				deck[(i*13)+j] = new Card(j + 1, i);
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < 52; i ++) {
			System.out.println("[" + (i+1) + "] " + deck[i]);
		}
	}
	
	public void shuffle() {
		int index;
		for (int i = 0; i < 52; i ++) {
			index = (int)(Math.random() * (deck.length - i)); //iterate through, swapping the current card with a random card ahead of it
			Card temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
	}
	
	public void sort() {
		
	}
	
	public Card getCard(int index) {
		return deck[index];
	}
	
	public Card getTopCard() {
		Card topCard = deck[0];
		
		return topCard;
	}
}
