package by.gsu.mslab;

import java.math.BigDecimal;
import java.util.Scanner;

public class PriceDiscountPurchase extends GeneralPurchase {
    private int discount;

    public PriceDiscountPurchase() {
        super();
    }

    public PriceDiscountPurchase(String commodityName, int priceOfUnit, int numberOfPurchasedUnits, int discount) {
        super(commodityName, priceOfUnit, numberOfPurchasedUnits);
        this.discount = discount;
    }

    public PriceDiscountPurchase(Scanner sc){
        super(sc.next(), sc.nextInt(), sc.nextInt());
        this.discount = sc.nextInt();
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public int getCost() {
        return (getPriceOfUnit() - discount) * getNumberOfPurchasedUnits();
    }

    @Override
    public String toString() {
        return super.toString() + ";" + NewCurrency.Currency(discount);
    }
}
