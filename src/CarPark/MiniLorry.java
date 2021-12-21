package CarPark;

import java.awt.*;

public class MiniLorry extends Vehicle{

    public MiniLorry(String vehicleRegNumber, DateTime enterTime,/* DateTime exitTime,*/ VehicleType type, Color color) {
        super(vehicleRegNumber, enterTime, type, color, 3.0);
    }

    @Override
    public String toString() {
        return "MiniLorry{super=${super.toString()}}";
    }
}
