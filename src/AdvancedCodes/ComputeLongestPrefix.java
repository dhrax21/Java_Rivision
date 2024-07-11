package AdvancedCodes;

import java.util.ArrayList;
import java.util.Arrays;

public class ComputeLongestPrefix {
    public static void main(String[] args) {

        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        int pattLen = pattern.length();
        int[] lps = new int[pattLen];

        computeLPSArray(pattern,lps);

    }
                            //    ABABCABAB
       static void computeLPSArray(String pat, int[] lps) {
            int patternLen = pat.length();
            int len = 0; // Length of the previous longest prefix suffix
            lps[0] = 0; // lps[0] is always 0
            int i = 1;
            while (i < patternLen) {
                if (pat.charAt(i) == pat.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                } else {
                    if (len != 0) {
                        len = lps[len - 1];
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }

           System.out.println(Arrays.toString(lps));
        }
}
