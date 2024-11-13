

public class HybridCar extends Car {
    private double batteryCapacity;
    private double fuelTankCapacity;

    public HybridCar(String make, String model, int year, String color, double price, int mileage, double batteryCapacity, double fuelTankCapacity,String vin) {
        super(make, model, year, color, price, mileage, "Hybrid", vin);
        this.batteryCapacity = batteryCapacity;
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void printCarDetails() {
        super.printCarDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh, Fuel Tank Capacity: " + fuelTankCapacity + " gallons");
    }
}