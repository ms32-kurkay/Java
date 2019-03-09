import by.gsu.mslab.BusinessTrip;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {
        BusinessTrip[] businessTrips = new BusinessTrip[7];
        businessTrips[0] = new BusinessTrip( new BigDecimal("250"),"Anton Slutsky",new BigDecimal("45.34"),5);
        businessTrips[1] = new BusinessTrip(new BigDecimal("250"),"Andrey Ivanov",new BigDecimal("60.56"),7);
        businessTrips[2] = null;
        businessTrips[3] = new BusinessTrip(new BigDecimal("250"),"Ivan Petrov", new BigDecimal("46.10"),4);
        businessTrips[4] = new BusinessTrip(new BigDecimal("250"),"Alexander Bobrov",new BigDecimal("52.73"),5);
        businessTrips[5] = new BusinessTrip(new BigDecimal("250"),"Andrey Sidirov",new BigDecimal("49.5"),4);
        businessTrips[6] = new BusinessTrip();

        for (BusinessTrip businessTrip: businessTrips){
            if(businessTrip != null){
                businessTrip.show();
                System.out.println("----------");
            }
        }

        businessTrips[businessTrips.length-1].setTransportationExpenses(new BigDecimal("99.99"));

        System.out.println("Duration = " + (businessTrips[0].getNumberOfDay() + businessTrips[1].getNumberOfDay()));

        for (BusinessTrip businessTrip: businessTrips){
            if(businessTrip != null){
                System.out.println("----------");
                System.out.println(businessTrip.toString());
            }
        }

        System.out.println("");

        BigDecimal sum = new BigDecimal("0");

        for(BusinessTrip businessTrip: businessTrips){
            if( businessTrip!= null){
                sum = sum.add(businessTrip.getTotal());
            }
        }

        System.out.println("Total expenses = " + sum);
        System.out.println("");

        BigDecimal maxSum = new BigDecimal("0");

        for(BusinessTrip businessTrip: businessTrips){
            if( businessTrip!= null){
                if (maxSum.compareTo(businessTrip.getTotal())==(-1)){
                    maxSum = businessTrip.getTotal();
                }
            }
        }
        System.out.println("Maximum = " + maxSum);
    }
}
