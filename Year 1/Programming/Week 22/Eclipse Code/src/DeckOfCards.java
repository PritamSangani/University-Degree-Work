import java.util.*;

public class DeckOfCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck deckOfCards = new Deck();
		ArrayList<Card> cardHand = new ArrayList<Card>();
		
		for(int i = 0; i < 13; i++)
		{
			cardHand.add(deckOfCards.Deal());
		}
		for (Card card : cardHand) 
		{
		    System.out.println (card.getName());
		}
		
		
	}

}
