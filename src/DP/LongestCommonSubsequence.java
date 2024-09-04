package DP;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1="acbde";
        String s2="acde";

        int[][] dp=new int[s1.length()][s2.length()];

        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
//        System.out.println(solve(s1,s2,0,0));
        System.out.println(solveMem(s1,s2,0,0,dp));
    }

//    static int solve(String s1,String s2,int i,int j){
//
//        if(i>=s1.length() || j>=s2.length()){
//            return 0;
//        }
//
//
//        if(s1.charAt(i)==s2.charAt(j)){
//            return 1 + solve(s1,s2,i+1,j+1);
//        }else{
//
//            return Math.max(solve(s1,s2,i+1,j),solve(s1,s2,i,j+1));
//
//        }
//    }

    static int solveMem(String s1,String s2,int i,int j,int[][] dp){

        if(i>=s1.length() || j>=s2.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i)==s2.charAt(j)){
            return 1 + solveMem(s1,s2,i+1,j+1,dp);
        }else{

            dp[i][j]=Math.max(solveMem(s1,s2,i+1,j,dp),solveMem(s1,s2,i,j+1,dp));
            return dp[i][j];
        }
    }



}
