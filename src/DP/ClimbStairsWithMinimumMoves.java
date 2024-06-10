package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ClimbStairsWithMinimumMoves {
    public static void main(String[] args) {
        int[] arr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int n= arr.length;
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= arr[i] && i + j <= n; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(dp[i + j], min);
                    }
                    if (min != Integer.MAX_VALUE) {
                        dp[i] = min + 1;
                    } else {
                        dp[i] = null;
                    }

                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
