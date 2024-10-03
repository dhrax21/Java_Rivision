package ArrayListCust;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows\t");
        int N = sc.nextInt();
        System.out.println("Your Pascal's Triangle is:\n");
        List<List<Integer>> res = new ArrayList<>();
        System.out.println(printTri(N));
//

    }

   static List<List<Integer>> printTri(int N) {

       List<List<Integer>> res=new ArrayList<>();
        List<Integer> row, pre = null;

        for (int i = 0; i < N; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else {
                    assert pre != null;
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = row;
            res.add(row);
        }
        return res;
    }
}
