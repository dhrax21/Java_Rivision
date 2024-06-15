package DP;

public class LongestPallindromicSubstring {
    public static void main(String[] args) {
        String s1="abccbde";
        int length=0;
        boolean[][] dp=new boolean[s1.length()][s1.length()];
        int count=0;

        for(int g=0; g<s1.length(); g++){       // g-> gap
            for(int i=0,j=g; j<dp.length; j++,i++){
                if(g==0){       // for the diagonal element where each character is single and is pallindrome
                    dp[i][j]=true;
                }else if(g==1){
                    if(s1.charAt(i)==s1.charAt(j)){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=false;
                    }
                }else{      // if gap>2
                    if(s1.charAt(i)== s1.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=false;
                    }
                }
                if(dp[i][j]){
                    length=g+1;
                }
            }
        }
        System.out.println(length);

    }
}
