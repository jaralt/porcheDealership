import java.util.*;

public class CarFactory {
    private static final String[] availableColors = { "Red", "Blue", "Black", "White", "Silver", "Gray", "Green", "Orange", "Grey" }; 
    private static final String[] availableModels = {
            "Taycan",
            "Taycan Turbo",
            "Taycan 4S",
            "911 GT3",
            "Cayenne",
            "Panamera",
            "911 Carrera",
            "Cayenne E-Hybrid",
            "Panamera 4 E-Hybrid",
            "Macan",
            "911 Turbo",
            "718 Boxster",
            "718 Cayman",
            "Panamera Sport Turismo",
            "Cayenne Coupe",
            "Macan S",
            "911 GT2 RS",
            "718 Spyder",
            "Taycan Cross Turismo"
    };

    private static Scanner scanner = new Scanner(System.in);

    public static Car createCar(String engineType, String make, String model, int year, String color, double price, int mileage, String vin) {
        double fuelTankCapacity;
        double batteryCapacity;

        if (!isValidColor(color)) { 
            System.out.println("Invalid color! Please choose from: " + Arrays.toString(availableColors));
            return null;
        }
        
        if(!isValidMake(make)) {
        	System.out.println("Invalid make! This is a Porsche dealership");
        	return null;
        }
        
        if(isValidModel(model)) {
        	
        	System.out.println("Invalid model! Please choose from: " + Arrays.toString(availableModels));
        	
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
    													//We decided to implement it ourselves for Make and Model too
        for (String validColor : availableColors) {
            if (validColor.equalsIgnoreCase(color)) {
                return true;
            }
        }
        return false;
    }
    
    
    private static boolean isValidMake(String make) {
    	
    	if (make.equalsIgnoreCase("Porsche")) {
    		
    		return true;
    	}
    
    	return false;
    }
    
    private static boolean isValidModel(String model) {
    	
    	for (String validModel : availableModels) {
    		
    		if (model.equalsIgnoreCase(model)) {
    			return true;
    		}
    	}
    	return false;
    	
    }
}

