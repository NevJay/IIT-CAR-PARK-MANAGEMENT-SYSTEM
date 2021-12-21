package CarPark;

import java.awt.*;

public class Car extends Vehicle{

    public Car(String vehicleRegNumber, DateTime enterTime,/*DateTime exitTime*/ VehicleType type, Color color) {
        super(vehicleRegNumber, enterTime, type, color, 1.0);
    }

    @Override
    public String toString() {
        return "Car{super=${super.toString()}}";
    }
}
