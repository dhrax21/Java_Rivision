package AdvancedCodes;

import java.util.Arrays;

public class CoinChange {
    long[][] dp;        //memoization
    long helper(int[] coins,int N,int sum){
        if(N<=0 || sum<0)
            return 0;
        if(sum==0)
            return 1;

        if(dp[N][sum] != -1)
            return dp[N][sum];
        long included=helper(coins,N,sum-coins[N-1]);
        long excluded=helper(coins,N-1,sum);

        return dp[N][sum]=included+excluded;
    }
    public long count(int coins[], int N, int sum) {
        dp=new long[N+1][sum+1];
        for(long[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return helper(coins,N,sum);
    }
}

//   Inputs:      N = 3, sum = 4
//   Outputs:     coins = {1,2,3}