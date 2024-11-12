public class ElectricCar extends Car {
    private double batteryCapacity; 

    public ElectricCar(String make, String model, int year, String color, double price, int mileage, double batteryCapacity) {
        super(make, model, year, color, price, mileage, "Electric");
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void printCarDetails() {
        super.printCarDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}
