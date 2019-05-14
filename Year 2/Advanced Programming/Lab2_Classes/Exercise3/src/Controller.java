/**
 * Created by Pritam Sangani on 03/10/2017.
 */

import java.util.Random;

public class Controller {
    public static void main(String[] args) {
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            System.out.print(rand.nextInt(10)+ " ");
        }

        /////////////////////////////////////////////
        Random rand2 = new Random(System.currentTimeMillis());

        for (int i = 0; i < 5; i++) {
            System.out.print(rand2.nextDouble()+ " ");
        }
    }
}
