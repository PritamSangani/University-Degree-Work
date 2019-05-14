

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.util.*;
import java.io.*;
import java.sql.*;


/**
 * Servlet implementation class sensorToDB
 */
@WebServlet("/SensorServerDBSolution")
public class SensorServerDBSolution extends HttpServlet {
	
		private static final long serialVersionUID = 1L;

	    Gson gson = new Gson();
        
       Connection conn = null;
	   Statement stmt;

	  public void init(ServletConfig config) throws ServletException {
	  // init method is run once at the start of the servlet loading
	  // This will load the driver and establish a connection
	    super.init(config);
		String user = "enter_your_mysql_username_here";
	    String password = "enter_your_mysql_password_here";
	    // Note none default port used, 6306 not 3306
	    String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/"+user;

		// Load the database driver
		try {  Class.forName("com.mysql.jdbc.Driver").newInstance();
	        } catch (Exception e) {
	            System.out.println(e);
	        }

			// get a connection with the user/pass
        try {
            conn = DriverManager.getConnection(url, user, password);
			  System.out.println("Sensor to DB  server is up and running\n");	
			  System.out.println("Upload sensor data with http://localhost:8080/PhidgetServer/SensorServerDBSolution?sensordata=some_sensor_data_in_json_format");
			  System.out.println("View last sensor reading at  http://localhost:8080/PhidgetServer/SensorServerDB?getdata=true\n\n");		  

            // System.out.println("DEBUG: Connection to database successful.");
            stmt = conn.createStatement();
        } catch (SQLException se) {
            System.out.println(se);
            System.out.println("\nDid you alter the lines to set user/password in the sensor server code?");
        }
	  } // init()

	  public void destroy() {
	        try { conn.close(); } catch (SQLException se) {
	            System.out.println(se);
	        }
	  } // destroy()
	  
	
	
    public SensorServerDBSolution() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setStatus(HttpServletResponse.SC_OK);
	    // Declare a SensorData object to hold the incoming data
	    SensorData oneSensor = new SensorData("unknown", "unknown");
	    
	    // Check to see whether the client is requesting data or sending it
	    String getdata = request.getParameter("getdata");

	    // if no getdata parameter, client is sending data
	    if (getdata == null){
	    		// getdata is null, therefore it is receiving data
	    		// Extract the parameter data holding the sensordata
			String sensorJsonString = request.getParameter("sensordata");
			
			// Problem if sensordata parameter not sent, or is invalid json
			if (sensorJsonString != null) {
				// Convert the json string to an object of type SensorData
				oneSensor = gson.fromJson(sensorJsonString, SensorData.class);
				// now update the table
				updateSensorTable(oneSensor);
			} // endif sensorJsonString not null
		} // end if getdata is null
	    else {  // Retrieve and return data (JSON format)
	    	   // Code to retrieve data
		   String sensorName = request.getParameter("sensorname");
	    	   String resultsJson = retrieveSensorData(sensorName);
			// Update sensor values and send back response
			PrintWriter out = response.getWriter();
			out.println(resultsJson);
			out.close();

	    	}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Post is same as Get, so pass on parameters and do same
	    doGet(request, response);
	}

private void updateSensorTable(SensorData oneSensor){
	try {
		// Create the INSERT statement from the parameters
		// set time inserted to be the current time on database server
		String updateSQL = 
	     	"insert into sensorusage(userid, sensorname, sensorvalue, latitude, longitude, timeinserted) " +
	     	"values('"+oneSensor.getUserid()      + "','" +
			           oneSensor.getSensorname()  + "','" +
		 	           oneSensor.getSensorvalue()  + "'," +
	     	           oneSensor.getLatitude()  + "," +
	     	           oneSensor.getLongitude()  + "," +
	     	           "now());";
	     	           
	        System.out.println("DEBUG: Update: " + updateSQL);
	        stmt.executeUpdate(updateSQL);
	        System.out.println("DEBUG: Update successful ");
	} catch (SQLException se) {
		// Problem with update, return failure message
	    System.out.println(se);
        System.out.println("\nDEBUG: Update error - see error trace above for help. ");
	    return;
	}

	// all ok,  return
	return;
}	
	private String retrieveSensorData(String sensorname) {
		String selectSQL = "select * from sensorusage where sensorname='" + 
					sensorname + "' order by timeinserted asc";
		ResultSet rs;

		// Declare ArrayList of sensors to hold results
		ArrayList<SensorData> allSensors = new ArrayList<SensorData>();

		try {	        
		   // create a result set of selected values
			rs = stmt.executeQuery(selectSQL);

			// Declare  a SensorData object to hold individual values, 
			// initialise to defaults
			SensorData oneSensor = new SensorData("unknown", "unknown"); // fill in statement
			// iterate over the result set
			while (rs.next()) {
			   	oneSensor.setSensorname(rs.getString("sensorname"));
			   	oneSensor.setSensorvalue(rs.getString("sensorvalue"));
			   	oneSensor.setUserid(rs.getString("userid"));
			   	oneSensor.setLatitude(rs.getDouble("latitude"));
			   	oneSensor.setLongitude(rs.getDouble("longitude"));
			   	oneSensor.setSensorname(rs.getString("sensorname"));
			   	oneSensor.setSensordate(rs.getString("timeinserted"));
			   	// add this sensor to ArrayList of Sensors
			   	allSensors.add(oneSensor);
			   	// debug print this sensor to console
			   	System.out.println(oneSensor.toString());
			}
		    } catch (SQLException ex) {
		            System.out.println("Error in SQL " + ex.getMessage());
		    }
			// Convert sensor list to json array and send back to user
			String allSensorsJson = gson.toJson(allSensors);
	
			// return this String from method
			return allSensorsJson;
	
	}
	
}
