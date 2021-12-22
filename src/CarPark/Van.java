package CarPark;

import java.awt.*;

public class Van extends Vehicle{

    public Van(String vehicleRegNumber, DateTime enterTime, VehicleType type, Color color) {
        super(vehicleRegNumber, enterTime, type, color, 2.0);
    }

    @Override
    public String toString() {
        return "Van{super=${super.toString()}}";
    }
}
