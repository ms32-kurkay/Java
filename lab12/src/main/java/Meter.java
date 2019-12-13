public interface Meter{
    int getId();
    void setId(int id);
    String getType();
    double getValue();
    void setValue(double value);
    String getDate();
    void setDate(String date);
}