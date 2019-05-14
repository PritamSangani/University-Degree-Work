/**
 * Created by Pritam Sangani on 03/10/2017.
 */

public class PolySolve {
    private double a, b, c;

    PolySolve(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] solve() {

        double roots[] = new double[2];

        roots[0] = (-b + Math.sqrt((b*b)-4*a*c))/(2*a);
        roots[1] = (-b - Math.sqrt((b*b)-4*a*c))/(2*a);

        return roots;
    }



}
