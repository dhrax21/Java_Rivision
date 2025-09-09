package AdvancedCodes;

import java.util.Stack;
public class BalanceParenthesis {
    public static void main(String[] args) {
    }
        public boolean isBalanced(String s) {
            // code here
            Stack<Character> st=new Stack<>();

            for(char ch : s.toCharArray()){

                if(ch=='(')
                    st.push(')');
                else if(ch=='[')
                    st.push(']');
                else if(ch=='{')
                    st.push('}');
                else
                if(st.isEmpty() || ch != st.pop()){
                    return false;
                }
            }
            return st.isEmpty();
    }
}
