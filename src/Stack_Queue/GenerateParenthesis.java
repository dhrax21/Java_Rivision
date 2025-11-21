package Stack_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
    private class State{
        String curr;
        int open,close;

        State(String s,int o,int c){
            this.curr=s;
            this.open=o;
            this.close=c;
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        Stack<State> stack=new Stack<>();

        stack.push(new State("",0,0));

        while(!stack.isEmpty()){
            State s=stack.pop();

            if(s.curr.length()==2*n){
                ans.add(s.curr);
                continue;
            }

            if(s.open<n){
                stack.push(new State(s.curr+"(",s.open+1,s.close));
            }
            if(s.close<s.open){
                stack.push(new State(s.curr+")",s.open,s.close+1));
            }
        }
        return ans;
    }
}
