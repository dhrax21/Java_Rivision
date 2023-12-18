package AdvancedCodes;

public class Permutations {
    public static void main(String[] args) {
//        permute("","xyz");
          permuteGFG("abc","");
    }
    static void permuteGFG(String s,String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            String ros=s.substring(0,i)+s.substring(i+1);
//            System.out.println("\t"+ros);
            permuteGFG(ros,ans+ch);
        }
    }
}
