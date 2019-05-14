
public class BankTellerPence {

	public static void main(String[] args) {
		float sterling = (float) 20.11;
		
		int pounds,pence;
		pounds= (int)sterling;
		pence= (int)((sterling % 1) *100);
		int fifties,twenties,tens,fives,ones,fiftyPence,twentyPence,tenPence,fivePence,onePence;
		
		fifties = pounds / 50;
		pounds = pounds % 50;
		
		twenties = pounds / 20;
		pounds = pounds % 20;
		
		tens = pounds / 10;
		pounds = pounds % 10;
		
		fives = pounds / 5;
		pounds = pounds % 5;
		
		ones = pounds % 5;
		
		fiftyPence = pence / 50;
		pence = pence % 50;
		
		twentyPence = pence / 20;
		pence = pence % 20;
		
		tenPence = pence / 10;
		pence = pence % 10;
		
		fivePence = pence / 5;
		pence = pence % 5;
		
		onePence = pence;
		
		
		
		
		
	}

}
