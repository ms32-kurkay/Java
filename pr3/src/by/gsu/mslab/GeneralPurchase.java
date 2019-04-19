package by.gsu.mslab;

import java.math.BigDecimal;
import java.util.Scanner;

public class GeneralPurchase{
    private String commodityName;
    private int priceOfUnit;
    private int numberOfPurchasedUnits;

    public GeneralPurchase(){
        super();
    }

    public GeneralPurchase(String commodityName, int priceOfUnit, int numberOfPurchasedUnits) {
        this.commodityName = commodityName;
        this.priceOfUnit = priceOfUnit;
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public GeneralPurchase(Scanner sc){
        this(sc.next(), sc.nextInt(), sc.nextInt());
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public int getPriceOfUnit() {
        return priceOfUnit;
    }

    public void setPriceOfUnit(int priceOfUnit) {
        this.priceOfUnit = priceOfUnit;
    }

    public int getNumberOfPurchasedUnits() {
        return numberOfPurchasedUnits;
    }

    public void setNumberOfPurchasedUnits(int numberOfPurchasedUnits) {
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public int getCost(){
        return priceOfUnit * numberOfPurchasedUnits;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if ((obj == null)||(obj.getClass() != this.getClass()))
            return false;

        GeneralPurchase otherPurchase = (GeneralPurchase) obj;
        return ((commodityName == otherPurchase.commodityName)||
                (commodityName != null)&&(commodityName.equals(otherPurchase.commodityName))&&
                        (priceOfUnit == otherPurchase.priceOfUnit));
    }

    @Override
    public String toString() {
        return commodityName + ";" +
                NewCurrency.Currency(priceOfUnit) + ";" +
                numberOfPurchasedUnits + ";" +
                NewCurrency.Currency(getCost());
    }

}
