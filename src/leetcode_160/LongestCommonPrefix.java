package leetcode_160;

import java.util.*;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        return Arrays.stream(strs)
                .reduce((a, b) -> {
                    int i = 0;
                    while (i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i))
                        i++;
                    return a.substring(0, i);
                })
                .orElse("");
    }

    public static void main(String[] args) {
        String[] arr = {"interview", "internet", "internal", "interval"};
        System.out.println(longestCommonPrefix(arr)); // "inte"
    }
}
//💡 How it works:
//        Arrays.stream(strs) → converts the array to a stream.
//
//        .reduce((a, b) -> …) → successively compares two strings at a time, keeping the common prefix.
//
//        .orElse("") → returns "" if the array was empty.