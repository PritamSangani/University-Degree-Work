/**
 * Created by Pritam Sangani on 02/10/2018.
 */
public class Triangle extends Figure {
    double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double Area() {
        return 0.5 * base * height;
    }
}
