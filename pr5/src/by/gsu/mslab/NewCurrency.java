package by.gsu.mslab;

public class NewCurrency {
    public static String Currency(int currency){
        return currency / 100 + "." + currency / 10 % 10 + currency % 10;
    }

}
