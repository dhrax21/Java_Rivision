package DP;

public class EditDistance {
    public static void main(String[] args) {
        String s1="sohan";
        String s2="rdmln";

        int[][] dp=new int[s1.length()+1][s2.length()+1];


        for(int i=0; i< dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0){
                    dp[i][j]=j;
                }else if(j==0){
                    dp[i][j]=i;
                }else{
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1];
                    }else{
                        int replace=1+dp[i-1][j-1];
                        int delete=1+dp[i-1][j];
                        int insert=1+dp[i][j-1];

                        dp[i][j]=Math.min(replace,Math.min(delete,insert));
                    }
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
}
