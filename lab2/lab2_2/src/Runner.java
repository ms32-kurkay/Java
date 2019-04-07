import by.gsu.mslab.*;

public class Runner {
    public static void main(String[] args) {
        PassengerCar passengerCar = new PassengerCar("Fiat","carburetor", (short) 120,1.8, 127893,(byte)7,5.2);
        Bus bus = new Bus("Neman","diesel",(short) 120);
        Truck truck = new Truck();

        System.out.println(passengerCar.writeInfo());
        System.out.println("----------------");
        System.out.println(bus.writeInfo());
        System.out.println("----------------");
        System.out.println(truck.writeInfo());
    }
}
