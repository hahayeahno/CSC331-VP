package videoPoker;

public class Card {

	private int value;
	private int suit;
	private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	private String[] ranks = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	
	public Card() {
		setValue(0);
		setSuit(0);
	}
	public Card(int value, int suit) {
		setValue(value);
		setSuit(suit);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getSuit() { // 0 = spades, 1 = hearts, 2 = diamonds, 3 = clubs
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	
	public int getSortBySuitValue() {
		return ((getSuit() * 13) + (getValue()));
	}
	
	public int getSortByRankValue() {
		return ((getValue()*4) + getSuit());
	}
	
	@Override
	public String toString() {
		return (ranks[value] + " of " + suits[suit]);
	}
	
	public void print() {
		System.out.println(ranks[value] + " of " + suits[suit]);
	}

}
