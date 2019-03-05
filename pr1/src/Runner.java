import by.gsu.mslab.BusinessTrip;
public class Runner {
    public static void main(String[] args) {
        BusinessTrip[] businessTrips = new BusinessTrip[7];
        businessTrips[0] = new BusinessTrip( 25000,"Anton Slutsky",50000,5);
        businessTrips[1] = new BusinessTrip(25000,"Andrey Ivanov",60000,7);
        businessTrips[2] = null;
        businessTrips[3] = new BusinessTrip(25000,"Ivan Petrov", 45000,4);
        businessTrips[4] = new BusinessTrip(25000,"Alexander Bobrov",52000,5);
        businessTrips[5] = new BusinessTrip(25000,"Andrey Sidirov",49000,4);
        businessTrips[6] = new BusinessTrip();

        for (BusinessTrip businessTrip: businessTrips){
            if(businessTrip != null){
                businessTrip.show();
                System.out.println("----------");
            }
        }

        businessTrips[businessTrips.length-1].setTransportationExpenses(99999);

        System.out.println("Duration = " + (businessTrips[0].getNumberOfDay() + businessTrips[1].getNumberOfDay()));

        for (BusinessTrip businessTrip: businessTrips){
            if(businessTrip != null){
                System.out.println("----------");
                System.out.println(businessTrip.toString());
            }
        }

        System.out.println("");

        int sum = 0;

        for(BusinessTrip businessTrip: businessTrips){
            if( businessTrip!= null){
                sum += businessTrip.getTotal();
            }
        }

        System.out.println("total expenses = " + sum);

        int maxSum = 0;

        for(BusinessTrip businessTrip: businessTrips){
            if( businessTrip!= null){
                if(businessTrip.getTotal() > maxSum){
                    maxSum = businessTrip.getTotal();
                }
            }
        }

        System.out.println("Maximum = " + maxSum);

    }
}
