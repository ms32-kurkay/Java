import by.gsu.mslab.*;
public class Runner {
    public static void main(String[] args) {
        Рatchback patchback = new Рatchback("Renault", "diesel", (byte) 6, 7.8,"patchback");
        Sedan sedan = new Sedan("Renault", "carburetor", (byte) 8, 6.5,"sedan");
        Bus bus = new Bus("Neman","diesel",(short) 120);
        Truck truck = new Truck();

        System.out.println(sedan.writeInfo());
        System.out.println("----------------");
        System.out.println(patchback.writeInfo());
        System.out.println("----------------");
        System.out.println(bus.writeInfo());
        System.out.println("----------------");
        System.out.println(truck.writeInfo());


    }
}
