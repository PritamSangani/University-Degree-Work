import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Pritam Sangani (16039231)
 * Acts as a Tester class to test the functionality of all the Handler contexts within the Student Web Service
 */
public class WebServiceTester {
	/**
	 * Executes the testing methods to test the functionality of the Web Service
	 * @param args takes in console arguments as is defined of a main method
	 */
	public static void main(String[] args) {
		System.out.println("Students = " + getStudents());
		System.out.println("Retrieved student = " + getStudent(16039231));
		try {
			postStudent();
			updateStudent();
			deleteStudent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Method to test the functionality of the GetHandler
	 * @return a StringBuffer of the result of the test
	 */
	private static StringBuffer getStudents() {

		StringBuffer response = new StringBuffer();

		try {
			URL url = new URL("http://localhost:8005/get-all-students");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			String output;

			conn.setRequestMethod("GET");
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			while ((output = reader.readLine()) != null) {
				response.append(output);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}

	/**
	 * Method to test the functionality of the ShowHandler
	 * @param studentId student id of Student being retrieved
	 * @return a StringBuffer of the result of the test
	 */
	private static StringBuffer getStudent(int studentId) {

		StringBuffer response = new StringBuffer();

		try {
			URL url = new URL("http://localhost:8005/get-student?stuID="+studentId);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			String output;

			conn.setRequestMethod("GET");
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			while ((output = reader.readLine()) != null) {
				response.append(output);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}

	/**
	 * Method to test the functionality of the InsertHandler
	 * @throws IOException
	 */
	private static void postStudent() throws IOException {
		StringBuffer response = new StringBuffer();
		URL url = new URL("http://localhost:8005/insert-student");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		String output;
		String json = "\t{\"studentNumber\":100000,\"courseTitle\":\"Computer Science\",\"startDate\":\"09-2016\",\"bursary\":0.0,\"email\":\"pritamsangani@pritam.com\",\"name\":\"Pritam Sangani\",\"gender\":\"M\",\"dob\":\"23-04-1998\",\"address\":\"Stockport\",\"postcode\":\"SK5\"}\n";

		conn.setRequestMethod("POST");
		//allow a request body to be sent - needed for POST requests
		conn.setDoOutput(true);
		DataOutputStream stream = new DataOutputStream(conn.getOutputStream());
		stream.writeBytes(json);
		stream.flush();
		stream.close();

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		while ((output = reader.readLine()) != null) {
			response.append(output);
		}

		System.out.println(response.toString());
	}

	/**
	 * Method to test the functionality of the UpdateHandler
	 * @throws IOException
	 */
	private static void updateStudent() throws IOException {
		StringBuffer response = new StringBuffer();
		URL url = new URL("http://localhost:8005/update-student");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		String output;
		String json = "\t{\"studentNumber\":100000,\"courseTitle\":\"Software Engineering\",\"startDate\":\"09-2016\",\"bursary\":0.0,\"email\":\"pritamsangani@pritam.com\",\"name\":\"Pritam Sangani\",\"gender\":\"M\",\"dob\":\"23-04-1998\",\"address\":\"Stockport\",\"postcode\":\"SK5\"}\n";

		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		DataOutputStream stream = new DataOutputStream(conn.getOutputStream());
		stream.writeBytes(json);
		stream.flush();
		stream.close();

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		while ((output = reader.readLine()) != null) {
			response.append(output);
		}

		System.out.println(response.toString());
	}

	/**
	 * Method to test the functionality of the DeleterHandler
	 * @throws IOException
	 */
	private static void deleteStudent() throws IOException {
		StringBuffer response = new StringBuffer();
		URL url = new URL("http://localhost:8005/insert-student");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		String output;
		String json = "16039233";

		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		DataOutputStream stream = new DataOutputStream(conn.getOutputStream());
		stream.writeBytes(json);
		stream.flush();
		stream.close();

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		while ((output = reader.readLine()) != null) {
			response.append(output);
		}

		System.out.println(response.toString());
	}

}
