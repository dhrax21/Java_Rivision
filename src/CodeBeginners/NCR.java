package CodeBeginners;

import java.util.Arrays;

public class NCR {
    static int mod=1000000007;
    public static void main(String[] args) {

            int n = 10, r = 8;
            int[][] dp=new int[n+1][r+1];
            for(int[] ll : dp) {
                Arrays.fill(ll, -1);
            }
        System.out.println(solve(n,r,dp));

    }

    private static int solve(int n, int r, int[][] dp) {
        if(r>n) return 0; if(r==0) return 1; if(r==1) return n;
        if(dp[n][r] != -1) return dp[n][r];
        return dp[n][r]=(solve(n-1,r-1,dp) % mod + solve(n-1,r,dp)%mod)%mod;
    }
//     for(i=0;i<=n;i++){
//        dp[i][0]=1;
//    }
//        for(i=0;i<=n;i++){
//        for(j=1;j<=min(i,r);j++){
//            dp[i][j]=(dp[i-1][j]%mod + dp[i-1][j-1]%mod)%mod;
//        }
//    }
//        return dp[n][r];
    private static int solveTab(int n,int r){
        int[][] dp=new int[n+1][r+1];

        for(int i=0; i<=n; i++){
            dp[i][0]=1;
        }

        for(int i=0; i<=n; i++){
            for(int j=1; j<=Math.min(i,r); j++){
                dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%mod;
            }
        }

        return dp[n][r];

    }

}
