public class Currency
{
    private String charCode;
    private float rate;
    private int scale;
    private int id;
    private int numCode;
    private String name;

    public Currency() {
    }

    public Currency(String charCode, float rate, int scale, int numCode, String name, int id) {
        this.charCode = charCode;
        this.rate = rate;
        this.scale = scale;
        this.numCode = numCode;
        this.name = name;
        this.id = id;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumCode() {
        return numCode;
    }

    public void setNumCode(int numCode) {
        this.numCode = numCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "CharCode = "+ charCode +", Rate = "+ rate +", Scale = "+ scale +", Id = "+ id +", NumCode = "+ numCode +", Name = "+ name;
    }
}