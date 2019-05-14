import java.util.Scanner;

public class Decorator 
{	
	public static void main(String[] args) 
	{
		
		float jobCost;
		int time;
		float rate;
		float area;
		float unitPrice;
		Room room; 
		Job job1;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter Hourly Rate: ");
		rate = in.nextFloat();
		System.out.print("Please enter the room's area: ");
		area = in.nextFloat();
		System.out.print("Please enter the room's unit cost: ");
		unitPrice = in.nextFloat();
		System.out.print("Please enter the room's decorating time: ");
		time = in.nextInt();
		
		room = new Room(area,unitPrice,time);
		job1 = new Job(rate, room);
		jobCost = job1.calculateCost();
		
		System.out.println("The total cost of decoration is " + "£" + jobCost);
		
	}

}
