import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author Pritam Sangani (16039231)
 * @see com.sun.net.httpserver.HttpHandler
 * Acts as a handler for the RESTful route to retrieve a Student with a given StudentNumber from the Student Database within the Student Web Service
 */
public class ShowHandler implements HttpHandler {
    /**
     * <b>Handles the request to retrieve an individual Student in the database and generates a response back to the end user returning the Student in JSON format if it has been successfully executed.</b>
     * @param he HttpExchange object passed into the method
     * @throws IOException
     */
    @Override
    public void handle(HttpExchange he) throws IOException {
        HashMap<String,String> params = querySplit(he.getRequestURI().getQuery());
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));

        StudentDAO dao = new StudentDAO();
        Gson gson = new Gson();
        String student = "";


        try {
            Student stu = dao.getStudent(params.get("stuID"));
            student = gson.toJson(stu);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        he.sendResponseHeaders(200, 0);
        out.write(student);
        out.close();

    }

    /**
     * Method to split multiple URL queries and put them into a HashMap for ease of use and access
     * @param query URL query
     * @return a Hash Map containing the key value pairs of URL parameters
     */
    private HashMap<String,String> querySplit(String query) {
        HashMap<String, String> result = new HashMap<>();

        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length > 1) {
                result.put(pair[0], pair[1]);
            } else {
                result.put(pair[0], "");
            }
        }
        return result;
    }
}
