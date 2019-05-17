package by.gsu.mslab;

import java.io.Serializable;

public class House implements Serializable, Comparable {
    private int id;
    private int apartmentNumber;
    private double apartmentArea;
    private int floor;
    private int roomCount;
    private String street;
    private String typeOfHouse;
    private int explotationPeriod;

    public House() {
    }

    public House(int id, int apartmentNumber, double apartmentArea, int floor, int roomCount, String street, String typeOfHouse, int explotationPeriod) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.apartmentArea = apartmentArea;
        this.floor = floor;
        this.roomCount = roomCount;
        this.street = street;
        this.typeOfHouse = typeOfHouse;
        this.explotationPeriod = explotationPeriod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public double getApartmentArea() {
        return apartmentArea;
    }

    public void setApartmentArea(double apartmentArea) {
        this.apartmentArea = apartmentArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTypeOfHouse() {
        return typeOfHouse;
    }

    public void setTypeOfHouse(String typeOfHouse) {
        this.typeOfHouse = typeOfHouse;
    }

    public int getExplotationPeriod() {
        return explotationPeriod;
    }

    public void setExplotationPeriod(int explotationPeriod) {
        this.explotationPeriod = explotationPeriod;
    }

    @Override
    public String toString() {
        return  id + "; " +
                apartmentNumber + "; " +
                apartmentArea + "; " +
                floor + "; " +
                roomCount + "; " +
                street + "; " +
                typeOfHouse + "; " +
               explotationPeriod + "; ";
    }

    @Override
    public int compareTo(Object o) {
        House h = (House) o;
        return street.compareTo(h.getStreet());
    }
}
