package by.gsu.mslab;

import java.util.Scanner;

public class PurchaseFactory {
    private enum PurchasesKinds {
        GENERAL_PURCHASE, PRICE_DISCOUNT_PURCHASE, PERCENT_DISCOUNT_PURCHASE
    }
    public GeneralPurchase getClassFromFactory(Scanner sc) {
        String id = sc.next();
        PurchasesKinds kind = PurchasesKinds.valueOf(id);
        switch(kind) {
            case GENERAL_PURCHASE :
                return new GeneralPurchase(sc);
			case PRICE_DISCOUNT_PURCHASE :
                return new PriceDiscountPurchase(sc);
            case PERCENT_DISCOUNT_PURCHASE:
                return new PercentDiscountPurchase(sc);
            default:
                 throw new IllegalArgumentException("Error!");
        }
    }
}
