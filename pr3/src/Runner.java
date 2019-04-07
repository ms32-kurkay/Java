import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PipedInputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import by.gsu.mslab.*;

public class Runner {
    public static void main(String[] args){
        PurchaseFactory pf = new PurchaseFactory();
        Scanner sc =null;
        try{
            sc = new Scanner(new FileReader("src/in.txt"));
            GeneralPurchase[] purchases = new GeneralPurchase[5];
            BigDecimal maxCost = new BigDecimal("0");
            boolean flag = true;
            for(int i = 0; i < purchases.length; i++){
                purchases[i] = pf.getClassFromFactory(sc);
                if(purchases[i].getCost().compareTo(maxCost) > 0){
                    maxCost = purchases[i].getCost();
                }
                if(flag){
                    flag = purchases[i].equals(purchases[0]);
                }
            }
            for(GeneralPurchase p: purchases){
                System.out.println(p.toString() + "; " + p.getCost());
            }

            if(flag)
                System.out.println("Equals");
            else
                System.out.println("Not equals");

            System.out.println("Max cost: " + maxCost.setScale(2,BigDecimal.ROUND_CEILING));

        }catch (FileNotFoundException e){
            System.err.println("File not founded");
        }finally{
            if(sc != null)
                sc.close();
        }
    }
}
