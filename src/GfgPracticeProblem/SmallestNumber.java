package GfgPracticeProblem;
import java.util.*;

public class SmallestNumber {
    //{ Driver Code Starts


   static class GFG {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int tc = sc.nextInt();

            while (tc-- > 0) {
                int s = sc.nextInt();
                int d = sc.nextInt();

                Solution obj = new Solution();
                String res = obj.smallestNumber(s, d);

                System.out.println(res);
            }
        }
    }
    // } Driver Code Ends
    static class Solution {
        public static String smallestNumber(int s, int d) {

            StringBuilder ans=new StringBuilder();

            if(s<1||s>9*d)
                return ""+(-1);
            if(d==1)
                return ""+s;

            for(int i=0;(i<d&&s>0);i++){
                if(s>9){
                    ans.append(9);
                    s=s-9;
                }
                else{
                    if(i<(d-1)){
                        ans.append(s-1);
                        s=1;
                    }
                    else
                    {
                        ans.append(s);
                        s=s-s;
                    }
                }
            }
            return ans.reverse().toString();
        }
    }

}
