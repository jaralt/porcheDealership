import java.util.*;

public class Dealership {
	Scanner scanner = new Scanner(System.in);
    private List<Car> inventory; 
    private HashMap<String, Car> carMap;
    private HashSet<String> soldCars; // ChatGPT came up with the idea to use HashSets to track sold cars, we couldn't think of what to use Hashsets for before this.

    public Dealership() {
        this.inventory = new ArrayList<>();
        this.carMap = new HashMap<>();
        this.soldCars = new HashSet<>(); 
    }

    public void addCar(Car car) {
    	
    	 if (soldCars.contains(car.getVin())) {
    	        System.out.println("Error: This car's VIN has already been sold.");
    	 }
    	 else {
        inventory.add(car);
        carMap.put(car.getVin(), car);
    	 }
    }

    public void displayInventory() {
        for (Car car : inventory) {
            car.printCarDetails();
            System.out.println();
        }
    }

    public void buyCar(String vin, double tradeInValue) {
        Car car = carMap.get(vin); 
        if (car != null) {
            double newCarPrice = car.getPrice();
            double finalPrice = newCarPrice - tradeInValue;

            System.out.println("The " + car.getYear() + " " + car.getModel() + " is priced at $" + newCarPrice);

            if (tradeInValue > 0) {
                System.out.println("After applying your trade-in value of $" + tradeInValue + 
                                   ", the final price is $" + finalPrice);
            }
        	
        	System.out.println("Would you like to pay over time? We don't charge interest: ");
        	String choice = scanner.nextLine();
        	
        	if(choice.equalsIgnoreCase("yes")) {
        		
        		System.out.println("For how many months would you like to finance this car? ");
        		
        		int months = scanner.nextInt();
        		
        		
        		
        		double monthlyCost = finalPrice/months;
        		
        		System.out.println("The " + car.getYear() + " " + car.getModel() + " sold for $" + finalPrice);
        		System.out.println();
        		System.out.println("Your monthly payment is $" + monthlyCost);
        		
        	}
        	
        	else {
        		
        		System.out.println("The " + car.getModel() + "sold for $" + finalPrice);
     
        	}
        	
            inventory.remove(car);
            carMap.remove(vin);
            soldCars.add(vin); 
            
        } else {
            System.out.println("This car is not available. Make sure you entered the correct VIN");
        }
    }
    
    public void tradeInCar(String vin) {
    	
    	if (carMap.containsKey(vin)) {
    		
    		System.out.println("You can't trade in a car that we already own.");
    		
    	}
    	
    	else {
    		
    		
        System.out.println("Enter the EngineType (Gas, Hybrid, Electric):");
        String engineType = scanner.nextLine();
        
        System.out.println("Enter the make of the car:");
        String make = scanner.nextLine();
        
        
        System.out.println("Enter the model of the car:");
        String model = scanner.nextLine();
        
        System.out.println("Enter the year of the car:");
        int year = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Enter the color of the car:");
        String color = scanner.nextLine();
        
        System.out.println("Enter the price of the car:");
        double price = scanner.nextDouble();
        
        System.out.println("Enter the mileage of the car:");
        int mileage = scanner.nextInt();
        scanner.nextLine();

        Car tradedCar = CarFactory.createCar(engineType, make, model, year, color, price, mileage, vin);
        if (tradedCar != null) {
        	
        	double tradeInValue = calculateTradeInValue(tradedCar);
            System.out.println("Your trade-in value is: $" + tradeInValue); // create an option to apply the trade in amount to buying new car. 
            
            

            inventory.add(tradedCar); 
            carMap.put(vin, tradedCar);
            System.out.println("Car successfully traded in and added to inventory.");
            
            
            System.out.println("Would you like to purchase a new car using this trade-in value? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
            	System.out.println("Here is a list of cars in our inventory: ");
            	System.out.println();
            	 displayInventory();
                System.out.println("Enter the VIN of the car you'd like to purchase:");
                String newCarVin = scanner.nextLine();
                buyCar(newCarVin, tradeInValue); 
            }
            
        } else {
            System.out.println("Error! Invalid input!");
        }
    	}
    }

    public void findCarByVin(String vin) {
    	
    	
    	  Car car = carMap.get(vin); 

    	    if (car != null) {
    	    	
    	    car.printCarDetails(vin);
    	        
    	    } 
    	    
    	    else {
    	    	
    	        System.out.println("No car with that VIN found."); // Error message for invalid VIN - CHATGPT Helped with this error handling, program would crash if you put in wrong vin before this
    	        
    	       }
    }
    
    
    private double calculateTradeInValue(Car car) {
        double tradeInValue;
        double  mileageDepreciation;

        int year = car.getYear();
        switch (year) {
            case 2024:
                tradeInValue = car.getPrice() * 0.7;
                break;
            case 2023:
                tradeInValue = car.getPrice() * 0.6;
                break;
            case 2022:
                tradeInValue = car.getPrice() * 0.5;
                break;
            default:
                tradeInValue = car.getPrice() * 0.4; 
                break;
        }

        switch (car.getEngineType().toLowerCase()) {
            case "electric":
            	
              mileageDepreciation = (car.getMileage() * .18); // how much electric cars depreciate per mile according to google
            	
                tradeInValue -= mileageDepreciation;
                
                break;
            case "hybrid":
            	 mileageDepreciation = (car.getMileage() * 0.09);// how much hybrid cars depreciate per mile according to google
                tradeInValue -= mileageDepreciation;
                break;
        
        case "gas": 
            	 mileageDepreciation = (car.getMileage() * .11);// how much gas cars depreciate per mile according to google
                tradeInValue -= mileageDepreciation;
                break;
        	
        }

        return tradeInValue;
    }
  
}


