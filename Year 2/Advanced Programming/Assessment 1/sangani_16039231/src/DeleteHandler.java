import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.sql.SQLException;

/**
 * @author Pritam Sangani (16039231)
 * @see com.sun.net.httpserver.HttpHandler
 * <b>Acts as a handler for the RESTful route to delete a Student from the Student Database within the Student Web Service</b>
 */
public class DeleteHandler implements HttpHandler {

    /**
     * @param he HttpExchange object passed into the method
     * @throws IOException thrown when an I/O operation fails or is interrupted
     *
     * <b>Handles the request to delete a Student and generates a response back to the end user stating whether the request has been successfully executed.</b>
     * A BufferedReader is created to receive the POSTed data and a BufferedWriter object is created to send back the response.
     *
     */
    @Override
    public void handle(HttpExchange he) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(he.getRequestBody()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));

        StudentDAO dao = new StudentDAO();

        String stuID = in.readLine();
        try {
            dao.deleteStu(stuID);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        he.sendResponseHeaders(200, 0);
        out.write("Deleted student with id " + stuID + " from student database");
        out.close();
        in.close();
    }
}
