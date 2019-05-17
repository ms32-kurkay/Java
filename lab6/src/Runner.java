import by.gsu.mslab.House;

import java.io.*;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<House> houses = new ArrayList<>();
        ArrayList<House> housesWithRooms = new ArrayList<>();
        ArrayList<House> housesWithRoomsAndSquare = new ArrayList<>();
        ArrayList<House> housesWithMinSquare = new ArrayList<>();
        final int HOUSES_COUNT = 5;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("info.dat"))) {

            for(int i = 0; i < HOUSES_COUNT; i++){
                oos.writeObject(new House(1, 140, 58.7, 4, 3, "Olimpiyskaya", "panel house", 80));
                oos.writeObject(new House(2, 96, 45.8, 7, 2, "Sviridova", "brick house", 87));
                oos.writeObject(new House(3, 14, 25, 1, 1, "Ogorenko", "panel house", 74));
                oos.writeObject(new House(4, 80, 60.5, 6, 4, "Kozhara", "monolithic house", 112));
                oos.writeObject(new House(5, 20, 25, 1, 1, "Ogorenko", "panel house", 74));
            }

            System.out.println("File has been written to file");
            System.out.println("--------------------------");

        } catch (IOException e){
            System.err.println("I/O error");
            e.printStackTrace();
        } try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("info.dat"))) {

            for(int i = 0; i < HOUSES_COUNT; i++){
                houses.add(new House());
                houses.set(i,((House) ois.readObject()));
            }

            System.out.println("File has been read from file");
            System.out.println("--------------------------");

        } catch (IOException | ClassNotFoundException e){
            System.err.println("I/O error");
            e.printStackTrace();
        }

        Collections.sort(houses);

        try{
            System.out.println("1) Enter the required count of rooms: ");
            int countRooms;
            countRooms = sc.nextInt();
            for(House h: houses){
                if (h.getRoomCount() == countRooms)
                    housesWithRooms.add(h);
            }

            System.out.println("2) Enter the required count of rooms: ");
            countRooms = sc.nextInt();
            System.out.println("Enter the minimal number of floor: ");
            double floorStart = sc.nextDouble();
            System.out.println("Enter the maximum number of floor: ");
            double floorEnd = sc.nextDouble();

            for(House h: houses){
                if ((h.getRoomCount() == countRooms) && (h.getFloor() >= floorStart && h.getFloor() <= floorEnd))
                    housesWithRoomsAndSquare.add(h);
            }

            System.out.println("3) Enter the minimal number of area: ");
            double minArea = sc.nextDouble();

            for(House h: houses){
                if (h.getApartmentArea() >= minArea)
                    housesWithMinSquare.add(h);
            }

            sc.close();

        }catch (InputMismatchException e){
            System.err.println("Wrong type of info");
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("info.txt")){

            for(House h: houses){
                writer.write(h.toString().concat("\n"));
            }

            writer.write("\n");

            writer.write("List of houses with required count of rooms:\n");
            for(House h: housesWithRooms){
                writer.write(h.toString().concat("\n"));
            }

            writer.write("\n");

            writer.write("List of houses with required count of rooms and required interval of floors:\n");
            for(House h: housesWithRoomsAndSquare){
                writer.write(h.toString().concat("\n"));
            }

            writer.write("\n");

            writer.write("List of houses with minimal required area:\n");
            for(House h: housesWithMinSquare){
                writer.write(h.toString().concat("\n"));
            }

            System.out.println("--------------------------");
            System.out.println("File has been written to .txt file");
            System.out.println("--------------------------");


        }catch(IOException e){
            System.err.println("I/O error");
            e.printStackTrace();
        }



    }
}
