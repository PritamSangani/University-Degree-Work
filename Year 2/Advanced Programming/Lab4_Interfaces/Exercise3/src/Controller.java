/**
 * Created by Pritam Sangani on 16/10/2017.
 */

public class Controller {
    public static void main(String[] args) {
        Car firstCar = new Car(6);
        Motorbike firstMotorbike = new Motorbike(7);

        System.out.println("Vehicle Type: " + firstCar.VehicleType() + " Tax: " + firstCar.TaxValue());
        System.out.println("Vehicle Type: " + firstMotorbike.VehicleType() + " Tax: " + firstMotorbike.TaxValue());
    }
}
