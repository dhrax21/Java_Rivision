package GfgPracticeProblem;

import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {
        String str="231*+9-";
        System.out.println(evaluatePostFix(str));
    }

    public static int evaluatePostFix(String S)
    {
        Stack<Integer> st=new Stack<>();

        int op1,op2;

        for(char ch : S.toCharArray()){
            if(Character.isDigit(ch)){
                st.push(ch-'0');
            }else{
                op1=st.pop();
                op2=st.pop();

                switch(ch){
                    case '+' : st.push(op1+op2);
                        break;
                    case '-' : st.push(op2-op1);
                        break;
                    case '/' : st.push(op2/op1);
                        break;
                    case '*' : st.push(op1*op2);
                        break;
                    default : break;
                }
            }
        }
        return st.peek();
    }

    public static int evaluatePreFix(String string)
    {
        StringBuilder sb=new StringBuilder(string);
        sb.reverse();
        String S=sb.toString();
        Stack<Integer> st=new Stack<>();

        int op1,op2;

        for(char ch : S.toCharArray()){
            if(Character.isDigit(ch)){
                st.push(ch-'0');
            }else{
                op1=st.pop();
                op2=st.pop();

                switch(ch){
                    case '+' : st.push(op1+op2);
                        break;
                    case '-' : st.push(op1-op2);
                        break;
                    case '/' : st.push(op1/op2);
                        break;
                    case '*' : st.push(op1*op2);
                        break;
                    default : break;
                }
            }
        }
        return st.peek();
    }
}
