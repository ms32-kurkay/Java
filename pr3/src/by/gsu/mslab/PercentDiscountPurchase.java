package by.gsu.mslab;

import java.math.BigDecimal;
import java.util.Scanner;

public class PercentDiscountPurchase extends GeneralPurchase{
    private BigDecimal percent;
    private final int NECESSARY_NUMBER = 15;

    public PercentDiscountPurchase(){
        super();
    }

    public PercentDiscountPurchase(String commodityName, BigDecimal priceOfUnit, int numberOfPurchasedUnits, BigDecimal percent) {
        super(commodityName, priceOfUnit, numberOfPurchasedUnits);
        this.percent = percent;
    }

    public PercentDiscountPurchase(Scanner sc){
        super(sc.next(), sc.nextBigDecimal(), sc.nextInt());
        this.percent = sc.nextBigDecimal();
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public int getNECESSARY_NUMBER() {
        return NECESSARY_NUMBER;
    }

    @Override
    public BigDecimal getCost() {
        BigDecimal total = new BigDecimal("0");
        BigDecimal totalDiscount = new BigDecimal("0");
        totalDiscount = (new BigDecimal("1").subtract(percent.divide(new BigDecimal("100"))));

        total = super.getCost().multiply(totalDiscount).setScale(0,BigDecimal.ROUND_CEILING);
        return total;
    }

    @Override
    public String toString() {
        return super.toString() + "; "+ percent.setScale(2,BigDecimal.ROUND_CEILING);
    }
}
