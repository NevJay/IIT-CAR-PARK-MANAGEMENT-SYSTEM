package CarPark;

import java.util.List;

public interface CarParkManager{
    double[] addVehicle(Vehicle vehicle);
    Vehicle deleteVehicle(String regNumber);
    void printVehicleParked();
    void printPercentage();
    Vehicle printLongest();
    Vehicle printLast();
    List<Vehicle> printVehicleByDate(DateTime date);
    List<Integer> calculateCharges(DateTime date);
}
