/**
 * Created by Pritam Sangani on 31/10/2017.
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static void main(String[] args) {
        String[] flyarray = {"dragonfly", "horsefly", "greenfly", "fruitfly", "housefly"};
        List<String> flylist = Arrays.asList(flyarray);

        System.out.println("Flylist: >>>");
        printlist(flylist);

    }

    public static void printlist(List<String> alist) {
        for (String s : alist) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println();
    }
}
