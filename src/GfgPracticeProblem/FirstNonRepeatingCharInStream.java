package GfgPracticeProblem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharInStream {
    public String FirstNonRepeating(String S)
    {
        Map<Character,Integer> map=new HashMap<>();
        Queue<Character> q=new LinkedList<>();
        StringBuilder ans=new StringBuilder();

        for(int i=0;i<S.length(); i++){
            char ch=S.charAt(i);
            if(!map.containsKey(ch)){
                q.add(ch);
            }

            map.put(ch,map.getOrDefault(ch,0)+1);

            while(!q.isEmpty() && (map.get(q.peek())>1)){
                q.remove();
            }
            if(!q.isEmpty()){
                ans.append(q.peek());
            }else{
                ans.append('#');
            }
        }
        return ans.toString();
    }
}
