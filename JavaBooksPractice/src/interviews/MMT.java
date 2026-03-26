package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MMT {

    public static List<List<Integer>>ans = new ArrayList<>();
    public static void main(String[] args) {

        int[][] envelopes = {{1,2},{4,5},{7,8},{3,3},{3,5}};

        Arrays.sort(envelopes,(a,b)->{
            return a[0]!=b[0]?a[0]-b[0]:b[1]-a[1];
        });

//        for(int[] e:envelopes){
//            System.out.println("{"+e[0]+" "+e[1]+"}");
//        }

        int[] arr = {1,1,0,0,0,1,1,1,1,0,1};
        String[] words = {"a","tea","ldt","ybm","zkw","r","d","dms","le","u","ze"};
        //total number of possible space = powerset = 2^n
        String[] ans = new String[arr.length];
        int[] lis = new int[arr.length];
        lis[0]=1;
        ans[0]=String.valueOf(0);

        for(int i=1;i<arr.length;i++){
            lis[i] = 1;
            ans[i]= String.valueOf(i);
            for(int j=i-1;j>=0;j--){
                if(arr[i]!=arr[j]){
                    if(1+lis[j]>lis[i]){
                        ans[i] = ans[j]+" "+i;
                        lis[i]  = 1+lis[j];
                    }

                }
            }
        }
        System.out.println("-------");
//        for(String t :ans) System.out.println(t);

        String tmp = ans[arr.length-1];
        for(String t:tmp.split(" ")){
            int indx = Integer.valueOf(t);
            System.out.println(indx);
        }

        System.out.println("llis="+lis[arr.length-1]);
        System.out.println("lis="+ans[arr.length-1]);



//        generate(arr,0,new ArrayList<>());

//        ans.forEach(l-> {
//            l.forEach(x-> System.out.print(x+" "));
//            System.out.println();
//        });
    }

    public static void generate(int[]arr, int s, List<Integer>list){

        if(s>=arr.length){
            ans.add(list);
            if(list.isEmpty()) System.out.println("{}");
            else list.forEach(x-> System.out.print(x+" "));
            System.out.println();
            return;
        }
        list.add(arr[s]);
        generate(arr,s+1,list);
        list.remove(Integer.valueOf(arr[s]));
        generate(arr,s+1,list);
    }

    public static int longestPallindromicSubstring(String s){
        int longest = 1;
        int start=0;
        int i=1;
        while(i<s.length()){
            int k=1;
            while(checkSameChar(s,i,i-1)){
                k++;
                i++;
            }
            if(longest<k){
                longest = k;
                start=i-k;
            }
            k=1;
            boolean c = true;
            int np = i+1;
            while(checkSameChar(s,i-k,i+k)){
                if(longest<(2*k+1)){
                    longest = 2*k+1;
                    start=i-k;
                }

                longest = Math.max(2*k+1,longest);
                if(checkSameChar(s,i+k,i+k-1) && c){
                    np = i+k-1;
                    c=false;
                }
                k++;
            }
            i=np;
        }
        System.out.println(s.substring(start,start+longest));
        return longest;
    }

    public static boolean checkSameChar(String s, int i, int j){
        if(i<0 || j>=s.length()) return false;
        return s.charAt(i)==s.charAt(j);
    }

}
