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
		Room myRoom; 
		Job job;
		char anotherRoom;
		
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter Hourly Rate: ");
		rate = in.nextFloat();
		job = new Job(rate);
		do
		{
			
			System.out.print("Please enter the room's area: ");
			area = in.nextFloat();
			System.out.print("Please enter the room's unit cost: ");
			unitPrice = in.nextFloat();
			System.out.print("Please enter the room's decorating time: ");
			time = in.nextInt();
			System.out.print("Is this a tiled room? (Y/N): ");
			char t = in.next().charAt(0);
			if(t=='y' || t=='Y')
			{
				myRoom = new TiledRoom(area, unitPrice,time);
			}
			else if(t=='n' || t=='N')
			{
				myRoom = new Room(area, unitPrice, time);
			}
			else
			{
				myRoom = new Room(area, unitPrice, time);
			}
			job.AddRoom(myRoom);
			System.out.print("Do you want to add another room to the job list? (Y/N): ");
			anotherRoom = in.next().charAt(0);
		}
		while(anotherRoom == 'y' || anotherRoom == 'Y');
		jobCost = job.calculateCost();
		System.out.println("The total cost of decoration is " + "£" + jobCost + "0");
		
	}

}
