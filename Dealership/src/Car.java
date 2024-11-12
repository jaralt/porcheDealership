public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private double price;
    private int mileage;
    private String engineType;

    public Car(String make, String model, int year, String color, double price, int mileage, String engineType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.mileage = mileage;
        this.engineType = engineType;
    }

    public void printCarDetails() {
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year +
                           ", Color: " + color + ", Price: $" + price + ", Mileage: " + mileage +
                           ", Engine Type: " + engineType);
    }

    //implement getters and setters

}
