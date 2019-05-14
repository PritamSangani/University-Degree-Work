import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.Gson;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * @author Pritam Sangani (16039231)
 * @see com.sun.net.httpserver.HttpHandler
 * Acts as a handler for the RESTful route to retrieve all students in the Student Database within the Student Web Service
 */
public class GetHandler implements HttpHandler {

	/**
	 * @param he HttpExchange object passed into the method
	 * @throws IOException thrown when an I/O operation fails or is interrupted
	 *
	 * <b>Handles the request to retrieve all Students in the database and generates a response back to the end user returning the result in JSON format if the request has been successfully executed.</b>
	 */
	public void handle(HttpExchange he) throws IOException {

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));

		StudentDAO dao = new StudentDAO();
		ArrayList<Student> allStudents = new ArrayList<>();
		Gson gson = new Gson();

		try {
			allStudents = dao.getAllStudents();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		String students = gson.toJson(allStudents);
		he.sendResponseHeaders(200, 0);
		out.write(students);
		out.close();
	}
}
