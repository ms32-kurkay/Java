package by.gsu.mslab;

public class Subject {
    private String subject;
    private Material material;
    private double volume;

    public Subject(){}

    public Subject(String subject,Material material, double volume){
        this.subject = subject;
        this.material = material;
        this.volume = volume;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getMass(){
        return material.getDensity() * volume;
    }

    @Override
    public String toString() {
        return subject + "; " + material + "; " + volume + "; " + getMass();
    }
}
