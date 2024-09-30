package HashMaps;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr={1,2,34,56,77,1,34};
        int target=111;

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0; i<arr.length; i++){
            int complement=target-arr[i];

            if(map.containsKey(complement)){
                System.out.println("["+map.get(+complement)+", "+i+"]");
                break;
            }else{
                map.put(arr[i],i);
            }
        }
    }
}
