/**
 * Created by Pritam Sangani on 03/10/2017.
 */

public class Controller {
    public static void main(String[] args) {
        PolySolve p = new PolySolve(1,1,-2);
        double[] solution;

        solution = p.solve();

        System.out.println("Roots > "+solution[0] + ", "+solution[1]);
    }
}
