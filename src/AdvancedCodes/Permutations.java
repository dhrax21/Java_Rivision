package AdvancedCodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {
    public static void main(String[] args) {
//        permute("","xyz");
//          permuteGFG("abc","");
        permutationTrick("XYZ");
    }


    static void permutationTrick(String s) {
        int n = s.length();
        int f = fact(n);

        for (int i = 0; i < f; i++) {
            StringBuilder sb = new StringBuilder(s);
            int temp = i;

            for (int div = n; div >= 1; div--) {
                int q = temp / div;
                int r = temp % div;

                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp = q;
            }
            System.out.println();
        }
    }

    static int fact(int n) {
        int val = 1;

        for (int i = 2; i <= n; i++) {
            val *= i;
        }
        return val;
    }

    static void permuteGFG(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String ros = s.substring(0, i) + s.substring(i + 1);
            permuteGFG(ros, ans + ch);
        }
    }

    static void perumuteNumsArrays(int[] arr, int start, List<List<Integer>> result) {
        if (start == arr.length) {
            List<Integer> curr = new ArrayList<>();
            for (int num : arr) {
                curr.add(num);
            }
            result.add(curr);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            perumuteNumsArrays(arr, start + 1, result);
            //backtrack undo the swap
            swap(arr, start, i);
        }

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> que = new LinkedList<>();

        que.add(new ArrayList<>());     //add an empty arraylist

        for (int num : nums) {
            int size = que.size();

            while (size-- > 0) {
                List<Integer> curr = que.poll();    //remove list from queue to perform bfs

                for (int i = 0; i <= curr.size(); i++) {
                    List<Integer> perm = new ArrayList<>(curr); // copy the list and add new element and then add to the que
                    perm.add(i, num);
                    que.add(perm);
                }
            }
        }
        result.addAll(que);
        return result;
    }
}
