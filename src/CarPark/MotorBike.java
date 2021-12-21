package CarPark;

import java.awt.*;

public class MotorBike extends Vehicle{

    public MotorBike(String vehicleRegNumber, DateTime enterTime,/* DateTime exitTime,*/ VehicleType type, Color color) {
        super(vehicleRegNumber, enterTime, type, color, 0.3333);
    }

    @Override
    public String toString() {
        return "MotorBike{super=${super.toString()}}";
    }
}
