package GfgPracticeProblem;
import java.io.*;
import java.util.*;
public class Potd_3March {
    //{ Driver Code Start
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){

                int N;
                N = Integer.parseInt(br.readLine());


                String S;
                S = br.readLine();

                Solution obj = new Solution();
                int res = obj.luckyString(N, S);

                System.out.println(res);

            }
        }

    // } Driver Code Ends
   static class Solution {
        static int luckyString(int N, String S) {
            int ans = N + 1;
            for (int i = 0; i < N; i++) {
                int A = 0, B = 0, C = 0;
                for (int j = i; j < N; j++) {
                    if (S.charAt(j) == 'A') {
                        A += 1;
                    } else if (S.charAt(j) == 'B') {
                        B += 1;
                    } else {
                        C += 1;
                    }
                    if (j - i >= 1 && A > B && A > C) {
                        ans = Math.min(ans, j - i + 1);
                    }
                }
            }
            return ans == N + 1 ? -1 : ans;
        }
    }
}
