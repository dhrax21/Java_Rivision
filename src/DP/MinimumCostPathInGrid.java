package DP;

public class MinimumCostPathInGrid {

    public static void main(String[] args) {
        int r=4;
        int c=4;

        int[][] grid={
                {9,4,9,9},
                {6,7,6,4},
                {8,3,3,7},
                {7,4,9,10}};

        System.out.println(minimumCostPath(grid));

    }
    public static int minimumCostPath(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];

        for(int i=n-1; i>=0; i--){

            for(int j=m-1; j>=0; j--){

                if(i==n-1 && j==m-1){               // for last cell
                    dp[i][j]=grid[i][j];
                }else if(i==n-1){                   // for last row
                    dp[i][j]=dp[i][j+1] + grid[i][j];

                }else if(j==m-1){                   //for last column
                    dp[i][j]=grid[i][j] + dp[i+1][j];

                }else{
                    dp[i][j]=Math.min(dp[i][j+1],dp[i+1][j]) + grid[i][j];
                }
            }
        }

        return dp[0][0];
    }
}
