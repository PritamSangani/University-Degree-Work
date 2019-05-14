import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int month;
		int date;
		int year;
		
		System.out.print("Enter a month [1..12]: ");
		month = input.nextInt();
		System.out.print("Enter a date [1..31]: ");
		date = input.nextInt();
		System.out.print("Enter the year: ");
		year = input.nextInt();
		
		input.close();
		
		switch(month){
		case 0:
			System.out.println("That is not a valid month ");
		break;
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			if(date>0 && date<32){
				System.out.println("That is a valid day for that month ");
			}
			else{
				System.out.println("That is not a valid day for that month ");
			}
		break;
		case 2:
			if(year % 4==0 && (date>0 && date<30)){
				System.out.println("That is a valid day for that month ");
			}
			else if(year % 4 !=0 && (date>0 && date<29)){
				System.out.println("That is a valid day for that month ");
			}
			else{
				System.out.println("That is not a valid day for that month ");
			}
		break;
		case 4: case 6: case 9: case 11:
			if(date > 0 && date<31){
				System.out.println("That is a valid day for that month ");
			}
			else{
				System.out.println("That is not a valid day for that month ");
			}
		break;	
		}	
	}
}
