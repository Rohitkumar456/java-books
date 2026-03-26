package ModernJavaInAction.Chapter6;

import ModernJavaInAction.Chapter4.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        Comparator<Dish>highestCalaroyComparator = Comparator.comparingInt(Dish::getCalories);

//        menu.stream().max(highestCalaroyComparator).ifPresent(System.out::println);
//        int sum = menu.stream().mapToInt(Dish::getCalories).sum();
//        System.out.println(sum);

        menu.stream().collect(Collectors.maxBy(highestCalaroyComparator)).ifPresent(System.out::println);
        int sum = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(sum);

        IntSummaryStatistics summary = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(summary);

        menu.stream()
                .collect(Collectors.groupingBy(dish -> {
                    if(dish.getCalories()<400) return "diet";
                    else if(dish.getCalories() >=400 && dish.getCalories()<700) return "normal";
                    else return "fat";
                },Collectors.mapping(Dish::getName,Collectors.toList()))).forEach((k,v)-> System.out.println(k+" "+v));


    }
}
