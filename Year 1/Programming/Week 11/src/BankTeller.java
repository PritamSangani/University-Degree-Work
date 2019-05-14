
public class BankTeller {

	public static void main(String[] args) {
		int sterling=189; //try different values to check your code
		int fifties, twenties, tens, fives ,ones ;
		
		fifties = sterling / 50;
		sterling = sterling % 50;
		
		twenties = sterling / 20;
		sterling = sterling % 20;
		
		tens = sterling / 10;
		sterling = sterling % 10;
		
		fives = sterling / 5;
		sterling = sterling % 5;
		
		ones = sterling;
		
		System.out.println(fifties + " fifties");
		System.out.println(twenties + " twenties");
		System.out.println(tens + " tens");
		System.out.println(fives + " fives");
		System.out.println(ones + " ones");
	}

}
