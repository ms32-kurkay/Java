import by.gsu.mslab.Ward;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Ward[] wards = new Ward[2];
        Scanner sc = new Scanner(System.in);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("wards.dat"))){
            for(int i = 0; i < 2; i++){
                System.out.println("Write info about new ward: ");
                System.out.println("---------------------");
                Ward ward = new Ward();
                System.out.println("Count of places: ");
                ward.setCountOfPlaces(sc.nextInt());
                System.out.println("Surname of doctor: ");
                ward.setSurnameDoctor(sc.next());
                System.out.println("Count free of places: ");
                ward.setCountOfFreePlaces(sc.nextInt());
                System.out.println("---------------------");
                oos.writeObject(ward);
                System.out.println("Info has been written");
                System.out.println("---------------------");

            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("wards.dat"))){
            for(int i = 0; i < 2; i++){
                wards[i] = (Ward) ois.readObject();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Initial array:");
        System.out.println("---------------------");

        for (Ward ward: wards) {
            System.out.println(ward.toString());
        }

        int sumPlaces = 0;
        for (Ward ward: wards) {
            sumPlaces += ward.getTotalPlaces();
        }
        System.out.println("---------------------");
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
