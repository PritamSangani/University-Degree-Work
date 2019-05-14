import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.sql.SQLException;

/**
 * @author Pritam Sangani (16039231)
 * @see com.sun.net.httpserver.HttpHandler
 * <b>Acts as a handler for the RESTful route to insert a Student into the Student Database within the Student Web Service</b>
 */
public class InsertHandler implements HttpHandler {

    /**
     * @param he HttpExchange object passed into the method
     * @throws IOException
     * <b>Handles the request to insert a Student and generates a response back to the end user stating whether the request has been successfully executed.</b>
     */
    @Override
    public void handle(HttpExchange he) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(he.getRequestBody()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));

        StudentDAO dao = new StudentDAO();
        Gson gson = new Gson();

        Student stu = gson.fromJson(in, Student.class);

        try {
            dao.insertStu(stu);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        he.sendResponseHeaders(200, 0);
        out.write("Inserted " + stu.getName() + " into student database");
        out.close();
        in.close();
    }
}
