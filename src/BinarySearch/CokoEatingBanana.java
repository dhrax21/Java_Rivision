package BinarySearch;

import java.util.Arrays;

//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
// The guards have gone and will come back in h hours.
//        Koko can decide her bananas-per-hour eating speed of k. Each hour,
//        she chooses some pile of bananas and eats k bananas from that pile.
//        If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//        Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//        Return the minimum integer k such that she can eat all the bananas within h hours.
//        Example 1:
//
//        Input: piles = [3,6,7,11], h = 8
//        Output: 4

public class CokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed=1;
        int maxSpeed= Arrays.stream(piles).max().getAsInt();

        while(minSpeed<maxSpeed){
            int mid=minSpeed + (maxSpeed-minSpeed)/2;

            if(canEatWithThisSpeed(piles,h,mid)){
                maxSpeed=mid;
            }else{
                minSpeed=mid+1;
            }
        }
        return minSpeed;
    }
    private boolean canEatWithThisSpeed(int[] piles,int h,int speed){
        int hour=0;

        for(int pile : piles){
            hour += Math.ceil ((double) pile/speed);
        }
        return hour<=h;
    }
}
