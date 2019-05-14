import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/SensorServerJsonSolution")

public class SensorServerJsonSolution extends HttpServlet {
	
    // Collects or returns data for sensorname, sensorvalue parameters
	private static final long serialVersionUID = 1L;
	
	// Local variables holding last values stored for each parameter
    SensorData lastSensor = new SensorData("unknown", "unknown");
    Gson gson = new Gson();
    
    public SensorServerJsonSolution() {
        super();
    }
	  public void init(ServletConfig config) throws ServletException {
		  System.out.println("Sensor server is up and running\n");	
		  System.out.println("Upload sensor data with http://localhost:8080/PhidgetServer/SensorServerJsonSolution?sensordata=someSensorJson");
		  System.out.println("View last sensor reading at  http://localhost:8080/PhidgetServer/SensorServerJsonSolution?getdata=true \n\n");		  
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
				// save the most recent Sensor object for later retrieval
				lastSensor = oneSensor;
	
				// Update sensor values and send back response
				PrintWriter out = response.getWriter();
				out.println(updateSensorValues(oneSensor));
				out.close();
			} // endif sensorJsonString not null
		} // end if getdata is null
	    else {  // Display current data (JSON format)
	    	   sendJSONString(response);
	    }

	}

	private String updateSensorValues(SensorData oneSensor){
		// all ok, update last known values and return
		lastSensor = oneSensor;
		System.out.println("DEBUG : Last sensor was " + oneSensor.getSensorname() + ", with value "+oneSensor.getSensorvalue());
		return "Sensor value updated.";
	}	
	
	
	private void sendJSONString(HttpServletResponse response) throws IOException{
		  response.setContentType("application/json");  
	      String json = gson.toJson(lastSensor);
	      
	      PrintWriter out = response.getWriter();
	      System.out.println("DEBUG: sensorServer JSON: "+lastSensor.toString());

	      out.println(json);
	      out.close();
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}

}
