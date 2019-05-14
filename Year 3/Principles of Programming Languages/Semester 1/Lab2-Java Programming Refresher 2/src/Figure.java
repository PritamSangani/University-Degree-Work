/**
 * Created by Pritam Sangani on 02/10/2018.
 */
public abstract class Figure {
    public String name;

    Figure() {
        this.name = this.getClass().getSimpleName();
    }

    public abstract double Area();
}
