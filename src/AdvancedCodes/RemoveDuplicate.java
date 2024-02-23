package AdvancedCodes;

public class RemoveDuplicate {

    public static void main(String[] args) {
        System.out.println(rremove("abccbccba"));
    }
   static String rem(String s){
        int size=s.length();
        int i=0;
        StringBuilder ns=new StringBuilder();

        while(i<size){
            if(i<size-1 && s.charAt(i)==s.charAt(i+1)){
                while(i<size-1 && s.charAt(i)==s.charAt(i+1)){
                    i++;
                }
            }else{
                ns.append(s.charAt(i));
            }
            i++;
        }
        return ns.toString();
    }
   static String rremove(String s) {
        String s1="";

        while(s1.length() != s.length()){
            s1=s;
            s=rem(s);
        }
        return s1;
    }
}
