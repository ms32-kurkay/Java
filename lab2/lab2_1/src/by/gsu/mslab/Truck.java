package by.gsu.mslab;

public class Truck extends Car {
    private short tonnage;
    private String typeOfBody;

    public Truck() {
        super();
    }

    public Truck(String carBrand, String carEngine, short powerOfEngine, double massCar, int carMileage, short tonnage, String typeOfBody) {
        super(carBrand, carEngine, powerOfEngine, massCar, carMileage);
        this.tonnage = tonnage;
        this.typeOfBody = typeOfBody;
    }

    public Truck(String carBrand, String carEngine, short tonnage, String typeOfBody) {
        super(carBrand, carEngine);
        this.tonnage = tonnage;
        this.typeOfBody = typeOfBody;
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
    public void brand() {
        super.brand();
        if(getCarBrand().equals("MAZ") ||
            getCarBrand().equals("BelAZ") ||
            getCarBrand().equals("MoAZ") ||
            getCarBrand().equals("MZKT")){
            System.out.println("This is belarussian truck");
        }else{
            System.out.println("This isn't belarussian truck");
        }
    }

    public String writeInfo(){
        return "Truck: " +
                toString();
    }

    @Override
    public String toString() {
        return super.toString() +
                tonnage + "; " +
                typeOfBody;
    }
}
