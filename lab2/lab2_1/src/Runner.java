import by.gsu.mslab.*;

public class Runner {
    public static void main(String[] args) {
        Car[] cars = new Car[5];
        cars[0] = new Car("Mercedes","diesel",(short) 150,2.2,51756);
        cars[1] = new PassengerCar("BMW","carburetor",(short) 130, 2.5,75232,(byte) 10, 2.3);
        cars[2] = new Truck("Volkswagen","diesel",(short) 40,"close");
        cars[3] = new Bus();
        cars[4] = null;

        System.out.println("Cars:");
        System.out.println("--------------------------------------------");
        for (Car car: cars) {
            if(car != null)
                System.out.println(car.writeInfo());
        }
    }
}
