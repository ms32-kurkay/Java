package by.gsu.mslab;

public class Sedan extends PassengerCar {
    private final String typeOfBody = "sedan";

    public Sedan() {
        super();
    }

    public Sedan(String carBrand, String carEngine, short powerOfEngine, double massCar, int carMileage, byte fuelСonsumption, double accelerationTime, String typeOfBody) {
        super(carBrand, carEngine, powerOfEngine, massCar, carMileage, fuelСonsumption, accelerationTime);
    }

    public Sedan(String carBrand, String carEngine, byte fuelСonsumption, double accelerationTime, String typeOfBody) {
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
