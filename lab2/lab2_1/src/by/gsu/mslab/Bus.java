package by.gsu.mslab;

public class Bus extends Car{
    private short numberOfPackages;

    public Bus(){
        super();
    }

    public Bus(String carBrand, String carEngine, short powerOfEngine, double massCar, int carMileage, short numberOfPackages) {
        super(carBrand, carEngine, powerOfEngine, massCar, carMileage);
        this.numberOfPackages = numberOfPackages;
    }

    public Bus(String carBrand, String carEngine, short numberOfPackages) {
        super(carBrand, carEngine);
        this.numberOfPackages = numberOfPackages;
    }

    public short getNumberOfPackages() {
        return numberOfPackages;
    }

    public void setNumberOfPackages(short numberOfPackages) {
        this.numberOfPackages = numberOfPackages;
    }

    @Override
    public void brand() {
        super.brand();
        if(getCarBrand().equals("MAZ") ||
            getCarBrand().equals("Neman")){
            System.out.println("This is belarussian bus");
        }else{
            System.out.println("This isn't belarussian bus");
        }
    }

    public String writeInfo(){
        return "Bus: " +
                toString();
    }

    @Override
    public String toString() {
        return super.toString() + "; " + numberOfPackages;
    }
}
