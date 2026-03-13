import java.util.HashMap;

public class Problem8 {

    static HashMap<String, Integer> parkingLot = new HashMap<>();
    static int spot = 1;

    public static void parkVehicle(String license) {
        parkingLot.put(license, spot);
        System.out.println("Vehicle " + license + " parked at spot " + spot);
        spot++;
    }

    public static void exitVehicle(String license) {
        if (parkingLot.containsKey(license)) {
            System.out.println("Vehicle " + license + " left spot " + parkingLot.get(license));
            parkingLot.remove(license);
        } else {
            System.out.println("Vehicle not found");
        }
    }

    public static void main(String[] args) {
        parkVehicle("ABC123");
        parkVehicle("XYZ789");

        exitVehicle("ABC123");
    }
}
