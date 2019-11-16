package by.gsu.mslab;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Callable;

public class CalculatorThread implements Callable<List<Integer>> {
    private List<Integer> valueList;

    public CalculatorThread(List<Integer> valueList) {
        this.valueList = valueList;
    }

    @Override
    public List<Integer> call() throws Exception {
        ListIterator<Integer> iterator = valueList.listIterator();
            while(iterator.hasNext()){
            int sum = 0;
            Integer nextInt = iterator.next();
            while (nextInt != 0){
                sum += (nextInt % 10);
                nextInt/=10;
            }
            if(sum < 10){
                iterator.remove();
            }
        }
        return valueList;
    }
}
