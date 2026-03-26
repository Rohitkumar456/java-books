package practice;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {

        List<String>list1=Arrays.asList(
                "7894087398",
                "9876549087",
                "7654328902",
                "7654328902"
        );

//        List<String>masked = list1.stream().map(s-> convertToMask(s)).collect(Collectors.toList());
//        for(String s : masked) System.out.println(s);
//
//        Function<String,Integer>f = String::length;
//        Supplier<Integer>s = "rohit"::length;

        Counter c = new Counter();

        Thread t1 = new Thread(
                ()->{
//                    Counter.userId = "rohit";
                    Counter.userId.set("rohit");
                    for(int i=0;i<10;i++) {
                        c.increment();
                        System.out.println(Thread.currentThread().getName() + Counter.userId.get());
                    }
                }
        );
        t1.setName("Thread-rohit: ");

        Thread t2 = new Thread(
                ()->{
//                    Counter.userId = "sandeep";
                    Counter.userId.set("sandeep");
                    for(int i=0;i<10;i++) {
                        c.increment();
                        System.out.println(c.count);
                        System.out.println(Thread.currentThread().getName() + Counter.userId.get());
                    }
                }
        );
        t2.setName("Thread-sandy: ");

        Thread t3 = Thread.startVirtualThread(()-> System.out.println("rohit"));
        ThreadLocal<String>name = new ThreadLocal<>();
        t2.start();
        t1.start();

//        System.out.println(c.count.get());

    }

    public static String convertToMask(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<6;i++) sb.append('*');
        for(int i=3;i>=0;i--) sb.append(s.charAt(n-i-1));
        return sb.toString();
    }
}

class Counter{
    public static ThreadLocal<String>userId = new ThreadLocal<>();
    AtomicInteger count;
//    public static String userId;

    public Counter(){
        this.count = new AtomicInteger(0);
    }


    public void increment(){ this.count.incrementAndGet(); }
}
