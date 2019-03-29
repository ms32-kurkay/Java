package by.gsu.mslab;

public class Material {
    private String material;
    private double density;

    public Material(){}

    public Material(String material, double density){
        this.material = material;
        this.density = density;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return material + "; " + density;
    }
}
