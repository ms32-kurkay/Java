import by.gsu.mslab.ThreadGenerator;

import java.util.concurrent.ExecutionException;

public class Runner {
    public static void main(String[] args) {
        ThreadGenerator threadGenerator = new ThreadGenerator();
        try {
            threadGenerator.menu();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
