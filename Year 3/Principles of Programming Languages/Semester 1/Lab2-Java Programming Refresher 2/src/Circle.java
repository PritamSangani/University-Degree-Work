import static java.lang.Math.PI;

/**
 * Created by Pritam Sangani on 02/10/2018.
 */
public class Circle extends Figure {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double Area() {
        return PI * Math.pow(radius, 2);
    }
}
