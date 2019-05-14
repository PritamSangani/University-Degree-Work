
public class Room {
	private float surfaceArea;
	private float unitCost;
	public int approxTime;
	
	public Room (float surfaceArea, float unitCost, int approxTime)
	{
		this.surfaceArea = surfaceArea;
		this.unitCost = unitCost;
		this.approxTime = approxTime;
	}
	
	public float calculateCost()
	{
		return surfaceArea * unitCost;
	}
}
