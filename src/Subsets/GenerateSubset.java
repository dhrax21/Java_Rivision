package Subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateSubset {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3};



          ArrayList<String> per=new ArrayList<>();
          per=permute("abc","");
          Collections.sort(per);
          System.out.println(per);


    }

//    private static void permute(String given, String ans) {
//        if(given.isEmpty()){
//            System.out.println(ans);
//            return;
//        }
//
//        char ch=given.charAt(0);
//        for(int i=0; i<=ans.length(); i++){
//            String f=ans.substring(0,i);
//            String s=ans.substring(i);
//            permute(given.substring(1),f+ch+s);
//        }
//    }

    private static ArrayList<String> permute(String given, String ans) {
        if(given.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(ans);
            return list;
        }

        ArrayList<String> curr=new ArrayList<>();
        char ch=given.charAt(0);
        for(int i=0; i<=ans.length(); i++){
            String f=ans.substring(0,i);
            String s=ans.substring(i);
            curr.addAll(permute(given.substring(1),f+ch+s));
        }
        return curr;
    }


}
