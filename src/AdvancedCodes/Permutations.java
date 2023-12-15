package AdvancedCodes;

public class Permutations {
    public static void main(String[] args) {
//        permute("","xyz");
          permuteGFG("abc","");
    }

    private static void permute(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for(int i=0; i<= p.length(); i++){
            String fst=p.substring(0,i)+p.substring(i);
            permute(fst+ch,up.substring(1));
        }
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
