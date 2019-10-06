import java.util.List;

public class DailyExRate {
    private List<Currency> currency;
    private String date;

    public DailyExRate() {
    }

    public DailyExRate(List<Currency> currency, String date) {
        this.currency = currency;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public List<Currency> getCurrency() {
        return currency;
    }

    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Date = " + date + ", " + currency;
    }
}