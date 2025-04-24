package TcsSets;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxSildingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        maxSlideWindow(nums,k);
    }

    private static void maxSlideWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
            if(i>=k-1){
                System.out.print(pq.peek()+" ");
                pq.remove(nums[i+1-k]);
            }
        }
    }
}
