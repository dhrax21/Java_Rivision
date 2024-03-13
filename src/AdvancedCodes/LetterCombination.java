package AdvancedCodes;

public class LetterCombination {
    public static void main(String[] args) {

        printLetterComb("","12");
    }

    private static void printLetterComb(String up, String p) {

        if(p.isEmpty()){
            System.out.print(up+" ");
            return;
        }

        int digit=p.charAt(0)-'0';      //
//        System.out.print(digit);
        for(int i=(digit-1)*3; i<digit*3; i++){
            char ch=(char)('a'+i);
//            System.out.print("\n"+ch);
            printLetterComb(up+ch,p.substring(1));
        }
    }

}
