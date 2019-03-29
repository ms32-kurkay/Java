package by.gsu.mslab;

import java.math.BigDecimal;

public class BusinessTrip {
    private final BigDecimal ALLOWANCERATE = new BigDecimal(250);
    private String employeeAccount;
    private BigDecimal transportationExpenses;
    private int numberOfDay;

    public BusinessTrip(){}

    public BusinessTrip(BigDecimal ALLOWANCERATE, String employeeAccount, BigDecimal transportationExpenses, int numberOfDay){
        this.employeeAccount = employeeAccount;
        this.transportationExpenses = transportationExpenses;
        this.numberOfDay = numberOfDay;
    }


    public BigDecimal getALLOWANCERATE() {
        return ALLOWANCERATE;
    }

    public String getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(String employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public BigDecimal getTransportationExpenses() {
        return transportationExpenses;
    }

    public void setTransportationExpenses(BigDecimal transportationExpenses) {
        this.transportationExpenses = transportationExpenses;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public BigDecimal getTotal(){
        BigDecimal total = new BigDecimal("0");
        total = transportationExpenses.add(ALLOWANCERATE.multiply(new BigDecimal(numberOfDay)));
        return total;
    }

    public void show(){
        System.out.println("rate = " + ALLOWANCERATE.setScale(2, BigDecimal.ROUND_DOWN));
        System.out.println("account = " + employeeAccount);
        if (transportationExpenses == null){
            System.out.println("transport = 0.00");
            transportationExpenses = new BigDecimal(0);
        }else{
            System.out.println("transport = " + transportationExpenses.setScale(2, BigDecimal.ROUND_CEILING));
        }
        System.out.println("days = " + numberOfDay);
        System.out.println("total = " + getTotal().setScale(2,BigDecimal.ROUND_DOWN));
    }

    @Override
    public String toString() {
        return ALLOWANCERATE.setScale(2, BigDecimal.ROUND_DOWN) + ";" +
                employeeAccount + ";" +
                transportationExpenses.setScale(2, BigDecimal.ROUND_DOWN) + ";" +
                numberOfDay + ";" +
                getTotal().setScale(2,BigDecimal.ROUND_DOWN);
    }

}
