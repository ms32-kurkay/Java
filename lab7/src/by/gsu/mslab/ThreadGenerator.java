package by.gsu.mslab;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadGenerator {
    private int countThread = 2;
    private int maxValue;
    private Future<List<Integer>> future;

    private List execute() throws ExecutionException, InterruptedException {
        List<Integer> values = new ArrayList();
        for(int i = 1; i <= maxValue; i++) {
            values.add(i);
        }
        ExecutorService service = Executors.newFixedThreadPool(countThread);
        future = service.submit(new CalculatorThread(values));
        service.shutdown();
        List<Integer> list = future.get();
        return list;
    }

    public void menu() throws ExecutionException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter count of threads:");
        while(true){
            String value = sc.nextLine();
            try{
                if(Integer.parseInt(value) <= 0)
                    throw new NumberFormatException();
                countThread = Integer.parseInt(value);
                break;
            }catch(NumberFormatException e){
                System.out.print("Wrong value, try again:");
            }
        }
        System.out.print("Enter maxValue:");
        while(true){
            String value = sc.nextLine();
            try{
                if(Integer.parseInt(value) < 1)
                    throw new NumberFormatException();
                maxValue = Integer.parseInt(value);
                break;
            }catch(NumberFormatException e){
                System.out.print("Wrong value, try again:");
            }
        }
        System.out.print("Choose action for thread's results:\n" +
                "1.summarize;\n" +
                "2.multiple;\n" +
                "3.subtract;\n" +
                "Your value: ");
        while(true){
            String value = sc.nextLine();
            try{
                if(Integer.parseInt(value) < 1 || Integer.parseInt(value) > 3)
                    throw new NumberFormatException();
                List<Integer> list = execute();
                ListIterator<Integer> iterator = list.listIterator();
                switch (Integer.parseInt(value)){
                    case 1:
                        while(iterator.hasNext()){
                            Integer var = iterator.next();
                            iterator.set(var*countThread);
                        }
                        getResult(list);
                        break;
                    case 3:
                        while(iterator.hasNext()){
                            Integer var = iterator.next();
                            iterator.set(var - var*(countThread - 1));
                        }
                        getResult(list);
                        break;
                    case 2:
                        while(iterator.hasNext()){
                            Integer var = iterator.next();
                            iterator.set((int) Math.pow(Double.valueOf(var),Double.valueOf(countThread)));
                        }
                        getResult(list);
                        break;
                        default:
                            System.out.print("Wrong value, try again:");
                            break;
                    }
                    break;
            }catch(NumberFormatException e){
                System.out.print("Wrong value, try again:");
            }
        }
    }

    public void getResult(List<Integer> result){
        System.out.print("Result: ");
        for (int i = 0; i < result.size(); i++){
            System.out.print(result.get(i));
            if(i != result.size()-1)
                System.out.print(",");
        }
    }
}


