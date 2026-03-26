package ModernJavaInAction.Chapter4;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T t: list) {
            if(p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

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

        PriorityQueue<String>pq = new PriorityQueue<>(Comparator.comparing(String::length));
        pq.addAll(List.of("apple", "kiwi", "banana", "cat", "dog", "orange", "pear"));

        Dish d1 = new Dish("pork", false, 800, Dish.Type.MEAT);
        Dish d2 = new Dish("beef", false, 700, Dish.Type.MEAT);

        System.out.println(Comparator.comparing(Dish::getName));


//        menu.stream()
//                .filter(dish -> dish.getCalories()>400)
//                .forEach(dish-> System.out.println(dish.getName()));
        menu.stream()
                .filter(dish->dish.getName().length()>=7)

                .sorted((a,b)-> 0)
                .forEach(dish->System.out.println());


        Map<Integer,List<Dish>>map =  menu.stream()
                .collect(Collectors.groupingBy(dish->dish.getName().length()));


        map.forEach((k,v)->System.out.println(k+""+v));

        String[] words = {"apple", "kiwi", "banana", "cat", "dog", "orange", "pear"};
        Map<Integer,Integer> wMap = new HashMap<>();
        for(String s: words){
            int len = s.length();
            wMap.put(len, wMap.getOrDefault(len,0)+1);
        }


        wMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<Integer,Integer>::getValue).reversed())
                .limit(3)
                .forEach(e-> System.out.println(e.getKey()+" "+e.getValue()));



        PriorityQueue<Integer> intPQ = new PriorityQueue<>(Comparator.reverseOrder());

        int[] arr = {5,3,8,1,2,7,4,6};
        List<Integer>ans = new ArrayList<>();
        ans.add(1);
        ans.add(1);
        ans.add(1);
        System.out.println("rohit----------");
//        ans.stream().flatMap(x-> new int[]{x}).forEach(x-> System.out.println(x.length));

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);

        SDT sdt = new SDT();
        System.out.println(sdt.serialize(root));
        TreeNode nroot = sdt.deserialize(sdt.serialize(root));
        sdt.preorderTraversal(nroot);

        String str = "Hello#World";
        Arrays.stream(str.split("#")).forEach(s-> System.out.println(s));

    }


}

@FunctionalInterface
interface custom extends Predicate {
}


class SDT{

    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        sb.deleteCharAt(sb.length()-1);
        String s = sb.toString();
        s.split(",");
        return sb.toString();
    }

    public TreeNode deserialize(String s){
        List<Integer>nodes = Arrays.stream(s.split(","))
                .map(node-> Integer.parseInt(node)).collect(Collectors.toList());
        return construct(nodes,0,nodes.size()-1);
    }

    public TreeNode construct(List<Integer>nodes,int st, int en){
        if(st>en) return null;

        int i=st+1;
        TreeNode root = new TreeNode(nodes.get(st));
        while(i<=en && nodes.get(i)<nodes.get(st)) i++;

        root.left = construct(nodes,st+1,i-1);
        root.right = construct(nodes,i,en);
        return root;

    }

    public void preOrder(TreeNode root,StringBuilder sb){
        if(root==null) return;
        sb.append(root.val+",");
        preOrder(root.left,sb);
        preOrder(root.right,sb);
    }

    public void preorderTraversal(TreeNode root){
        if(root==null) return;
        System.out.println(root.val+",");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

