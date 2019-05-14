import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Pritam Sangani on 14/11/2017.
 */
public class Controller {
    public static void main(String[] args) throws IOException {
        URL url;
        BufferedReader in = null;
        try {
            url = new URL("http://www2.mmu.ac.uk/");
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            String input;
            while ((input = in.readLine()) != null) {
                System.out.println(input);
            }
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL found "+e);
        } catch (IOException ioe) {
            System.out.println("Connection Problem "+ioe);
        } finally {
            in.close();
        }
    }

}
