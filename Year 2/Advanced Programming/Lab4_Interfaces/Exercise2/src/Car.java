/**
 * Created by Pritam Sangani on 16/10/2017.
 */
public class Car implements IVehicle{
    private int age;
    private final float baseTax = 25f;

    public Car(int age){
        this.age = age;
    }

    @Override
    public float TaxValue() {
        return baseTax * age;
    }

    @Override
    public String VehicleType() {
        return "Car";
    }
}
