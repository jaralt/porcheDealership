
public class GasCar extends Car {
    final double fuelTankCapacity;

    public GasCar(String make, String model, int year, String color, double price, int mileage, double fuelTankCapacity, String vin) {
        super(make, model, year, color, price, mileage, "Gas", vin);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void printCarDetails() {
        super.printCarDetails();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " gallons");
    }
    
    
}