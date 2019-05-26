import by.gsu.mslab.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = null;
        ArrayList<Purchase> purchases = new ArrayList<>();
        try{
         sc = new Scanner(new FileReader("src/in.txt"));
         while(sc.hasNext()){
             String line = sc.nextLine();
             purchases.add(PurchaseFactory.getClassFromFactory(line));
         }

            System.out.println("Initial purchases:");
            System.out.println("--------------");
            for(Purchase p: purchases){
                System.out.println(p.toString());
            }

            System.out.println("--------------");
            System.out.println("Purchase with the index 6:");
            System.out.println("--------------");
            System.out.println(purchases.get(5).toString());

            Iterator<Purchase> iterator = purchases.iterator();
            while (iterator.hasNext()){
                if(iterator.next().getPriceOfUnit() < 10000){
                    iterator.remove();
                }
            }

            Collections.sort(purchases);

            System.out.println("--------------");
            System.out.println("New list of purchases:");
            System.out.println("--------------");

            for(Purchase p: purchases){
                System.out.println(p.toString());
            }

            Purchase purchase = new PricePurchase(null,35000,0,0);
            int index = Collections.binarySearch(purchases,purchase);

            System.out.println("--------------");
            if (index < 0)
                System.out.println("This list of purchases does'nt have such purchase");
            else System.out.println("Purchase with index " + index);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally{
            if(sc != null)
                sc.close();
        }
    }
}
