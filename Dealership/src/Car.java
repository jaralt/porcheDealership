public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private double price;
    private int mileage;
    private String engineType;
    private String vin;

    public Car(String make, String model, int year, String color, double price, int mileage, String engineType, String vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.mileage = mileage;
        this.engineType = engineType;
        this.vin = vin;
    }

   
    
    
    public void printCarDetails() {
    	System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year +
                ", Color: " + color + ", Price: $" + price + ", Mileage: " + mileage +
                ", Engine Type: " + engineType + ", VIN: " + vin);
    	
    }

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

    public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

}