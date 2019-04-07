package by.gsu.mslab;

import java.math.BigDecimal;
import java.util.Scanner;

public class PriceDiscountPurchase extends GeneralPurchase {
    private BigDecimal discount;

    public PriceDiscountPurchase() {
        super();
    }

    public PriceDiscountPurchase(String commodityName, BigDecimal priceOfUnit, int numberOfPurchasedUnits, BigDecimal discount) {
        super(commodityName, priceOfUnit, numberOfPurchasedUnits);
        this.discount = discount;
    }

    public PriceDiscountPurchase(Scanner sc){
        super(sc.next(), sc.nextBigDecimal(), sc.nextInt());
        this.discount = sc.nextBigDecimal();
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public BigDecimal getCost() {
        BigDecimal total = super.getCost();
        total = (total.subtract((new BigDecimal(getNumberOfPurchasedUnits())).multiply(discount)));
        return total;
    }

    @Override
    public String toString() {
        return super.toString() + "; " + discount.setScale(2,BigDecimal.ROUND_CEILING);
    }
}
