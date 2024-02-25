package AdvancedCodes;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWith0Sum {
    public static long findSubarray(long[] arr ,int n)
    {
        long count=0;
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(sum,1);
        for(int i=0; i<n; i++){
            sum+=(long)arr[i];

            if(map.containsKey(sum)){
                count+=(long)map.get(sum);
                map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum,1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //Input:
        int n = 10;
        long arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7};

        System.out.println(findSubarray(arr,n));
    }
}
