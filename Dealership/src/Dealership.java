import java.util.*;

public class Dealership {
    private List<Car> inventory;

    public Dealership() {
        this.inventory = new ArrayList<>();
    }

    public void addCar(Car car) {
        inventory.add(car);
    }

    public void displayInventory() {
        for (Car car : inventory) {
            car.printCarDetails();
            System.out.println();
        }
    }
}
