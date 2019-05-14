/**
 * Created by Pritam Sangani on 31/10/2017.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    public static void main(String[] args) {
        ArrayList<String> insects = new ArrayList<String>();
        insects.add("horsefly");
        insects.add("butterfly");
        insects.add("dragonfly");
        insects.add("fly");
        int size = insects.size();
        Collections.sort(insects);

        for (int i = 0; i < size; i++) {
            System.out.println("insect " + i + " : " + insects.get(i));

            if (insects.get(i).equals("fly")) {
                System.out.println("Fly found! ");
            }
            else {
                System.out.println("Fly not found :(");
            }
        }


    }
}
