package by.gsu.mslab;

import java.math.BigDecimal;
import java.util.Scanner;

public class GeneralPurchase{
    private String commodityName;
    private BigDecimal priceOfUnit;
    private int numberOfPurchasedUnits;

    public GeneralPurchase(){
        super();
        this.priceOfUnit = new BigDecimal("0");
    }

    public GeneralPurchase(String commodityName, BigDecimal priceOfUnit, int numberOfPurchasedUnits) {
        this.commodityName = commodityName;
        this.priceOfUnit = priceOfUnit;
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public GeneralPurchase(Scanner sc){
        this(sc.next(), sc.nextBigDecimal(), sc.nextInt());
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public BigDecimal getPriceOfUnit() {
        return priceOfUnit;
    }

    public void setPriceOfUnit(BigDecimal priceOfUnit) {
        this.priceOfUnit = priceOfUnit;
    }

    public int getNumberOfPurchasedUnits() {
        return numberOfPurchasedUnits;
    }

    public void setNumberOfPurchasedUnits(int numberOfPurchasedUnits) {
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public BigDecimal getCost(){
        BigDecimal total = new BigDecimal("0");
        total = (priceOfUnit).multiply(new BigDecimal(numberOfPurchasedUnits));
        return total;
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
                        (priceOfUnit != null)&&(priceOfUnit.compareTo(otherPurchase.priceOfUnit) == 0));
    }

    @Override
    public String toString() {
        return commodityName + "; " +
                priceOfUnit.setScale(2,BigDecimal.ROUND_DOWN) + "; " +
                numberOfPurchasedUnits;
    }

}
