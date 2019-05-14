package utils;

/**
 * Created by Pritam Sangani on 17/11/2018.
 */

public class SensorData {
    private String sensorname;
    private String sensorvalue;
    private String username;
    private String date;

    public SensorData() {
        this.sensorname = "";
        this.sensorvalue = "";
        this.username = "";
        this.date = "";
    }

    public SensorData(String sensorname, String sensorvalue, String username) {
        this.sensorname = sensorname;
        this.sensorvalue = sensorvalue;
        this.username = username;
    }


    public SensorData(String sensorname, String sensorvalue, String username, String date) {
        this.sensorname = sensorname;
        this.sensorvalue = sensorvalue;
        this.username = username;
        this.date = date;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
