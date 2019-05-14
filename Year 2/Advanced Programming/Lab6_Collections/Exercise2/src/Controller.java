/**
 * Created by Pritam Sangani on 31/10/2017.
 */
import java.util.HashMap;

public class Controller {
    public static void main(String[] args) {
        HashMap<String, String> phone = new HashMap<String, String>();

        phone.put("John", "3453");
        phone.put("Jenny", "3478");
        phone.put("Richard", "3567");
        phone.put("Helen", "4532");

        String who = "Jenny";
        String number = phone.get(who);
        System.out.println(who + " " + number);

        String key = phone.get("Andrew");

        if (key != null) {
            System.out.println("Found person");
        }
        else {
            System.out.println("Not found");
        }
    }
}
