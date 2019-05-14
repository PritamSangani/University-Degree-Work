/**
 * Created by Pritam Sangani on 02/10/2018.
 */
public class Rectangle extends Figure {
    double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double Area() {
        return width * height;
    }
}
