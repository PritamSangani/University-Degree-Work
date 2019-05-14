import java.util.ArrayList;

public class Job {
	
	private float hourlyRate;
	private Room theRoom;
	ArrayList<Room>roomList = new ArrayList<Room>();
	
	public Job (float hourlyRate)
	{
		this.hourlyRate = hourlyRate;
	}
	
	public float calculateCost()
	{
		float totalCost = 0;
		for(Room counter: roomList)
		{
			totalCost = totalCost + counter.calculateCost(hourlyRate);
		}
		return totalCost;
	}
	
	public void AddRoom(Room theRoom)
	{
		roomList.add(theRoom);
	}
}
