
public class Ward {
    private int countOfPlaces;
    private String surnameDoctor;
    private int countOfFreePlaces;

    Ward(int countOfPlaces,String surnameDoctor,int countOfFreePlaces){
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
        return (getCountOfPlaces() + getCountOfPlaces());
    }


    @Override
    public String toString() {
        return  surnameDoctor + "; " +
                "сount of places = " + countOfPlaces + "; " +
                "сount of free places = " + countOfFreePlaces + ";";
    }

}


