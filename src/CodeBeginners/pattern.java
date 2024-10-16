package CodeBeginners;

import java.util.Arrays;
import java.util.List;

public class pattern {
    public static void main(String[] args) {


        int[] arr = {4, 3, 2, 1};
        System.out.println(checkSorted(Arrays.asList(4, 3, 2, 1)));
    }

    static void diam(int n) {
        for (int i = 0; i < 2 * n; i++) {
            int cols = i > n ? 2 * n - i : i;
            for (int s = 0; s < n - cols; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j < cols; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printTri(int rows, int col) {
        if (rows == 0) {
            return;
        }
        if (col < rows) {
            printTri(rows, col + 1);
            System.out.print("* ");

        } else {
            printTri(rows - 1, 0);
            System.out.println();
        }
    }


    static boolean checkSorted(List<Integer> arr) {
        int sc = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (i + 1 != arr.get(i)) {
                int temp = arr.get(i);
                arr.set(i, arr.get(arr.get(i) - 1));
                arr.set(temp - 1, temp);
                sc++;
            }
            System.out.println(arr);
            if (i + 1 != arr.get(i))
                i--;
            if (sc > 2)
                return false;
        }
        return true;
    }

}