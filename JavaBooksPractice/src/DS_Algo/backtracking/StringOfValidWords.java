package DS_Algo.backtracking;

import java.util.Arrays;
import java.util.HashMap;

public class StringOfValidWords {

    public static void main(String[] args) {
        String str = "iliket";
        String[] dictionary = {"i", "like", "sam", "sung", "samsung", "mobile",
                "ice","cream", "icecream"};

        HashMap<String,Boolean>map = new HashMap<>();
        int count =0;
        Arrays.stream(dictionary).forEach(s -> {map.put(s,true);
        });
        
        isValidString(0,str.length(),str,map,"");
    }

    public static void isValidString(int s, int e, String str, HashMap<String,Boolean> map, String result) {


        for(int i=s+1;i<str.length();i++){

        }


    }


}
