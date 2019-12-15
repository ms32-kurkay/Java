public class MeterFactory {
    public static Meter createMeter(String type){
        switch (type){

            case "electricity":
            case "электричество":
                return new Electricity();
            case "hot_water":
            case "горячая вода":
                return new HotWater();
            case "холодная вода":
            case "cold_water": return new ColdWater();
               default:
                    return null;
        }
    }
}
