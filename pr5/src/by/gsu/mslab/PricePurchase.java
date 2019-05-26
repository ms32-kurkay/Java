package by.gsu.mslab;

public class PricePurchase extends Purchase {
    private int discount;

    public PricePurchase() {

    }

    public PricePurchase(String commodityName, int priceOfUnit, int numberOfPurchasedUnits, int discount) {
        super(commodityName, priceOfUnit, numberOfPurchasedUnits);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + NewCurrency.Currency(discount);
    }
}
