import java.util.Scanner;



public class DealershipApp {

    public static void main(String[] args) {
        
        Dealership dealership = new Dealership();
        Scanner scanner = new Scanner(System.in);

        
        dealership.addCar(new ElectricCar("Porsche", "Taycan", 2023, "Black", 85000, 0, 93.4, "272"));
        dealership.addCar(new GasCar("Porsche", "911 Carrera", 2022, "Red", 99000, 5000, 16.9, "183"));
        dealership.addCar(new HybridCar("Porsche", "Macan", 2023, "White", 75000, 4500, 18.8, 19.9, "324"));
        dealership.addCar(new ElectricCar("Porsche", "Taycan Turbo", 2023, "Silver", 95000, 0, 93.4, "226"));
        dealership.addCar(new ElectricCar("Porsche", "Taycan 4S", 2022, "Blue", 89000, 1000, 79.2, "295"));

        // Gas Porsche cars
        dealership.addCar(new GasCar("Porsche", "911 GT3", 2023, "Yellow", 161000, 2000, 16.9, "189"));
        dealership.addCar(new GasCar("Porsche", "Cayenne", 2021, "Gray", 67000, 12000, 23.7, "112"));
        dealership.addCar(new GasCar("Porsche", "Panamera", 2022, "Black", 87000, 8000, 23.7, "135"));

        // Hybrid Porsche cars
        dealership.addCar(new HybridCar("Porsche", "Cayenne E-Hybrid", 2023, "Green", 83000, 2500, 17.9, 23.6, "377"));
        dealership.addCar(new HybridCar("Porsche", "Panamera 4 E-Hybrid", 2022, "White", 97000, 3500, 17.9, 18.9, "392"));
        
        boolean running = true;
        
        while (running) {
            System.out.println("Welcome to the Porsche Dealership. Choose an option:");
            System.out.println("1. View Inventory");
            System.out.println("2. Buy Car");
            System.out.println("3. Trade-In Car");
            System.out.println("4. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    dealership.displayInventory();
                    break;
                case 2:
                    dealership.buyCar(null);
                    break;
                case 3:
                    // Code to trade-in a car
                    break;
                case 4:
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