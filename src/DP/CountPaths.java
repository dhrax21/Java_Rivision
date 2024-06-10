package DP;

public class CountPaths {
    public static void main(String[] args) {
        int n=6;
        System.out.println(countPathTabulation(n));
    }
    static int countPath(int n,int[] dp){
        if(n==0) return 1;
        else if(n<0) return 0;

        if(dp[n]>0) return dp[n];

        int cp1=countPath(n-1,dp);
        int cp2=countPath(n-2,dp);
        int cp3=countPath(n-3,dp);

        int totalPaths=cp1+cp2+cp3;

        dp[n]=totalPaths;
        return totalPaths;
    }

    static int countPathTabulation(int n){

        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1; i<=n; i++){
            if(i==1){
                dp[i]=dp[i-1];
            }else if(i==2){
                dp[i]=dp[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
        }
        return dp[n];
    }
}
