package practice;


/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.



Example 1:


Input: m = 3, n = 7
Output: 28


Example 2:
Input: m = 3, n = 2 Output: 3 Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down



 */

/*

static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) list.add(i); // 0,1,2,3,4
        new Thread(() -> {
            for (Integer i : list) {
                System.out.print(i + " ");
                try { Thread.sleep(100); } catch(Exception e) {}
            }
        }).start();
        new Thread(() -> {
            try { Thread.sleep(150); } catch(Exception e) {}
            list.add(99);
        }).start();

    }

    OUTPUT:
    0,1,2,3,4



------

class Interview{
    int i;
    static int j;
    {
        System.out.println(" Instance Block 1. Value of i = "+i);
    }
    static{
        System.out.println(" Static Block 1. Value of j = "+j);
        method_2();
    }
    {
        i = 5;
    }
    static{
        j = 10;
    }
    Interview(){
        System.out.println(" Welcome to Interview");
    }
    public static void main(String[] args){
        Interview ib = new Interview();
    }
    public void method_1(){
        System.out.println(" Instance method. ");
    }
    static{
        System.out.println(" Static Block 2. Value of j = "+j);
    }
    {
        System.out.println(" Instance Block 2. Value of i = "+i);
        method_1();
    }
    public static void method_2(){
        System.out.println(" Static method. ");
    }
}

OUTPUT:

Static Block 1. Value of j = 0
Static method.
Static Block 2. Value of j = 10
 Welcome to Interview
 Instance Block 1. Value of i =0
 Instance Block 2. Value of i =5
  Instance method.


20-25k







 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main3 {
    static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        String s = "wwrwwwrwr";

        List<Integer>index  = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='r') index.add(i);
        }
        int count = 0;
        int mid = index.size()/2;
        for(int i=0;i<index.size();i++){
            count+= Math.abs(index.get(i)- index.get(mid)) - Math.abs(i-mid);
        }

        BasicEnum.INSTANCE2.increment();
        System.out.println(BasicEnum.INSATANCE.count);
        System.out.println(BasicEnum.INSTANCE2.count);
        System.out.println(BasicEnum.count);



//        for (int i = 0; i < 5; i++) list.add(i); // 0,1,2,3,4
//        new Thread(() -> {
//            for (int i:list) {
//                System.out.print(i + " ");
//                try { Thread.sleep(100); } catch(Exception e) {}
//            }
//        }).start();
//
//        new Thread(() -> {
//            try { Thread.sleep(150); } catch(Exception e) {}
//            list.add(99);
//        }).start();

    }



    public static int countWays(int i, int j, int m , int n){

        if(i<0||j<0||i>=m||j>=n) return 0;
        if(i==0 && j==0) return 1;

        return countWays(i-1,j,m,n) + countWays(i,j-1,m,n);
    }

}




