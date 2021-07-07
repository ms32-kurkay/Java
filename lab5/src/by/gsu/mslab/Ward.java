package by.gsu.mslab;

import java.io.Serializable;

public class Ward implements Serializable {
    private int countOfPlaces;
    private String surnameDoctor;
    private int countOfFreePlaces;

    public Ward() {
    }

    public Ward(int countOfPlaces, String surnameDoctor, int countOfFreePlaces){
        this.countOfPlaces = countOfFreePlaces;
        this.surnameDoctor = surnameDoctor;
        this.countOfFreePlaces = countOfFreePlaces;
    }

    public int getCountOfPlaces() {
        return countOfPlaces;
    }

    public void setCountOfPlaces(int countOfPlaces) {
        this.countOfPlaces = countOfPlaces;
    }

    public String getSurnameDoctor() {
        return surnameDoctor;
    }

    public void setSurnameDoctor(String surnameDoctor) {
        this.surnameDoctor = surnameDoctor;
    }

    public int getCountOfFreePlaces() {
        return countOfFreePlaces;
    }

    public void setCountOfFreePlaces(int countOfFreePlaces) {
        this.countOfFreePlaces = countOfFreePlaces;
    }

    public int getTotalPlaces(){
        return (countOfPlaces + countOfFreePlaces);
    }

    @Override
    public String toString() {
        return  surnameDoctor + "; " +
                "сount of places = " + countOfPlaces + "; " +
                "сount of free places = " + countOfFreePlaces + ";";
    }
}
