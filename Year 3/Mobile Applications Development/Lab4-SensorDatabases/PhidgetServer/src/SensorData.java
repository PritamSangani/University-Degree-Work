

public class SensorData {
	
	String sensorname;
	String sensorvalue;
	String userid;
	double longitude;
	double latitude;
	String sensordate;

	
	public SensorData(String sensorname, String sensorvalue, String userid, double longitude, double latitude,
			String sensordate) {
		super();
		this.sensorname = sensorname;
		this.sensorvalue = sensorvalue;
		this.userid = userid;
		this.longitude = longitude;
		this.latitude = latitude;
		this.sensordate = sensordate;
	}

	// Constructors depending on which parameters are known
	public SensorData(String sensorname, String sensorvalue, String userid) {
		super();
		this.sensorname = sensorname;
		this.sensorvalue = sensorvalue;
		this.userid = userid;
		// Defaults for when no location known
		this.longitude = 2.2386;
		this.latitude = 53.4708;
		this.sensordate = "unknown";
	}
	public SensorData(String sensorname, String sensorvalue) {
		super();
		this.sensorname = sensorname;
		this.sensorvalue = sensorvalue;
		// Defaults for when no userid or location known
		this.userid = "unknown";
		this.longitude = 2.2386;
		this.latitude = 53.4708;
		this.sensordate = "unknown";
	}

	public String getSensorname() {
		return sensorname;
	}
	public void setSensorname(String sensorname) {
		this.sensorname = sensorname;
	}
	public String getSensorvalue() {
		return sensorvalue;
	}
	public void setSensorvalue(String sensorvalue) {
		this.sensorvalue = sensorvalue;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getSensordate() {
		return sensordate;
	}
	public void setSensordate(String sensorvalue) {
		this.sensordate = sensorvalue;
	}

	@Override
	public String toString() {
		return "SensorData [sensorname=" + sensorname + ", sensorvalue=" + sensorvalue + ", userid=" + userid
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", sensordate=" + sensordate + "]";
	}
	
	
	
}
