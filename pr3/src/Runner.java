import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PipedInputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import by.gsu.mslab.*;

public class Runner {
    public static void main(String[] args){
        Scanner sc =null;
        try{
            PurchaseFactory pf = new PurchaseFactory();
            sc = new Scanner(new FileReader("src/in.txt"));
            GeneralPurchase[] purchases = new GeneralPurchase[5];
            int maxCost = 0;
            boolean flag = true;
            for(int i = 0; i < purchases.length; i++){
                purchases[i] = pf.getClassFromFactory(sc);
                if(purchases[i].getCost() > maxCost){
                    maxCost = purchases[i].getCost();
                }
                if(flag){
                    flag = purchases[i].equals(purchases[0]);
                }
            }
            for(GeneralPurchase p: purchases){
                System.out.println(p.toString() + ";");
            }

            if(flag)
                System.out.println("All purchases are equal");
            else
                System.out.println("All purchases are not equal");

            System.out.println("Max cost of purchase: " + NewCurrency.Currency(maxCost));

        }catch (FileNotFoundException e){
            System.err.println("File not founded");
        }finally{
            if(sc != null)
                sc.close();
        }
    }
}
