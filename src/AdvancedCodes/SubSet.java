package AdvancedCodes;

public class SubSet {
    public static void main(String[] args) {
        printSubSet("","123");
    }

    private static void printSubSet(String ans, String str) {
        if(str.length()==0){
            System.out.print(ans+"\t");
            return;
        }

        char ch=str.charAt(0);
        printSubSet(ans+ch,str.substring(1));
        printSubSet(ans,str.substring(1));
    }
}
