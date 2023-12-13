package AdvancedCodes;

public class SubSet {
    public static void main(String[] args) {
        printSubSet("","abc");
    }

    private static void printSubSet(String ans, String str) {
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        char ch=str.charAt(0);
        printSubSet(ans+ch,str.substring(1));
        printSubSet(ans,str.substring(1));
    }
}
