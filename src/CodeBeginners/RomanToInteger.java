package CodeBeginners;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToDecimal(String str) {
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);


        int result=map.get(str.charAt(0));
        for(int i=1; i<str.length(); i++){
            char ch1=str.charAt(i);
            char ch2=str.charAt(i-1);
            if(map.get(ch1)>map.get(ch2)){      //minus
                result+=(map.get(ch1))-2*map.get(ch2);
            }else{
                result+=map.get(ch1);
            }
        }
        return result;
    }
}
