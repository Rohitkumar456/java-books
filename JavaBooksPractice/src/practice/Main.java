package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        String s = "rohit/kumar/verma";
        String[] ar = s.split("/");
//        for(String tmp:ar){
//            System.out.println(tmp);
//        }

        Runnable r = () -> {};
        Callable<Integer> c = () -> 1;

//        aziro();

    }

    public static void aziro(){
        String[] words = {"apple", "kiwi", "banana", "cat", "dog", "orange", "pear"};
        List<Employee>el = Arrays.asList(new Employee("Ravi", "HR", 50000),
                new Employee("Meena", "Tech", 95000),
                new Employee("Ajay", "Tech", 88000),
                new Employee("John", "Finance", 60000),
                new Employee("Kumar", "HR", 52000),
                new Employee("Sita", "Finance", 70000));


        Arrays.stream(words).sorted(Comparator.comparing(String::length)).forEach(x-> System.out.println(x));
    }
}

class Employee{
    String name;
    String department;
    int salary;

    public Employee(String name,String dept,int salary){
        this.name = name;
        this.department = dept;
        this.salary = salary;
    }
}
