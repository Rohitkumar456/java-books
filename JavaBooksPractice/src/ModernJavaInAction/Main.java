package ModernJavaInAction;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Main {

    public static void get(int n){
        System.out.println("rohit");
    }
    public static void main(String[] args) {

        ConcreteNormal cn = new ConcreteNormal();

        double n = 5d;
        get(5);
        Parent p = new Child();
        System.out.println("p="+p.a);
        Integer i = 5;
        int j = i;
        System.out.println(j);
//        Thread t= new Thread(() -> p.getA());


//        System.out.println("Hello, World!");

        Parent pc = new Child();
        Child c = new Child();
//        Child cp = new Parent();
        pc.getA();
//        List<Integer>list = Arrays.asList(1,2);
//        forEach(list,(s) -> list.add(s));

        int[] ar = {1,2,3,4,4};
        Arrays.stream(ar);



    }

    public boolean getValue(){
        return true;
    }

    public  void tmp() {
        Integer i = Integer.valueOf(1);

    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer){
        consumer.accept(list.get(0));
    }






}