public class MeterFactory {
    public static Meter createMeter(String type){
        switch (type){
            case "electricity": return new Electricity();
               default:
                    return null;
        }
    }
}
