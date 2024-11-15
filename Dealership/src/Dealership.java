
import java.util.*;

public class Dealership {
    private List<Car> inventory;
    
    private HashMap<String, Car> carMap; 
    

    public Dealership() {
        this.inventory = new ArrayList<>();
        this.carMap = new HashMap<>();
    }

    public void addCar(Car car) {
        inventory.add(car);
        carMap.put(car.getVin(), car);  
    }

    public void displayInventory() {
        for (Car car : inventory) {
            car.printCarDetails();
            System.out.println();
            
            
            
        }
      
    }
    
    public void buyCar(String vin) {
    	Car car = carMap.get(vin);
        if (inventory.contains(car)) {
            inventory.remove(car); 
            carMap.remove(vin);
            System.out.println("Car sold for $" + car.getPrice());
        } else {
            System.out.println("This car is not available in the inventory. Make sure you enter a VIN with 3 numbers");
        }
    }
    



    
    public void tradeInCar(String vin) {
        double tradeInValue;
        Car car = carMap.get(vin);
        int year = car.getYear();

        switch(year) {
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
                tradeInValue = car.getPrice() * 0.4;  // Default for older cars
                break;
        }

        
        inventory.add(car);
        
      
        System.out.println("Your Trade In Value is: $" + tradeInValue);
    }
    
    public Car findCarByVin(String vin) {
        return carMap.get(vin);
    }

}
