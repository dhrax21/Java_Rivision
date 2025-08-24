package AdvancedCodes;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInGivenString {
    static String reverseWords(String S)
    {
        List<Integer> list=new ArrayList<>(); //storing the '.' indices;
        list.add(0);
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='.'){
                list.add(i);
            }
        }
        list.add(S.length());
        StringBuilder ans=new StringBuilder();
        for(int i=list.size()-2; i>0; i--){
            ans.append(S.substring(list.get(i)+1,list.get(i+1)));
            ans.append(".");
        }
        ans.append(S.substring(list.get(0),list.get(1)));
        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "i.like.this.program.very.much";
        System.out.println(reverseWords(str));
    }
}
