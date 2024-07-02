package DP;

public class MaximumPathSumInGird {

    // find the maximum cost from row 0 to last row
    static int maximumPath(int n, int Matrix[][])
    {
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = Matrix[i][j];            // copying the matrix to dp grid
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[i][j] += Math.max(dp[i-1][j], dp[i-1][j+1]); //filling dp[i][j] from upper adjacent cells
                }
                else if(j==n-1){
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);//filling dp[i][j] from upper adjacent cells
                }
                else
                {  // for any middle column we fill dp[i][j] from taking all adjacent upper cells
                    dp[i][j] += Math.max(dp[i-1][j-1], Math.max(dp[i-1][j],dp[i-1][j+1]));

                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int j=0;j<n;j++){
            max = Math.max(max,dp[n-1][j]);
        }
        return max;
    }
}