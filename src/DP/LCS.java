package DP;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String s1="acbde";
        String s2="acbe";

        int[][] dp=new int[s1.length()+1][s2.length()+1];

        for(int i= dp.length-2; i>=0; i--){
            for(int j= dp[0].length-2; j>=0; j--){
                char c1=s1.charAt(i);
                char c2=s2.charAt(j);

                if(c1==c2){
                    dp[i][j]=1+dp[i+1][j+1];
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
//        System.out.println(dp[0][0]);

        for(int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
    }
}
