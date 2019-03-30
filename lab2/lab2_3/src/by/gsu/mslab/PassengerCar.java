package by.gsu.mslab;

import javax.print.DocFlavor;

public abstract class PassengerCar implements WriteInfo,Car {
    private String carBrand;
    private String carEngine;
    private short powerOfEngine;
    private double massCar;
    private int carMileage;

    private byte fuelСonsumption;
    private double accelerationTime;

    public PassengerCar(){
        super();
    }

    public PassengerCar(String carBrand, String carEngine, short powerOfEngine, double massCar, int carMileage, byte fuelСonsumption, double accelerationTime) {
        this.carBrand = carBrand;
        this.carEngine = carEngine;
        this.powerOfEngine = powerOfEngine;
        this.massCar = massCar;
        this.carMileage = carMileage;
        this.fuelСonsumption = fuelСonsumption;
        this.accelerationTime = accelerationTime;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        if(carEngine == "diesel" || carEngine == "carburetor"){
            this.carEngine = carEngine;
        }else{
            System.out.println("Only diesel or carburetor!");
        }
    }

    public PassengerCar(String carBrand, String carEngine, byte fuelСonsumption, double accelerationTime) {
        this.carBrand = carBrand;
        this.carEngine = carEngine;
        this.fuelСonsumption = fuelСonsumption;
        this.accelerationTime = accelerationTime;
    }

    public short getPowerOfEngine() {
        return powerOfEngine;
    }

    public void setPowerOfEngine(short powerOfEngine) {
        this.powerOfEngine = powerOfEngine;
    }

    public double getMassCar() {
        return massCar;
    }

    public void setMassCar(double massCar) {
        this.massCar = massCar;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(int carMileage) {
        this.carMileage = carMileage;
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
    public String writeInfo() {
        return "Passenger car:" + toString() + brand();
    }

    @Override
    public String toString() {
        return carBrand + "; " +
                carEngine + "; " +
                powerOfEngine + "; " +
                massCar + "; " +
                carMileage +
                fuelСonsumption + "; " +
                accelerationTime + "; ";

    }

    @Override
    public String brand() {
        if (getCarBrand() == null){
            return "null";
        }
        if(getCarBrand().equals("BelGee")){
            return "this a is belarussian passenger car";
        }else{
            return "this a isn't belarussian passenger car";
        }
    }
}
