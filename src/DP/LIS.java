package DP;

import java.util.Arrays;

//longest increasing subsequence
public class LIS {
    public static void main(String[] args) {
        int[] arr={12,22,9,33,21,50,41,60,80,3};

        int[] dp=new int[arr.length+1];
        arr[0]=1;


        int count=0;
        for(int i=1; i<dp.length-1; i++){
            int max=0;

            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    if(dp[j]>max){
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
            if(dp[i]>count){
                count=dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
