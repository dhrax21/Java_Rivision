package TcsSets;

//Given an array of pairs arr[], a pair (a, b) is said to be symmetric with (c, d)
//if b = c and a = d. In other words, reversing the elements of one pair should result in the other pair.
//The first element of each pair is guaranteed to be distinct.

import java.util.ArrayList;
import java.util.HashMap;

public class SymmetricPairs {
    public static void main(String[] args) {
        int[][] arr = {{5, 8}, {7, 9}, {8, 5}, {9, 7}, {6, 10}};

        System.out.println(findSymmetricPairs(arr));
    }

    private static ArrayList<ArrayList<Integer>> findSymmetricPairs(int[][] arr) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int[] nums : arr){
            int first=nums[0];
            int second=nums[1];

            if(!map.containsKey(second)){
                map.put(first,second);
            }else{
                ArrayList<Integer> ans=new ArrayList<>();
                ans.add(first);
                ans.add(second);
                result.add(ans);
            }
        }
        return result;
    }
}
