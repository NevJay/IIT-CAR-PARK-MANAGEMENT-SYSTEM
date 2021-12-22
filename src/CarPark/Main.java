package CarPark;

import org.apache.commons.lang.StringUtils;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double[] slot = {60.0,60.0,60.0,60.0,60.0,60.0};
        List<Vehicle> vehicleList = new ArrayList<>();
        List<Integer> floorList = new ArrayList<>();
        IITCarParkManager first = new IITCarParkManager(vehicleList, floorList, slot);
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("""
                    
                    1. Add Vehicle
                    2. Delete Vehicle
                    3. Print the list of the vehicles currently parked
                    4. Percentage of different types of vehicles currently parked
                    5. Vehicle that is parked for the longest time
                    6. Last vehicle that was parked
                    7. Print the list of vehicles, which enter in the parking on a specified day
                    8. Parking charges for each customer
                    9. Exit

                    Enter activity to be done :\s""");
            int activity = scanner.nextInt();
            if (activity == 9) {
                break;
            }
            else if (activity == 3) {
                first.printVehicleParked();
                continue;
            }
            else if (activity == 4) {
                first.printPercentage();
                continue;
            }
            else if (activity == 5) {
                Vehicle longest = first.printLongest();
                System.out.printf("%s\n", StringUtils.center("Vehicle Parked For Longest Time",80));
                System.out.printf("|%s|%s|%s|%s|\n",StringUtils.center("Vehicle Registration Number",30),
                        StringUtils.center("Date",16),
                        StringUtils.center("Time",9),
                        StringUtils.center("Vehicle Type",20));
                System.out.printf("|%s|%s/%s/%s|%s:%s|%s|\n",StringUtils.center(longest.getVehicleRegNumber(),30),
                        StringUtils.center(String.valueOf(longest.getEnterTime().getYear()),6),
                        StringUtils.center(String.valueOf(longest.getEnterTime().getMonth()),4),
                        StringUtils.center(String.valueOf(longest.getEnterTime().getDay()),4),
                        StringUtils.center(longest.getEnterTime().getHour(),4),
                        StringUtils.center(longest.getEnterTime().getMinutes(),4),
                        StringUtils.center(String.valueOf(longest.getType()),20));
                continue;
            }
            else if (activity == 6) {
                Vehicle last = first.printLast();
                System.out.printf("%s\n", StringUtils.center("Vehicle Parked Last",80));
                System.out.printf("|%s|%s|%s|%s|\n",StringUtils.center("Vehicle Registration Number",30),
                        StringUtils.center("Date",16),
                        StringUtils.center("Time",9),
                        StringUtils.center("Vehicle Type",20));
                System.out.printf("|%s|%s/%s/%s|%s:%s|%s|\n",StringUtils.center(last.getVehicleRegNumber(),30),
                        StringUtils.center(String.valueOf(last.getEnterTime().getYear()),6),
                        StringUtils.center(String.valueOf(last.getEnterTime().getMonth()),4),
                        StringUtils.center(String.valueOf(last.getEnterTime().getDay()),4),
                        StringUtils.center(last.getEnterTime().getHour(),4),
                        StringUtils.center(last.getEnterTime().getMinutes(),4),
                        StringUtils.center(String.valueOf(last.getType()),20));
                continue;
            }
            else if (activity == 7){
                System.out.println("Enter year : ");
                int year = scanner.nextInt();
                System.out.println("Enter month : ");
                int month = scanner.nextInt();
                System.out.println("Enter day : ");
                int day = scanner.nextInt();
                DateTime dateTime = new DateTime(year, month, day, "0", "0");
                List<Vehicle> vehiclesPerDay = first.printVehicleByDate(dateTime);
                System.out.printf("%s\n", StringUtils.center("Vehicle Parked On Specified Day",80));
                System.out.printf("|%s|%s|%s|%s|\n",StringUtils.center("Vehicle Registration Number",30),
                        StringUtils.center("Date",16),
                        StringUtils.center("Time",9),
                        StringUtils.center("Vehicle Type",20));
                for (Vehicle vehicle: vehiclesPerDay){
                    System.out.printf("|%s|%s/%s/%s|%s:%s|%s|\n",StringUtils.center(vehicle.getVehicleRegNumber(),30),
                            StringUtils.center(String.valueOf(vehicle.getEnterTime().getYear()),6),
                            StringUtils.center(String.valueOf(vehicle.getEnterTime().getMonth()),4),
                            StringUtils.center(String.valueOf(vehicle.getEnterTime().getDay()),4),
                            StringUtils.center(vehicle.getEnterTime().getHour(),4),
                            StringUtils.center(vehicle.getEnterTime().getMinutes(),4),
                            StringUtils.center(String.valueOf(vehicle.getType()),20));
                }
                continue;
            }
            else if (activity == 8){
                System.out.println("Enter year : ");
                int year = scanner.nextInt();
                System.out.println("Enter month : ");
                int month = scanner.nextInt();
                System.out.println("Enter day : ");
                int day = scanner.nextInt();
                System.out.println("Enter hours : ");
                String hour = scanner.next();
                System.out.println("Enter minutes : ");
                String minutes = scanner.next();
                DateTime presentTime = new DateTime(year, month, day, hour, minutes);
                List<Integer> chargesPerVehicle = first.calculateCharges(presentTime);
                System.out.printf("%s\n", StringUtils.center("Charges Of Vehicles Parked",100));
                System.out.printf("|%s|%s|%s|%s|%s|\n",StringUtils.center("Vehicle Registration Number",30),
                        StringUtils.center("Entry Date",16),
                        StringUtils.center("Time",9),
                        StringUtils.center("Vehicle Type",20),
                        StringUtils.center("Cost per slot",20));
                int count = 0;
                for (Vehicle vehicle: first.getListOfVehicles()) {
                    System.out.printf("|%s|%s/%s/%s|%s:%s|%s|%s|\n", StringUtils.center(vehicle.getVehicleRegNumber(), 30),
                            StringUtils.center(String.valueOf(vehicle.getEnterTime().getYear()), 6),
                            StringUtils.center(String.valueOf(vehicle.getEnterTime().getMonth()), 4),
                            StringUtils.center(String.valueOf(vehicle.getEnterTime().getDay()), 4),
                            StringUtils.center(vehicle.getEnterTime().getHour(), 4),
                            StringUtils.center(vehicle.getEnterTime().getMinutes(), 4),
                            StringUtils.center(String.valueOf(vehicle.getType()), 20),
                            StringUtils.center("LKR " + chargesPerVehicle.get(count), 20));
                    count ++;
                }
                continue;
            }
            System.out.println("Enter vehicle registration number : ");
            String regNumber = scanner.next();
            if (activity == 1) {
                System.out.println("""
                        Car = 'c'
                        Van = 'v'
                        MiniBus = 'b'
                        MiniLorry = 'l'
                        MotorBike = 'm'

                        Enter your vehicle type :\s""");
                char vehicleType = scanner.next().charAt(0);
                System.out.println("Enter year : ");
                int year = scanner.nextInt();
                System.out.println("Enter month : ");
                int month = scanner.nextInt();
                System.out.println("Enter day : ");
                int day = scanner.nextInt();
                System.out.println("Enter hours : ");
                String hour = scanner.next();
                System.out.println("Enter minutes : ");
                String minutes = scanner.next();
                DateTime entry = new DateTime(year, month, day, hour, minutes);
                Random rand = new Random();
                // assume that entrance detects the color of the vehicle.
                float r = rand.nextFloat();
                float g = rand.nextFloat();
                float b = rand.nextFloat();
                Color color = new Color(r, g, b);
                if (vehicleType == 'c') {
                    Car veh1 = new Car(regNumber, entry, VehicleType.Car, color);
                    slot = first.addVehicle(veh1);
                    for (int i = 0; i < 6; i++) {
                        System.out.println("Remaining slots in floor " + (i + 1) + " : " + slot[i]);
                    }
                } else if (vehicleType == 'v') {
                    Van veh1 = new Van(regNumber, entry, VehicleType.Van, color);
                    slot = first.addVehicle(veh1);
                    for (int i = 0; i < 6; i++) {
                        System.out.println("Remaining slots in floor " + (i + 1) + " : " + slot[i]);
                    }
                } else if (vehicleType == 'b') {
                    MiniBus veh1 = new MiniBus(regNumber, entry, VehicleType.MiniBus, color);
                    slot = first.addVehicle(veh1);
                    for (int i = 0; i < 6; i++) {
                        System.out.println("Remaining slots in floor " + (i + 1) + " : " + slot[i]);
                    }
                } else if (vehicleType == 'l') {
                    MiniLorry veh1 = new MiniLorry(regNumber, entry, VehicleType.MiniLorry, color);
                    slot = first.addVehicle(veh1);
                    for (int i = 0; i < 6; i++) {
                        System.out.println("Remaining slots in floor " + (i + 1) + " : " + slot[i]);
                    }
                } else if (vehicleType == 'm') {
                    System.out.println("eee");
                    MotorBike veh1 = new MotorBike(regNumber, entry, VehicleType.MotorBike, color);
                    slot = first.addVehicle(veh1);
                    for (int i = 0; i < 6; i++) {
                        System.out.println("Remaining slots in floor " + (i + 1) + " : " + slot[i]);
                    }
                }
                else {
                    System.out.println("Wrong Input");
                }
            }
            else if (activity == 2) {
                Vehicle delete = first.deleteVehicle(regNumber);
                if (delete != null) {
                    System.out.println("\nA " + delete.getType() + " was removed.");
                }
            }
        }while (true);
    }
}
