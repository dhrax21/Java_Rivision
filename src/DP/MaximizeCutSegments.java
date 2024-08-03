package DP;

import java.util.Arrays;

public class MaximizeCutSegments {
    public int maximizeCuts(int n, int x, int y, int z)
    {
           int[] dp=new int[n+1];
           Arrays.fill(dp,-1);
           int ans=cut(n,x,y,z,dp);

        return cutTab(n, x, y, z);

    }
     int cut(int n,int x,int y,int z,int[] dp){
         if(n==0)
             return 0;

         if(n<0) return Integer.MIN_VALUE;
         if(dp[n] != -1)
             return dp[n];

         int xseg=1+cut(n-x,x,y,z,dp);
         int yseg=1+cut(n-y,x,y,z,dp);
         int zseg=1+cut(n-z,x,y,z,dp);

         int res=Math.max(xseg,Math.max(yseg,zseg));

         dp[n]=res;
         return dp[n];
     }
    int cutTab(int n,int x,int y,int z){

        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=0;

        for(int i=1; i<=n; i++){
            if(i-x>=0)
                dp[i]=Math.max(dp[i],dp[i-x]+1);
            if(i-y>=0)
                dp[i]=Math.max(dp[i],dp[i-y]+1);
            if(i-z>=0)
                dp[i]=Math.max(dp[i],dp[i-z]+1);
        }
        if(dp[n] < 0) return 0;
        return dp[n];
    }
}
