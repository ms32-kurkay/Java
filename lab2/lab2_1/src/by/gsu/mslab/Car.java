package by.gsu.mslab;

public class Car {
    private String carBrand;
    private String carEngine;
    private short powerOfEngine;
    private double massCar;
    private int carMileage;

    public Car() {
        super();
    }

    public Car(String carBrand, String carEngine, short powerOfEngine, double massCar, int carMileage) {
        this.carBrand = carBrand;
        this.carEngine = carEngine;
        this.powerOfEngine = powerOfEngine;
        this.massCar = massCar;
        this.carMileage = carMileage;
    }

    public Car(String carBrand, String carEngine) {
        this.carBrand = carBrand;
        this.carEngine = carEngine;
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

    public void brand(){
        if (carBrand.equals("MAZ") ||
                carBrand.equals("BelAZ") ||
                carBrand.equals("BelGee") ||
                carBrand.equals("MoAZ") ||
                carBrand.equals("MZKT") ||
                carBrand.equals("Neman")){
            System.out.println("This is belarussian brand");
        }else{
            System.out.println("This isn't belarussian brand");
        }
    }


    public String writeInfo(){
        return "Car: " +
                toString();
    }

    @Override
    public String toString() {
                return carBrand + "; " +
                        carEngine + "; " +
                        powerOfEngine + "; " +
                        massCar + "; " +
                        carMileage;
    }
}
