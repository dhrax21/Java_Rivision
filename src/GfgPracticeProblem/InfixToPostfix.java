package GfgPracticeProblem;

import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }
        public static String infixToPostfix(String exp) {

            StringBuilder ans=new StringBuilder();
            Stack<Character> st=new Stack<>();

            for(char ch : exp.toCharArray()){
                if(Character.isLetterOrDigit(ch)){
                    ans.append(ch);
                }else if(ch=='('){
                    st.push(ch);
                }else if(ch==')'){
                    while(!st.isEmpty() && st.peek() != '('){
                        ans.append(st.pop());
                    }
                    st.pop();
                }else{
                    while(!st.isEmpty() && prec(ch)<=prec(st.peek())){
                        ans.append(st.pop());
                    }
                    st.push(ch);
                }
            }

            while(!st.isEmpty()){
                ans.append(st.pop());
            }
            return ans.toString();
        }
        public static int prec(char ch){
            if(ch=='+' || ch=='-'){
                return 1;
            }else if(ch=='/' || ch=='*'){
                return 2;
            }else if(ch=='^'){
                return 3;
            }else{
                return 0;
            }
        }
}
