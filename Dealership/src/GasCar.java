public class GasCar extends Car {
    private double fuelTankCapacity;

    public GasCar(String make, String model, int year, String color, double price, int mileage, double fuelTankCapacity) {
        super(make, model, year, color, price, mileage, "Gas");
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void printCarDetails() {
        super.printCarDetails();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " gallons");
    }
}