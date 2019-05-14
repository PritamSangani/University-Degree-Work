
public class TiledRoom extends Room {
	
	float grouting;
	
	//constructor
	public TiledRoom(float surfaceArea, float unitCost, int approxTime) 
	{
		//pull values from room
		super(surfaceArea, unitCost, approxTime);
		//instance of grouting
		this.grouting = surfaceArea;
	}

	//calculate cost
	public float calculateCost(float hourlyRate)
	{
		//cast as float
		//override hourlyRate with new calculation
		
		float cost = super.calculateCost(hourlyRate*1.5f);
		
		//add on the grouting
		cost = cost + grouting;
		return(cost);
	}
	
	
	
}
