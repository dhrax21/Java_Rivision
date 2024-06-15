package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChangePermutations {
    public static void main(String[] args) {
        int[] coins={2,3,5,6};
        int tar=10;
        int[] dp=new int[tar+1];
        dp[0]=1;

        for(int amt=1; amt<=tar; amt++){

            for(int coin : coins){
                if(coin<=amt){
                    int remAmt=amt-coin;
                    dp[amt] +=dp[remAmt];
                }
            }
        }
          System.out.println(Arrays.toString(dp));
//        System.out.println(dp[tar]);
    }
}
