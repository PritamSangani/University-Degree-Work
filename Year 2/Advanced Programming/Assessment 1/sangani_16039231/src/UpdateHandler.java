import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.sql.SQLException;

/**
 * @author Pritam Sangani (16039231)
 * @see com.sun.net.httpserver.HttpHandler
 * Acts as a handler for the RESTful route to update the details for a Student already in the Student Database within the Student Web Service
 */
public class UpdateHandler implements HttpHandler {
    /**
     * Handles the request to update a Student in the Student Database
     * @param he HttpExchange object passed into the method
     * @throws IOException
     */
    @Override
    public void handle(HttpExchange he) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(he.getRequestBody()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));

        StudentDAO dao = new StudentDAO();
        Gson gson = new Gson();

        Student stu = gson.fromJson(in, Student.class);

        try {
            dao.updateStu(stu);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        he.sendResponseHeaders(200, 0);
        out.write("Updated " + stu.getName() + " in student database");
        out.close();
        in.close();

    }
}
