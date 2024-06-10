package DP;

import java.util.Arrays;
import java.util.Scanner;

public class ClimbStairsWithVariableJumps {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        // we are given an array of steps we need to find how much steps do we need to go to the end of the array !
    // we'll start from the (last-1) element and calculate the steps by summing the previous steps.

        int[] dp=new int[n+1];
        dp[n]=1;

        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=arr[i] && i+j<=n; j++){
                dp[i]+=dp[i+j];
            }
        }

        System.out.println(Arrays.toString(dp));
    }
}

// input
//  5
//  3,2,4,2,0,2,3,1,2,2



//---------------------------------------------------------------------------------------------//

//Climb stairs to the top by memoization


