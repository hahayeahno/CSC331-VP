package videoPoker;

//maybe

public class Hand extends Deck{

	private Card firstCard;
	private Card secondCard;
	private Card thirdCard;
	private Card fourthCard;
	private Card fifthCard;
 	private Card blankCard = new Card();
 	
	public Hand() {
		firstCard = secondCard = thirdCard = fourthCard = fifthCard = blankCard;
	}
	
	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		firstCard = c1;
		secondCard = c2;
		thirdCard = c3;
		fourthCard = c4;
		fifthCard = c5;
	}

	public Card getFirstCard() {
		return firstCard;
	}

	public void setFirstCard(Card firstCard) {
		this.firstCard = firstCard;
	}

	public Card getSecondCard() {
		return secondCard;
	}

	public void setSecondCard(Card secondCard) {
		this.secondCard = secondCard;
	}

	public Card getThirdCard() {
		return thirdCard;
	}

	public void setThirdCard(Card thirdCard) {
		this.thirdCard = thirdCard;
	}

	public Card getFourthCard() {
		return fourthCard;
	}

	public void setFourthCard(Card fourthCard) {
		this.fourthCard = fourthCard;
	}

	public Card getFifthCard() {
		return fifthCard;
	}

	public void setFifthCard(Card fifthCard) {
		this.fifthCard = fifthCard;
	}
	
	public void print() {
		System.out.println(firstCard);
		System.out.println(secondCard);
		System.out.println(thirdCard);
		System.out.println(fourthCard);
		System.out.println(fifthCard);
		
	}

}
