package JavaConcurrencyCookbook.chapter4;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Future<BigInteger>>result = new ArrayList<>();
        List<BigInteger>ans = new ArrayList<>();
        long intialTime = System.currentTimeMillis();;
        long finalTime;

        for (int i = 0; i < 1000; i++) {
            FactorialCalculator calculator = new FactorialCalculator(i);
            result.add(executorService.submit(calculator));
//            ans.add(calculator.call());
        }

        result.stream().forEach(res->{
            try {
                System.out.println("Result is: "+res.get());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

//        result.forEach(x-> System.out.println("Result is: "+x.get()));
//        ans.forEach(x->System.out.println("Result is: "+x));

//        Map<String,String> map = new ConcurrentHashMap<>();
        finalTime = System.currentTimeMillis();

        System.out.println("Total time taken: "+(finalTime-intialTime)+" ms");
    }

}
