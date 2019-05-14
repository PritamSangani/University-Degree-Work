/**
 * Created by Pritam Sangani on 16/10/2017.
 */
public class Motorbike implements IVehicle {
    private int age;
    private final float baseTax = 15f;

    public Motorbike(int age){
        this.age = age;
    }

    @Override
    public float TaxValue() {
        return baseTax * age;
    }

    @Override
    public String VehicleType() {
        return "Motorbike";
    }
}
