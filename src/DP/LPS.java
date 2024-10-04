package DP;

import java.util.Arrays;

//Longest Palindromic Subsequence (Just find the longest common subsequence of the reversed String)
public class LPS {
    public static void main(String[] args) {
        String S = "abbbab";

        StringBuilder p = new StringBuilder(S);
        p.reverse();
        String P = p.toString();
        int n = S.length();
        int m = P.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(solve(0, 0, S, P, dp));
    }

    static int solve(int i, int j, String s1, String s2, int[][] dp) {
        if (i == s1.length()) return 0;
        if (j == s2.length()) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + solve(i + 1, j + 1, s1, s2, dp);
        } else {
            ans = Math.max(solve(i + 1, j, s1, s2, dp), solve(i, j + 1, s1, s2, dp));
        }
        return dp[i][j] = ans;
    }

}
//        String s="abba";
//
//        int[][] dp=new int[s.length()][s.length()];
//        for(int g=0; g<s.length(); g++){
//            for(int i=0,j=g; j<dp.length; i++,j++){
//                if(g==0){
//                    dp[i][j]=1;
//                }else if(g==1){
//                    if(s.charAt(i)==s.charAt(j)){
//                        dp[i][j]=2;
//                    }else{
//                        dp[i][j]=1;
//                    }
//                }else{
//                    if(s.charAt(i)==s.charAt(j)){
//                        dp[i][j]=2+dp[i+1][j-1];
//                    }else{
//                        dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
//                    }
//                }
//            }
//        }
//        for(int[] a: dp){
//            System.out.println(Arrays.toString(a));
//        }
//        System.out.println(dp);
////        System.out.println(dp[0][s.length()-1]);
//    }
//}
