
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
        
        
        //implement vin with hashset
    }
    
    public void buyCar(Car car) {
        if (inventory.contains(car)) {
            inventory.remove(car); 
            System.out.println("Car sold for $" + car.getPrice());
        } else {
            System.out.println("This car is not available in the inventory.");
        }
    }

    
    public void tradeInCar(Car car) {
        double tradeInValue;
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

}
