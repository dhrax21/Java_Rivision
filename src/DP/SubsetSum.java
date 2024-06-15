package DP;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr={2,3,5};
        int tar=8;
        int n=arr.length;
        boolean[][] dp=new boolean[n+1][tar+1];

        for(int i=0; i< dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }else if(i==0){
                    dp[i][j]=false;
                }else if(j==0){
                    dp[i][j]=true;
                }else{
                    if(dp[i-1][j]==true){
                        dp[i][j]=true;
                    }else{
                        int val=arr[i-1];
                        if(j>=val){
                            if(dp[i-1][j-val]==true){
                                dp[i][j]=true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[n][tar]);
    }
}
