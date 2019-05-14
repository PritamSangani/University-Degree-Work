class Card implements Comparable<Card>
{
	private int value;
	private int suit;
	private String name;
	private String cardValue;
	private String cardSuit;
	
	Card( int value, int suit )
	{
		// TODO set value, suit, work out name
		this.value = value;
		this.suit = suit;
		
		switch(value)
		{
			case 11: cardValue = "J";
			break;
			case 12: cardValue = "Q";
			break;
			case 13: cardValue = "K";
			break;
			case 14: cardValue = "A";
			break;
		}
		
		switch(suit)
		{
			case 0: cardSuit = "C";
			break;
			case 1: cardSuit = "D";
			break;
			case 2: cardSuit = "H";
			break;
			case 3: cardSuit = "S";
			break;
		}
		
		if(value < 11)
		{
			name = value + "_" + cardSuit;
		}
		else
		{
			name = cardValue + "_" + cardSuit;
		}
	}
	
	public int compareTo( Card otherCard )
	{
		// TODO; implement comparison function
		// returns a positive number if this card is higher in
		// rank than otherCard. If the cards are the same value
		// choose the card with the higher suit
		if(value > otherCard.getValue())
		{
			return value - otherCard.getValue();
		}
		else if(value < otherCard.getValue())
		{
			return otherCard.getValue() - value;
		}
		else
		{
			if(suit > otherCard.getSuit())
			{
				return suit - otherCard.getSuit();
			}
			else if(suit < otherCard.getSuit())
			{
				return otherCard.getSuit() - suit;
			}
			return 0;
		}
	}

	int getValue()
	{
		return value;
	}

	int getSuit()
	{
		return suit;
	}
	
	String getName()
	{
		return name;
	}
	
}
