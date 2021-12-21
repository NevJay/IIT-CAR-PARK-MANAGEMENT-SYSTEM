package CarPark;

import java.awt.*;

public class MiniBus extends Vehicle{

    public MiniBus(String vehicleRegNumber, DateTime enterTime, /*DateTime exitTime,*/ VehicleType type, Color color) {
        super(vehicleRegNumber, enterTime, type, color, 3.0);
    }

    @Override
    public String toString() {
        return "MiniBus{super=${super.toString()}}";
    }
}
