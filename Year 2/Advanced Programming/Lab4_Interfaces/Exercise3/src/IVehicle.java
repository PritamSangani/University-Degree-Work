/**
 * Created by Pritam Sangani on 16/10/2017.
 * This is an interface so that common methods can be achieved for different types of vehicles.
 * @author Pritam Sangani
 * @version 1.0
 */

public interface IVehicle {
    /**
     * Method to calculate the tax value of a vehicle after a number of years
     * @return the tax value of the vehicle
     */
    float TaxValue();

    /**
     * Method to return the type of vehicle as defined in String format
     * @return type of vehicle in String format
     */
    String VehicleType();
}
