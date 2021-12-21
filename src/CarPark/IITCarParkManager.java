package CarPark;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;


public class IITCarParkManager implements CarParkManager {
    private static List<Vehicle> listOfVehicles;
    private static List<Integer> storedFloor;
    private static double[] availableSlots = new double[6];

    public IITCarParkManager(List<Vehicle> listOfVehicles, List<Integer> storedFloor, double[] availableSlots) {
        this.listOfVehicles = listOfVehicles;
        this.storedFloor = storedFloor;
        this.availableSlots = availableSlots;
    }

    public List<Vehicle> getListOfVehicles() {
        return listOfVehicles;
    }

    public double[] getAvailableSlots() {
        return availableSlots;
    }

    @Override
    public double[] addVehicle(Vehicle vehicle) {
        //add a new vehicle to the car park.
        if (vehicle.getType() == VehicleType.Car){
            for (int i = 0; i < 6; i++){
                if (availableSlots[5] < 1){
                    System.out.println("There are no space available to park\n");
                    break;
                }
                else if (availableSlots[i] > 0){
                    availableSlots[i] -= vehicle.getSPACE_TAKEN();
                    listOfVehicles.add(vehicle);
                    storedFloor.add(i);
                    //System.out.println(Arrays.toString(availableSlots));
                    break;
                }
            }

        }
        else if (vehicle.getType() == VehicleType.Van){
            for (int i = 0; i < 3; i++){
                if (availableSlots[2] < 1){
                    System.out.println("There are no space available to park");
                    break;
                }
                else if (availableSlots[i] > 0){
                    availableSlots[i] -= vehicle.getSPACE_TAKEN();
                    listOfVehicles.add(vehicle);
                    storedFloor.add(i);
                    //System.out.println(Arrays.toString(availableSlots));
                    break;
                }
            }
        }
        else if (vehicle.getType() == VehicleType.MiniBus){
            for (int i = 0; i < 1; i++){
                if (availableSlots[0] < 3){
                    System.out.println("There are no space available to park");
                    break;
                }
                else if (availableSlots[i] > 0){
                    availableSlots[i] -= vehicle.getSPACE_TAKEN();
                    listOfVehicles.add(vehicle);
                    storedFloor.add(i);
                    //System.out.println(Arrays.toString(availableSlots));
                    break;
                }
            }
        }
        else if (vehicle.getType() == VehicleType.MiniLorry){
            for (int i = 0; i < 1; i++){
                if (availableSlots[0] < 3){
                    System.out.println("There are no space available to park");
                    break;
                }
                else if (availableSlots[i] > 0){
                    availableSlots[i] -= vehicle.getSPACE_TAKEN();
                    listOfVehicles.add(vehicle);
                    storedFloor.add(i);
                    //System.out.println(Arrays.toString(availableSlots));
                    break;
                }
            }
        }
        else if (vehicle.getType().equals(VehicleType.MotorBike)){
            for (int i = 0; i < 3; i++){
                if (availableSlots[2] < 0.3333){
                    System.out.println("There are no space available to park");
                    break;
                }
                else if (availableSlots[i] > 0){
                    availableSlots[i] -= vehicle.getSPACE_TAKEN();
                    listOfVehicles.add(vehicle);
                    storedFloor.add(i);
                    //System.out.println(Arrays.toString(availableSlots));
                    break;
                }
            }
        }
        return availableSlots;
    }

    @Override
    public Vehicle deleteVehicle(String regNumber) {
        //traverse the vehicles in the car park to check and delete the asked vehicle.
        for (Vehicle vehicle: listOfVehicles){
            if (regNumber.equals(vehicle.getVehicleRegNumber())){
                int index = listOfVehicles.indexOf(vehicle);
                listOfVehicles.remove(vehicle);
                availableSlots[storedFloor.get(index)] += vehicle.getSPACE_TAKEN();
                return vehicle;
            }
        }
        System.out.println("Vehicle not found");
        return null;
    }

    @Override
    public void printVehicleParked() {
        System.out.printf("|%s|%s|%s|%s|\n",StringUtils.center("Vehicle Registration Number",30),
                StringUtils.center("Date",16),
                StringUtils.center("Time",9),
                StringUtils.center("Vehicle Type",20));
        //All the vehicles inside the car park will be displayed.
        for (int i = listOfVehicles.size(); i > 0; i--){
            System.out.printf("|%s|%s/%s/%s|%s:%s|%s|\n",StringUtils.center(listOfVehicles.get(i-1).getVehicleRegNumber(),30),
                    StringUtils.center(String.valueOf(listOfVehicles.get(i-1).getEnterTime().getYear()),6),
                    StringUtils.center(String.valueOf(listOfVehicles.get(i-1).getEnterTime().getMonth()),4),
                    StringUtils.center(String.valueOf(listOfVehicles.get(i-1).getEnterTime().getDay()),4),
                    StringUtils.center(listOfVehicles.get(i-1).getEnterTime().getHour(),4),
                    StringUtils.center(listOfVehicles.get(i-1).getEnterTime().getMinutes(),4),
                    StringUtils.center(String.valueOf(listOfVehicles.get(i-1).getType()),20));
        }
    }

    @Override
    public void printPercentage() {
        double carCount = 0;
        double vanCount = 0;
        double lorryCount = 0;
        double busCount = 0;
        double bikeCount = 0;
        double total = 0;
        //calculate percentages of specific vehicles in the car park.
        for (Vehicle vehicle: listOfVehicles){
            if (VehicleType.Car.equals(vehicle.getType())){
                carCount+=1;
                total+=1;
            }
            else if (VehicleType.Van.equals(vehicle.getType())){
                vanCount+=1;
                total+=1;
            }
            else if (VehicleType.MiniLorry.equals(vehicle.getType())){
                lorryCount+=1;
                total+=1;
            }
            else if (VehicleType.MiniBus.equals(vehicle.getType())){
                busCount+=1;
                total+=1;
            }
            else if (VehicleType.MotorBike.equals(vehicle.getType())){
                bikeCount+=1;
                total+=1;
            }
        }
        double carPercentage = ((carCount/total)*100);
        double vanPercentage = ((vanCount/total)*100);
        double lorryPercentage = ((lorryCount/total)*100);
        double busPercentage = ((busCount/total)*100);
        double bikePercentage = ((bikeCount/total)*100);
        System.out.println("Percentage of cars parked : " + carPercentage + "%" +
                "\nPercentage of vans parked : " + vanPercentage + "%" +
                "\nPercentage of mini lorries parked : " + lorryPercentage + "%" +
                "\nPercentage of mini buses parked : " + busPercentage + "%" +
                "\nPercentage of motor bikes parked : " + bikePercentage + "%");
    }

    @Override
    public Vehicle printLongest() {
        return listOfVehicles.get(0);
    }

    @Override
    public Vehicle printLast(){
        return listOfVehicles.get(listOfVehicles.size()-1);
    }

    @Override
    public List<Vehicle> printVehicleByDate(DateTime date) {
        List<Vehicle> vehicleByDate = new ArrayList<>();
        //traverse through the vehicles in the park to display vehicles parked on a specific day.
        for (Vehicle vehicle: listOfVehicles) {
            if (date.getYear() == vehicle.getEnterTime().getYear()){
                if (date.getMonth() == vehicle.getEnterTime().getMonth()){
                    if (date.getDay() == vehicle.getEnterTime().getDay()){
                        vehicleByDate.add(vehicle);
                    }
                }
            }
        }
        return vehicleByDate;
    }

    @SuppressWarnings("deprecation")
    @Override
    public List<Integer> calculateCharges(DateTime date) {
        int hour;
        long totTime;
        int cost;
        List<Integer> listOfCharges = new ArrayList<>();
        //charges for each vehicle in the car park will be displayed.
        for (Vehicle vehicle : listOfVehicles) {
            cost = 0;
            hour = Integer.parseInt(date.getHour()) - Integer.parseInt(vehicle.getEnterTime().getHour());
            Date presentDate = new Date(date.getYear(),date.getMonth(),date.getDay());
            Date entryDate = new Date(vehicle.getEnterTime().getYear(),vehicle.getEnterTime().getMonth(),vehicle.getEnterTime().getDay());
            long diff = presentDate.getTime() - entryDate.getTime();
            totTime = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) * 24 + hour;
            if (totTime > 3) {
                cost += 900 * vehicle.getSPACE_TAKEN();
                totTime -= 3;
                long tempCost = (long) (100 * totTime * vehicle.getSPACE_TAKEN());
                cost += tempCost;
            } else {
                cost += 300 * totTime * vehicle.getSPACE_TAKEN();
            }
            listOfCharges.add(cost);
        }
        return listOfCharges;
    }
}
