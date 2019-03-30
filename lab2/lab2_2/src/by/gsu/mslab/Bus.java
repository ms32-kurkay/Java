package by.gsu.mslab;

public class Bus implements WriteInfo,Car{
    private String carBrand;
    private String carEngine;
    private short powerOfEngine;
    private double massCar;
    private int carMileage;

    private short numberOfPackages;

    public Bus(){
        super();
    }

    public Bus(String carBrand, String carEngine, short powerOfEngine, double massCar, int carMileage, short numberOfPackages) {
        this.carBrand = carBrand;
        this.carEngine = carEngine;
        this.powerOfEngine = powerOfEngine;
        this.massCar = massCar;
        this.carMileage = carMileage;
        this.numberOfPackages = numberOfPackages;
    }

    public Bus(String carBrand, String carEngine, short numberOfPackages) {
        this.carBrand = carBrand;
        this.carEngine = carEngine;
        this.numberOfPackages = numberOfPackages;
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

    public short getNumberOfPackages() {
        return numberOfPackages;
    }

    public void setNumberOfPackages(short numberOfPackages) {
        this.numberOfPackages = numberOfPackages;
    }

    @Override
    public String writeInfo() {
        return "Bus: " + toString() + brand();
    }

    @Override
    public String toString() {
            return carBrand + "; " +
                    carEngine + "; " +
                    powerOfEngine + "; " +
                    massCar + "; " +
                    carMileage + "; " +
                    numberOfPackages + "; ";
            }

    @Override
    public String brand() {
        if (getCarBrand() == null){
            return "null";
        }
        if(getCarBrand().equals("MAZ") ||
                getCarBrand().equals("Neman")){
            return "this is a belarussian bus";
        }else{
            return"this isn't a belarussian bus";
        }
    }
}
