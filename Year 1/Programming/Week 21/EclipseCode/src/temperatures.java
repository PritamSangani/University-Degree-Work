import java.io.*;
import java.util.*;

public class temperatures {

	public static void main(String[] args) {
		
		float minTemp[] = {1000.0f, 1000.0f};
		float maxTemp[] = {-1000.0f, -1000.0f};
		
		String maxDate[] = {"NA", "NA"};
		String minDate[] = {"NA", "NA"};
		
		String minTime[] = {"NA", "NA"};
		String maxTime[] = {"NA", "NA"};
		
		Scanner in = null;
		
		try
		{
			in = new Scanner(new File("temps.dat"));
		}
		catch(FileNotFoundException error)
		{
			System.out.println("Could not open file: " + error);
		}
		
		if(in != null)
		{
			
			while(in.hasNext())
			{
				String date = in.next(); //date
				String time = in.next(); //time
				in.next(); //sensor1
				float sensor1 = in.nextFloat();
				in.next(); //sensor2
				float sensor2 = in.nextFloat();
				
				if(sensor1 > maxTemp[0])
				{
					maxTemp[0] = sensor1;
					maxDate[0] = date;
					maxTime[0] = time;
				}
				else if(sensor1 < minTemp[0])
				{
					minTemp[0] = sensor1;
					minDate[0] = date;
					minTime[0] = time;
				}
				
				if(sensor2 > maxTemp[1])
				{
					maxTemp[1] = sensor2;
					maxDate[1] = date;
					maxTime[1] = time;
				}
				else if(sensor2 < minTemp[1])
				{
					minTemp[1] = sensor2;
					minDate[1] = date;
					minTime[1] = time;
				}
			}
			System.out.println("Sensor 1: Maximum Temperature is " + maxTemp[0] + " on " + maxDate[0] + " at " + maxTime[0]);
			System.out.println("Sensor 1: Minimum Temperature is " + minTemp[0] + " on " + minDate[0] + " at " + minTime[0]);
			System.out.println("Sensor 2: Maximum Temperature is " + maxTemp[1] + " on " + maxDate[1] + " at " + maxTime[1]);
			System.out.println("Sensor 2: Minimum Temperature is " + minTemp[1] + " on " + minDate[1] + " at " + minTime[1]);
		}


	}

}
