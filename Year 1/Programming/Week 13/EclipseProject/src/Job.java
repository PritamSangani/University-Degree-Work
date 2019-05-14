
public class Job {
	
	private float hourlyRate;
	private Room bedroom;
	
	public Job (float hourlyRate, Room bedroom)
	{
		this.hourlyRate = hourlyRate;
		this.bedroom = bedroom;
	}
	
	public float calculateCost()
	{
		return (hourlyRate * (float)bedroom.approxTime) + bedroom.calculateCost();
	}
	
}
