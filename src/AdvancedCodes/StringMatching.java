package AdvancedCodes;

public class StringMatching {
    public static void main(String[] args) {
        String str="ABABDABACDABABCABAB";
        String pat="ABABCABAB";

        boolean flag=false;

        int n=str.length();
        int m=pat.length();

        for(int i=0; i<n+1-m; i++){
            int j=0;

            while(j<m && str.charAt(i+j)==pat.charAt(j)){
                j++;

                if(j==m){
                    flag=true;
                    System.out.println(i);
                    break;
                }
            }
        }
        if(!flag){
            System.out.println("Not found");
        }
    }
}
