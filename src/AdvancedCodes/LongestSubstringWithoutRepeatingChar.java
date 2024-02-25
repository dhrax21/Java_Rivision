package AdvancedCodes;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {
    static int longestSubstrDistinctChars(String S) {
        int leng = S.length();
        int maxi = -1;

        int left = 0, right = 0;
        Set<Character> hs = new HashSet<>();

        while (right < leng) {
            char ch = S.charAt(right);
            if (!hs.contains(ch)) {
                hs.add(ch);
                maxi = Math.max(maxi, right - left + 1);        //obtaining the size of the window
                right++;
            } else {
                while (ch != S.charAt(left)) {
                    hs.remove(S.charAt(left));             //removing all the chars till repeated one found
                    left++;
                }
                hs.remove(ch);
                left++;
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        int n=longestSubstrDistinctChars("geeksforgeeks");
        System.out.println(n);
    }
}
