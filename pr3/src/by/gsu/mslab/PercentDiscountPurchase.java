package by.gsu.mslab;

import java.math.BigDecimal;
import java.util.Scanner;

public class PercentDiscountPurchase extends GeneralPurchase{
    private double percent;
    private final int NECESSARY_NUMBER = 15;

    public PercentDiscountPurchase(){
        super();
    }

    public PercentDiscountPurchase(String commodityName, int priceOfUnit, int numberOfPurchasedUnits, double percent) {
        super(commodityName, priceOfUnit, numberOfPurchasedUnits);
        this.percent = percent;
    }

    public PercentDiscountPurchase(Scanner sc){
        super(sc.next(), sc.nextInt(), sc.nextInt());
        this.percent = sc.nextDouble();
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public int getNECESSARY_NUMBER() {
        return NECESSARY_NUMBER;
    }

    @Override
    public int getCost() {
        if(getNumberOfPurchasedUnits() >= NECESSARY_NUMBER ){
            return (int) (super.getCost()*(1 - percent/100));
        }else{
            return super.getCost();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ";"+ percent;
    }
}
