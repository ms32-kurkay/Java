package by.gsu.mslab;

public class PurchaseFactory {
    public static Purchase getClassFromFactory(String line) {
        int count = 0;
        for (char element : line.toCharArray()) {
            if (element == ';')
                count++;
        }
        String[] properties = line.split(";");
        if (count == 3) {
            return new PricePurchase(properties[0], Integer.parseInt(properties[1]), Integer.parseInt(properties[2]),Integer.parseInt(properties[3]));
        } else
            return new Purchase(properties[0], Integer.parseInt(properties[1]), Integer.parseInt(properties[2]));

    }
}

