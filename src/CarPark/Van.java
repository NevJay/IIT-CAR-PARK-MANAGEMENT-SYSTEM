package CarPark;

import java.awt.*;

public class Van extends Vehicle{

    public Van(String vehicleRegNumber, DateTime enterTime,/* DateTime exitTime,*/ VehicleType type, Color color) {
        super(vehicleRegNumber, enterTime, type, color, 3.0);
    }

    @Override
    public String toString() {
        return "Van{super=${super.toString()}}";
    }
}
