package Chapter18;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RyanAndMonicaTest{
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);
        RyanAndMonicaJob ryan = new RyanAndMonicaJob(account, 50, "Ryan");
        RyanAndMonicaJob monica = new RyanAndMonicaJob(account, 100, "Monica");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(ryan);
        executor.execute(monica);
        executor.shutdown();
    }
}