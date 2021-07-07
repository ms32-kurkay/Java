import by.gsu.exceptions.LogicalNumberException;
import by.gsu.mslab.Ward;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Ward[] wards = new Ward[2];
        Scanner sc = new Scanner(System.in);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("wards.dat"))) {
            for (int i = 0; i < 2; i++) {
                Ward ward = new Ward();
                try {
                    System.out.println("Write info about new ward: ");
                    System.out.println("---------------------");
                    System.out.println("Count of places: ");
                    ward.setCountOfPlaces(sc.nextInt());
                    System.out.println("Surname of doctor: ");
                    ward.setSurnameDoctor(sc.next());
                    System.out.println("Count free of places: ");
                    ward.setCountOfFreePlaces(sc.nextInt());
                    oos.writeObject(ward);
                }catch (InputMismatchException e){
                    System.err.println("Wrong type of info ward's info");
                    e.printStackTrace();
                }
                try {
                    if ((ward.getCountOfPlaces() < 0 || ward.getCountOfFreePlaces() < 0)||(ward.getCountOfFreePlaces() > ward.getCountOfPlaces())) {
                        throw new LogicalNumberException();
                    }
                }catch(LogicalNumberException e){
                        System.err.println("Check your info, because: not free places > free places and count of places is not negative number ");
                        e.printStackTrace();
                    }
                    System.out.println("---------------------");
            }
        }catch (IOException e){
            System.err.println("I/O error output");
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("wards.dat"))) {
            for (int i = 0; i < 2; i++){
                wards[i] = (Ward) ois.readObject();
            }
        }catch (IOException | ClassNotFoundException e){
            System.err.println("I/O error input");
            e.printStackTrace();
        }

        System.out.println("Initial array:");
        System.out.println("---------------------");
        for (Ward ward : wards) {
            System.out.println(ward.toString());
        }

        int sumPlaces = 0;
        for (Ward ward : wards) {
            sumPlaces += ward.getTotalPlaces();
        }

        System.out.println("---------------------");

        System.out.println("Sum of places = " + sumPlaces);

        int sumFreeWards = 0;
        for (Ward ward : wards) {
                if (ward.getCountOfFreePlaces() != 0) {
                    sumFreeWards += 1;
                }
            }

        System.out.println("Sum of free wards = " + sumFreeWards);

        }
}
