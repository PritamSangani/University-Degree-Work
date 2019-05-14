import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

/**
 * @author Pritam Sangani (16039231)
 * <b>Acts as controller for the server and the Student Web Service</b>
 */

public class Controller {

	/**
	 * <b>Method to create and start the server as well as the contexts for the Web Service.</b>
	 * <i>Note: The port number at which the server is pointed is set at 8005 by default.</i>
	 * <br>
	 * There are 6 server contexts:
	 * <ul>
	 *     <li>The default home context available at "http://localhost:[port number]/"</li>
	 *     <li>The handler to retrieve all students in the database available at "http://localhost:[port number]/get-all-students"</li>
	 *     <li>The handler to insert a student in the database available at "http://localhost:[port number]/insert-student"</li>
	 *     <li>The handler to delete a student from the database available at "http://localhost:[port number]/delete-student"</li>
	 *     <li>The handler to update a student in the student database available at "http://localhost:[port number]/update-student"</li>
	 *     <li>The handler to retrieve a single student available at "http://localhost:[port number]/get-student"</li>
	 * </ul>
 	 * @param args takes in console arguments as is defined of a main method
	 */
	public static void main(String[] args) {
		
		try {
			//create a server at port 8005
			HttpServer server = HttpServer.create(new InetSocketAddress(8005), 0);

			//Handlers for all RESTful routes into the Web Service
			server.createContext("/", new HomeHandler());
			server.createContext("/get-all-students", new GetHandler());
			server.createContext("/insert-student", new InsertHandler());
			server.createContext("/delete-student", new DeleteHandler());
			server.createContext("/update-student", new UpdateHandler());
			server.createContext("/get-student", new ShowHandler());


			// start the server
			server.setExecutor(null);
			server.start();
			//get port number that the server is running on
			System.out.println("Server running on port "+server.getAddress().getPort());

		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
