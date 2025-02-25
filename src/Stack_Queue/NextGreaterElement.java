package Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
//        int[] arr={1,3,2,1,8,6,3,4};
        int[] nums={2,1,5,6,2,3};
        System.out.println(Arrays.toString(nse(nums)));
//        int[] stocks={21473,14891,26474,2116};
//        System.out.println(Arrays.toString(nge(arr)));
//        System.out.println(Arrays.toString(stockspan(stocks)));
    }

    private static int[] stockspan(int[] stocks) {
        Stack<Integer> st=new Stack<>();
        int N=stocks.length;
        int[] prev=new int[N];
        prev[0]=1;
        st.push(0);// putting indices

        for(int i=1; i<N; i++){
            while(!st.isEmpty() && stocks[i]>stocks[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                prev[i]=i+1;
            }else{
                prev[i]=i-st.peek();
            }
            st.push(i);
        }
        return prev;
    }

    private static int[] nge(int[] arr) {
        int N=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] res=new int[arr.length];
        st.push(arr[N-1]);
        res[N-1]=-1;

        for(int i=N-2; i>=0; i--){
            while(!st.isEmpty() && arr[i]>st.peek()){
                st.pop();
            }
            if(st.isEmpty())
                res[i]=-1;
            else{
                res[i]=st.peek();
            }
            st.push(arr[i]);
        }
        return res;
    }

    private static int[] nse(int[] arr){    //next smaller element
        Stack<Integer> st=new Stack<>();
        int N=arr.length;
        int[] nese=new int[N];

        nese[N-1]=-1;
        st.push(N-1);

        for(int i=N-2; i>=0; i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) nese[i]=-1;
            else
                nese[i]=st.peek();
            st.push(i);
        }
        return nese;
    }
}
