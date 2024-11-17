import java.util.Scanner;



public class DealershipApp {

    public static void main(String[] args) {
        
        Dealership dealership = new Dealership();
        Scanner scanner = new Scanner(System.in);

        // Electric Porsche cars
        dealership.addCar(new ElectricCar("Porsche", "Taycan", 2023, "Black", 85000, 0, 93.4, "272"));
        dealership.addCar(new ElectricCar("Porsche", "Taycan Turbo", 2023, "Silver", 95000, 0, 93.4, "226"));
        dealership.addCar(new ElectricCar("Porsche", "Taycan 4S", 2022, "Blue", 89000, 1000, 79.2, "295"));

        // Gas Porsche cars
        dealership.addCar(new GasCar("Porsche", "911 GT3", 2023, "Yellow", 161000, 2000, 16.9, "189"));
        dealership.addCar(new GasCar("Porsche", "Cayenne", 2021, "Gray", 67000, 12000, 23.7, "112"));
        dealership.addCar(new GasCar("Porsche", "Panamera", 2022, "Black", 87000, 8000, 23.7, "135"));
        dealership.addCar(new GasCar("Porsche", "911 Carrera", 2022, "Red", 99000, 5000, 16.9, "183"));

        // Hybrid Porsche cars
        dealership.addCar(new HybridCar("Porsche", "Cayenne E-Hybrid", 2023, "Green", 83000, 2500, 17.9, 23.6, "377"));
        dealership.addCar(new HybridCar("Porsche", "Panamera 4 E-Hybrid", 2022, "White", 97000, 3500, 17.9, 18.9, "392"));
        dealership.addCar(new HybridCar("Porsche", "Macan", 2023, "White", 75000, 4500, 18.8, 19.9, "324"));
        
        boolean running = true;
        
        while (running) {
            System.out.println("Welcome to the Porsche Dealership. Choose an option:");
            System.out.println("1. View Inventory");
            System.out.println("2. Find a Specific Car By VIN");
            System.out.println("3. Buy Car");
            System.out.println("4. Trade-In Car");
            System.out.println("5. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            String vin;
            switch (choice) {
                case 1:
                    dealership.displayInventory();
                    break;
                   
                case 2:
                	System.out.println("Please Enter the VIN of the car you would like to view");
                	 vin = scanner.nextLine();
                	 dealership.findCarByVin(vin);
                	 break;
      
                case 3:
                	System.out.println("Please enter the vin of the car you would like to buy");
                	vin = scanner.nextLine();
                    dealership.buyCar(vin);
                    break;
                case 4:
                	 System.out.println("Please Enter the VIN of the car you are trading in:");
                	    vin = scanner.nextLine();
                	    
                	   dealership.tradeInCar(vin);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Select 1-5.");
            }
        }

        scanner.close();
        System.out.println("Thank you for visiting the Porsche Dealership!");
    }
}