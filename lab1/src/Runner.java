import java.sql.Array;
import java.util.*;

public class Runner {
        public static void main(String[] args) {
            Ward[] wards = new Ward[10];
            wards[0] = new Ward(10,"Chizhov",1);
            wards[1] = new Ward(12,"Ivanov",0);
            wards[2] = new Ward(20,"Milonov",15);
            wards[3] = new Ward(7,"Davidov",0);
            wards[4] = new Ward(7,"Ivanov",5);
            wards[5] = new Ward(25,"Korotkevich",3);
            wards[6] = new Ward(13,"Baranov",10);
            wards[7] = new Ward(21,"Koteyko",16);
            wards[8] = new Ward(17,"Vetkin",7);
            wards[9] = new Ward(18,"Utkin",4);

            System.out.println("\tInital array:");
            for (Ward ward: wards) {
                System.out.println(ward.toString());
            }

            System.out.println("------------------------------------");

            System.out.println("\tArray sorted by count of places:");
            Arrays.sort(wards, new Comparator<Ward>() {
                @Override
                public int compare(Ward w1, Ward w2) {
                    return w1.getCountOfPlaces()-w2.getCountOfPlaces();
                }
            });

            for (Ward ward: wards) {
                System.out.println(ward.toString());
            }

            System.out.println("------------------------------------");

            System.out.println("\tArray sorted by count of free places:");
            Arrays.sort(wards, new Comparator<Ward>() {
                @Override
                public int compare(Ward w1, Ward w2) {
                    return w1.getCountOfFreePlaces()-w2.getCountOfFreePlaces();
                }
            });

            for (Ward ward: wards) {
                System.out.println(ward.toString());
            }

            System.out.println("------------------------------------");

            int sumPlaces = 0;
            for (Ward ward: wards) {
                sumPlaces += ward.getTotalPlaces();
            }
            System.out.println("Sum of places = " + sumPlaces);

            int sumFreeWards = 0;
            for (Ward ward: wards) {
                if(ward.getCountOfFreePlaces()!=0){
                    sumFreeWards+=1;
                }
            }
            System.out.println("Sum of free wards = " + sumFreeWards);







        }
}
