/**
 * Created by Pritam Sangani on 16/10/2017.
 * This Car class implements the IVehicle interface.
 * It has two members namely age and baseTax.
 * The constructor takes in the parameter age and initialises it for the purpose of calculating the tax value of the car.
 *
 * @author Pritam Sangani
 * @version 1.0
 * @see IVehicle
 *
 */
public class Car implements IVehicle{
    private int age;
    private final float baseTax = 25f;

    /**
     * The constructor to initialise a Car object takes in only one parameter, age;
     * @param age = age of Car
     */
    public Car(int age){
        this.age = age;
    }

    /**
     * This method multiplies the baseTax rate and the age of the car thus calculating the tax value of the car
     * @return tax value of the car.
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
        return "Car";
    }
}
