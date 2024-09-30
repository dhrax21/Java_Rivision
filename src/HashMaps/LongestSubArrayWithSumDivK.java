package HashMaps;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumDivK {

    public static void main(String[] args) {
        // The idea is to store all the first occurrences of remainder for the prefix sum of the array
        // so that if we find the same remainder then we can calculate the length for the same

        int n = 6, k = 3;
        int[] a = {2, 7, 6, 1, 4, 5};
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0,len=0,maxi=0;
        map.put(0,-1);

        for(int i=0; i<n; i++){
            sum+=a[i];

            int rem=(sum%k);
            if(rem<0){
                rem+=k;     // if rem is negative so to make it positive so that it works for all cases
            }

            if(!map.containsKey(rem)){
                map.put(rem,i);
            }else{
                len=i-map.get(rem);     // calculating the length
                maxi=Math.max(maxi,len);
            }
        }
    }
}
