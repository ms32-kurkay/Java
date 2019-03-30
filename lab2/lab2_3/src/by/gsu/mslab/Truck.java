package by.gsu.mslab;

public class Truck implements WriteInfo,Car{
    private String carBrand;
    private String carEngine;
    private short powerOfEngine;
    private double massCar;
    private int carMileage;

    private short tonnage;
    private String typeOfBody;

    public Truck() {
        super();
    }

    public Truck(String carBrand, String carEngine, short powerOfEngine, double massCar, int carMileage, short tonnage, String typeOfBody) {
        this.carBrand = carBrand;
        this.carEngine = carEngine;
        this.powerOfEngine = powerOfEngine;
        this.massCar = massCar;
        this.carMileage = carMileage;
        this.tonnage = tonnage;
        this.typeOfBody = typeOfBody;
    }

    public Truck(String carBrand, String carEngine, short tonnage, String typeOfBody) {
        this.carBrand = carBrand;
        this.carEngine = carEngine;
        this.tonnage = tonnage;
        this.typeOfBody = typeOfBody;
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

    public short getTonnage() {
        return tonnage;
    }

    public void setTonnage(short tonnage) {
        this.tonnage = tonnage;
    }

    public String getTypeOfBody() {
        return typeOfBody;
    }

    public void setTypeOfBody(String typeOfBody) {
        if(typeOfBody == "open" || typeOfBody == "close")
            this.typeOfBody = typeOfBody;
        else
            System.out.println("Only close or open!");
    }

    @Override
    public String writeInfo() {
        return "Truck:" + toString() + brand();
    }

    @Override
    public String toString() {
        return carBrand + "; " +
                carEngine + "; " +
                powerOfEngine + "; " +
                massCar + "; " +
                carMileage +
                tonnage + "; " +
                typeOfBody + "; ";
    }

    @Override
    public String brand() {
        if (getCarBrand() == null){
            return "null";
        }
        if(getCarBrand().equals("MAZ") ||
                getCarBrand().equals("BelAZ") ||
                getCarBrand().equals("MoAZ") ||
                getCarBrand().equals("MZKT")){
            return "this is a belarussian truck";
        }else{
            return"this isn't a belarussian truck";
        }
    }
}
