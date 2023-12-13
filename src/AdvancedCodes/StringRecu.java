package AdvancedCodes;

public class StringRecu {
    public static void main(String[] args) {
        String loc = skipMango("bamangotcdmangoz");
        System.out.println(loc);
    }

    static String skipMango(String str){
        if(str.isEmpty()){
            return "";
        }
        if(str.startsWith("mango")){
            return skipMango(str.substring(5));
        }else{
            return str.charAt(0) + skipMango(str.substring(1));
        }
    }
    public static String skipA(String s){
        if(s.isEmpty()){
            return "";
        }

        char ch=s.charAt(0);
        if(ch=='a'){
            return skipA(s.substring(1));
        }else{
            return ch+skipA(s.substring(1));
        }
    }
}
