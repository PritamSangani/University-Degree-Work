import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * @author Pritam Sangani (16039231)
 * @see com.sun.net.httpserver.HttpHandler
 * Acts as a handler for the RESTful route to enter the Student Web Service. No CRUD operations are associated with this handler.
 * This handler is purely a means to display the instructions to use the Student Web Service.
 */
public class HomeHandler implements HttpHandler {
	/**
	 * @param he HttpExchange object passed into the method
	 * @throws IOException
	 *
	 * <b>Handles the response when the Web Service is accessed at the root context</b>
	 */
	public void handle(HttpExchange he) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		he.sendResponseHeaders(200, 0);
		out.write("Welcome to the student webservice");
		out.close();
	}
}
