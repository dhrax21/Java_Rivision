package AdvancedCodes;

public class Permutations {
    public static void main(String[] args) {
//        permute("","xyz");
//          permuteGFG("abc","");
        permutationTrick("XYZ");
    }


    static void permutationTrick(String s){
        int n=s.length();
        int f=fact(n);

        for(int i=0; i<f; i++){
            StringBuilder sb=new StringBuilder(s);
            int temp=i;

            for(int div=n; div>=1; div--){
                int q = temp / div;
                int r = temp % div;

                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp=q;
            }
            System.out.println();
        }
    }

    static int fact(int n){
        int val=1;

        for(int i=2; i<=n; i++){
            val *= i;
        }
        return val;
    }
    static void permuteGFG(String s,String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            String ros=s.substring(0,i)+s.substring(i+1);
            permuteGFG(ros,ans+ch);
        }
    }
}
