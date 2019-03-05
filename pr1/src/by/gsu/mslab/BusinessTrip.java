package by.gsu.mslab;

public class BusinessTrip {
    private final int ALLOWANCERATE = 25000;
    private String employeeAccount;
    private int transportationExpenses;
    private int numberOfDay;

    public BusinessTrip(){}

    public BusinessTrip(int ALLOWANCERATE, String employeeAccount, int transportationExpenses, int numberOfDay){
        this.employeeAccount = employeeAccount;
        this. transportationExpenses = transportationExpenses;
        this.numberOfDay = numberOfDay;
    }

    public String getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(String employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public int getTransportationExpenses() {
        return transportationExpenses;
    }

    public void setTransportationExpenses(int transportationExpenses) {
        this.transportationExpenses = transportationExpenses;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public int getTotal(){
        return (transportationExpenses + ALLOWANCERATE * numberOfDay);
    }

    public void show(){
        System.out.println("rate = " + ALLOWANCERATE);
        System.out.println("account = " + employeeAccount);
        System.out.println("transport = " + transportationExpenses);
        System.out.println("days = " + numberOfDay);
        System.out.println("total = " + getTotal());
    }

    @Override
    public String toString() {
        return ALLOWANCERATE + ";" + employeeAccount + ";" + transportationExpenses + ";" + numberOfDay + ";" + getTotal();

    }
}
