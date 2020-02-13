package videoPoker;

//maybe

public class Hand {

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
	
	public void sortBySuit() {
		
		Card arr[] = {getFirstCard(), getSecondCard(), getThirdCard(), getFourthCard(), getFifthCard()};

		for (int i = 0; i < arr.length - 1; i ++) {		//Bubble sort because its 5 items
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j].getSortBySuitValue() > arr[j+1].getSortBySuitValue()) {
					Card temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		setFirstCard(arr[0]);
		setSecondCard(arr[1]);
		setThirdCard(arr[2]);
		setFourthCard(arr[3]);
		setFifthCard(arr[4]);
	}
	
	public void sortByRank() {
		Card arr[] = {getFirstCard(), getSecondCard(), getThirdCard(), getFourthCard(), getFifthCard()};

		for (int i = 0; i < arr.length - 1; i ++) {		//Bubble sort because its 5 items
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j].getSortByRankValue() > arr[j+1].getSortByRankValue()) {
					Card temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		setFirstCard(arr[0]);
		setSecondCard(arr[1]);
		setThirdCard(arr[2]);
		setFourthCard(arr[3]);
		setFifthCard(arr[4]);
	}
	
	public Card[] getArray() {
		Card[] arr = {firstCard, secondCard, thirdCard, fourthCard, fifthCard};
		return arr;
	}
	
	public void print() {
		System.out.println(firstCard);
		System.out.println(secondCard);
		System.out.println(thirdCard);
		System.out.println(fourthCard);
		System.out.println(fifthCard);
		
	}

}
