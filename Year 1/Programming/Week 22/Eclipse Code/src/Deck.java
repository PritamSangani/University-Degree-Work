import java.util.*;

class Deck
{
	private ArrayList<Card> deck;

	Deck()
	{
		deck = new ArrayList<Card>();
		// TODO: populate the deck ArrayList with 52 cards, and shuffle
		for(int i = 2; i <= 14; i++)
		{
			for(int j = 0; j <= 3; j++)
			{
				Card card = new Card(i, j);
				deck.add(card);
			}
		}
		Collections.shuffle(deck);
	}
	
	Card Deal()
	{
		// TODO; return the first card and remove it from the deck.
		// return null if the deck is already empty.
		if(deck.isEmpty())
		{
			return null;
		}
		else
		{
			deck.remove(0);
			return deck.get(0);
					
		}
	}

}
