/**
 * Created by Pritam Sangani on 16/10/2017.
 * This Motorbike class implements the IVehicle interface.
 * It has two members namely age and baseTax.
 * The constructor takes in the parameter age and initialises it for the purpose of calculating the tax value of the motorbike.
 *
 * @author Pritam Sangani
 * @version 1.0
 * @see IVehicle
 */
public class Motorbike implements IVehicle{
    private int age;
    private final float baseTax = 15f;

    /**
     * The constructor to initialise a Motorbike object takes in only one parameter, age;
     * @param age = age of Motorbike
     */
    public Motorbike(int age){
        this.age = age;
    }

    /**
     * This method multiplies the baseTax rate and the age of the motorbike thus calculating the tax value of the motorbike.
     * @return tax value of the motorbike.
     */
    @Override
    public float TaxValue() {
        return baseTax * age;
    }

    /**
     * This method returns the type of vehicle in String format
     * @return type of vehicle
     */
    @Override
    public String VehicleType() {
        return "Motorbike";
    }
}
