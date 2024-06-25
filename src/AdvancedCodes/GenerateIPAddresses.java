package AdvancedCodes;

import java.util.ArrayList;

public class GenerateIPAddresses {

    public static void main(String[] args) {
        String str="1111";
        ArrayList<String> res=genIp(str);
        System.out.println(res);
    }
    public static ArrayList<String> genIp(String s) {
        ArrayList<String> res=new ArrayList<>();
        helper(s,0,0,"",res);
        return res;
    }
   static void helper(String s,int i,int par,String ans,ArrayList<String> res){
        if(i==s.length() || par==4){
            if(i==s.length() && par==4){
                res.add(ans.substring(0,ans.length()-1));
            }
            return;
        }

        helper(s,i+1,par+1,ans+s.charAt(i)+".",res);
        if(i+2<=s.length() && isValid(s.substring(i,i+2))){
            helper(s,i+2,par+1,ans+s.substring(i,i+2)+".",res);
        }
        if(i+3<=s.length() && isValid(s.substring(i,i+3))){
            helper(s,i+3,par+1,ans+s.substring(i,i+3)+".",res);
        }
    }

   static boolean isValid(String s){
        if(s.charAt(0)=='0') return false;
        int val=Integer.parseInt(s);
        return val<=255;
    }
}
