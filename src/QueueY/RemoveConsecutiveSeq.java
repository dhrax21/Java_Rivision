package QueueY;

import java.util.Stack;

public class RemoveConsecutiveSeq {
    public static void main(String[] args) {
        String str="aabbcccddefffzl";

        String ans=remove(str);
        System.out.println(ans);
    }
    static String remove(String s){
        Stack<Character> st=new Stack<>();
        String ans="";
        for(int i=0; i<s.length(); i++){

            char ch=s.charAt(i);
            if(st.isEmpty() || st.peek()!=ch){
                st.push(ch);
            }else if(st.peek()==ch){
                if(i==s.length()-1 || ch != s.charAt(i+1))
                    st.pop();
            }
        }

        while(st.size()>0){
            ans+=st.pop();
        }
        StringBuilder sb=new StringBuilder(ans);
        sb.reverse();
        return sb.toString();
    }
}
