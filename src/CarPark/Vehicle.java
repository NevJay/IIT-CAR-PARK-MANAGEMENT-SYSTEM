package CarPark;

import java.awt.*;

public abstract class Vehicle {
    private String vehicleRegNumber;
    private DateTime enterTime;
    private final double SPACE_TAKEN;
    private VehicleType type;
    private Color color;

    public Vehicle(String vehicleRegNumber, DateTime enterTime, VehicleType type, Color color, double SPACE_TAKEN ) {
        this.vehicleRegNumber = vehicleRegNumber;
        this.enterTime = enterTime;
        this.type = type;
        this.color = color;
        this.SPACE_TAKEN = SPACE_TAKEN;
    }

    public String getVehicleRegNumber() {
        return vehicleRegNumber;
    }


    public DateTime getEnterTime() {
        return enterTime;
    }

    public VehicleType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public double getSPACE_TAKEN() {
        return SPACE_TAKEN;
    }

}
