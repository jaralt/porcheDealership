import java.util.*;

public class CarFactory {
    private static final String[] availableColors = { "Red", "Blue", "Black", "White", "Silver", "Gray", "Green", "Orange", "Grey" }; 
    private static final String[] availableMake = { "Porsche"}; 
    private static final String[] availableModel = { "Red", "Blue", "Black", "White", "Silver", "Gray", "Green", "Orange", "Grey" }; //implement same way as colors

    private static Scanner scanner = new Scanner(System.in);

    public static Car createCar(String engineType, String make, String model, int year, String color, double price, int mileage, String vin) {
        double fuelTankCapacity;
        double batteryCapacity;

        if (!isValidColor(color)) { 
            System.out.println("Invalid color! Please choose from: " + Arrays.toString(availableColors));
            return null;
        }

        switch (engineType.toLowerCase()) {
            case "gas":
                System.out.println("Enter the fuel tank capacity:");
                fuelTankCapacity = scanner.nextDouble();
                scanner.nextLine();
                return new GasCar(make, model, year, color, price, mileage, fuelTankCapacity, vin);
            case "electric":
                System.out.println("Enter the battery capacity:");
                batteryCapacity = scanner.nextDouble();
                scanner.nextLine();
                return new ElectricCar(make, model, year, color, price, mileage, batteryCapacity, vin);
            case "hybrid":
                System.out.println("Enter the battery capacity:");
                batteryCapacity = scanner.nextDouble();
                System.out.println("Enter the fuel tank capacity:");
                fuelTankCapacity = scanner.nextDouble();
                scanner.nextLine();
                return new HybridCar(make, model, year, color, price, mileage, batteryCapacity, fuelTankCapacity, vin);
            default:
                System.out.println("Invalid engine type.");
                return null;
        }
    }

    private static boolean isValidColor(String color) { //ChatGPT helped with this idea. before we let users type any string for color. We needed to use an Array in our project and this was its suggestion
        for (String validColor : availableColors) {
            if (validColor.equalsIgnoreCase(color)) {
                return true;
            }
        }
        return false;
    }
}
