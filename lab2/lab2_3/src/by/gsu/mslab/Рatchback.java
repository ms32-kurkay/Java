package by.gsu.mslab;

public class Рatchback extends PassengerCar {
    private final String typeOfBody = "patchback";

    public Рatchback() {
        super();
    }

    public Рatchback(String carBrand, String carEngine, short powerOfEngine, double massCar, int carMileage, byte fuelСonsumption, double accelerationTime, String typeOfBody) {
        super(carBrand, carEngine, powerOfEngine, massCar, carMileage, fuelСonsumption, accelerationTime);
    }

    public Рatchback(String carBrand, String carEngine, byte fuelСonsumption, double accelerationTime, String typeOfBody) {
        super(carBrand, carEngine, fuelСonsumption, accelerationTime);
    }

    public String getTypeOfBody() {
        return typeOfBody;
    }

    @Override
    public String toString() {
        return super.toString() + typeOfBody + "; ";
    }
}
