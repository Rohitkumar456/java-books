package ModernJavaInAction.Chapter5;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

class Trader{
    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}
 class Transaction{
    private final Trader trader;
    private final int year;
    private final int value;
    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader(){
        return this.trader;
    }
    public int getYear(){
        return this.year;
    }
    public int getValue(){
        return this.value;
    }
    public String toString(){
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }
}

public class Main {

    // DIstinct

    public static void main(String[] args) {
        Student s1 = new Student(1,"rohit","Math");
        Student s2 = new Student(2,"rk","science");
        Student s3 = new Student(3,"nikhil","physics");
        Student s4 = new Student(3,"nikhil","physics");

        List<Student> sList = new ArrayList<>();
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
        sList.add(s4);

//        sList.stream().distinct().forEach(s-> System.out.println(s.id));


        List<Integer>l1 = Arrays.asList(1,2,3,4);
        List<Integer>l2 = Arrays.asList(4,2);

        List<int[]> pairs = l1.stream()
                .flatMap(i -> l2.stream().map(j -> new int[]{i,j}))
                .filter(arr -> (arr[0]+arr[1])%3==0).toList();

        //
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //Finds all transactions in 2011 and sort by value (small to high)

        List<Transaction>txns = transactions.stream().filter(txn->txn.getYear()==2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();

        //What are all the unique cities where the transacting traders work?

        List<String>cities = transactions.stream()
                .map(txn->txn.getTrader().getCity())
                .distinct().toList();

//        show(cities);

        //Finds all traders from Cambridge and sort them by name

        List<Trader> tl = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();

//        show(tl);

        //Returns a string of all traders’ names sorted alphabetically

        String trader = transactions.stream()
                .map(txn->txn.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());

//        System.out.println(trader);

        // What’s the highest value of all the transactions?

        BinaryOperator<Transaction>bt = BinaryOperator.maxBy(Comparator.comparing(Transaction::getValue));

        Optional<Transaction>highest = transactions.stream()
                .reduce(bt);

        transactions.stream()
                .max(Comparator.comparing(Transaction::getValue))
                .ifPresent(t-> System.out.println(t.getValue()));

//        if(highest.isPresent()) System.out.println(highest.get());

        // List of all transactions sorted by value and if same sort by trader's name

        List<Transaction>sortedTrxns = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue).thenComparing(txn->txn.getTrader().getName()))
                .toList();

        show(sortedTrxns);

    }

    public static<T> void  show(List<T> list){
        list.forEach(System.out::println);
    }

}
