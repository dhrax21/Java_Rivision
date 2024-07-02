package GfgPracticeProblem;

import java.util.HashMap;

public class ArrayPairSum {
    public boolean canPair(int[] nums, int k) {
        if(nums.length%2 != 0) return false;            // if array length is odd then it can not be divided into pairs
              //{remainder,frequence}
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i : nums){
            int rem=i % k;
            map.put(rem,map.getOrDefault(rem,0)+1);
        }

        int remCount=0;
        for(int m : nums){
            int rem=m%k;
            if(rem==0){
                if(map.get(rem) % 2 != 0) return false;
            }else if(2 * rem == k){
                if(map.get(rem) % 2 != 0 ) return false;
            }else{
                if(map.get(rem) != map.get(k-rem)) return false;
            }
        }
        return true;
    }
}
