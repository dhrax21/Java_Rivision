package AdvancedCodes;

import java.util.HashMap;
import java.util.Map;

public class RearrangeCharacters {

    // intuition "aabccb" => "abacbc"
    // we can arrange highest freq character alternate to solve the problem for each characters
    public static String rearrangeCharacters(String str) {

        HashMap<Character,Integer> map=new HashMap<>();
        for(char c : str.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        StringBuilder sb=new StringBuilder(str);
        char ch='a';
        int freq=Integer.MIN_VALUE;

        for(Map.Entry<Character,Integer> e : map.entrySet()){
            if(e.getValue()>freq){
                freq=e.getValue();
                ch=e.getKey();
            }
        }
        int i=0;
        while(freq>0 && i<sb.length()){
            sb.setCharAt(i,ch);
            freq--;
            i+=2;
        }
        if(freq>0){
            return "-1";
        }
        map.remove(ch);

        for(Map.Entry<Character,Integer> e : map.entrySet()){
            int v=e.getValue();
            while(v>0){
                if(i>=sb.length()) i=1;
                sb.setCharAt(i,e.getKey());
                v--;
                i+=2;
            }
        }


        return sb.toString();
    }
}
