package by.gsu.mslab;

public class Purchase implements Comparable<Purchase>{
    private String commodityName;
    private int priceOfUnit;
    private int numberOfPurchasedUnits;

    public Purchase(){
    }

    public Purchase(String commodityName, int priceOfUnit, int numberOfPurchasedUnits) {
        this.commodityName = commodityName;
        this.priceOfUnit = priceOfUnit;
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
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

    @Override
    public String toString() {
        return commodityName + ";" +
                NewCurrency.Currency(priceOfUnit) + ";" +
                numberOfPurchasedUnits;
    }

    @Override
    public int compareTo(Purchase p) {
       if (this.priceOfUnit == p.getPriceOfUnit())
           return 0;
       else if(this.priceOfUnit < p.getPriceOfUnit())
           return -1;
       else return 1;
    }
}
