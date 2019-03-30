package by.gsu.mslab;

public class PassengerCar extends Car {
    private byte fuelСonsumption;
    private double accelerationTime;

    public PassengerCar() {
        super();
    }

    public PassengerCar(String carBrand, String carEngine, short powerOfEngine, double massCar, int carMileage, byte fuelСonsumption, double accelerationTime) {
        super(carBrand, carEngine, powerOfEngine, massCar, carMileage);
        this.fuelСonsumption = fuelСonsumption;
        this.accelerationTime = accelerationTime;
    }

    public PassengerCar(String carBrand, String carEngine, byte fuelСonsumption, double accelerationTime) {
        super(carBrand, carEngine);
        this.fuelСonsumption = fuelСonsumption;
        this.accelerationTime = accelerationTime;
    }

    public byte getFuelСonsumption() {
        return fuelСonsumption;
    }

    public void setFuelСonsumption(byte fuelСonsumption) {
        this.fuelСonsumption = fuelСonsumption;
    }

    public double getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(double accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    @Override
    public void brand() {
        super.brand();
        if(getCarBrand().equals("BelGee")){
            System.out.println("This is belarussian passenger car");
        }else{
            System.out.println("This isn't belarussian passenger car");
        }
    }

    public String writeInfo(){
        return "Passenger car: " +
                toString();
    }

    @Override
    public String toString() {
        return super.toString() +
                fuelСonsumption + "; " +
                accelerationTime;
    }
}
