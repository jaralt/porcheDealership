import java.util.*;

public class DealershipApp {

    public static void main(String[] args) {
        Dealership dealership = new Dealership();
        Scanner scanner = new Scanner(System.in);

        // Pre-load some cars (optional)
        dealership.addCar(new ElectricCar("Porsche", "Taycan", 2023, "Black", 85000, 0, 93.4));
        dealership.addCar(new GasCar("Porsche", "911 Carrera", 2022, "Red", 99000, 5000, 16.9));
        
        boolean running = true;
        
        while (running) {
            System.out.println("Welcome to the Porsche Dealership. Choose an option:");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Car");
            System.out.println("3. Buy Car");
            System.out.println("4. Trade-In Car");
            System.out.println("5. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    dealership.displayInventory();
                    break;
                case 2:
                    // Code to add a car 
                    break;
                case 3:
                    // Code to buy a car 
                    break;
                case 4:
                    // Code to trade-in a car
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }

        scanner.close();
        System.out.println("Thank you for visiting the Porsche Dealership!");
    }
}
