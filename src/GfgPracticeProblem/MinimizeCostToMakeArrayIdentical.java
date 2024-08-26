package GfgPracticeProblem;

import java.util.*;

// n=4
// A[] = {1,2,2,2};
// B[] = {1,2,4,4};
//output = 2
// to make the array identical swap the A4 and B4 to make similar
public class MinimizeCostToMakeArrayIdentical {
    public long minCost(int n, int[] a, int[] b) {
        Set<Integer> ele = new HashSet<>();
        Map<Integer, Integer> fa = new HashMap<>();
        Map<Integer, Integer> fb = new HashMap<>();

        for (int i = 0; i < n; i++) {
            ele.add(a[i]);
            ele.add(b[i]);
            fa.put(a[i], fa.getOrDefault(a[i], 0) + 1);
            fb.put(b[i], fb.getOrDefault(b[i], 0) + 1);
        }

        List<Integer> operations = new ArrayList<>();
        for (int e : ele) {
            int x = fa.getOrDefault(e, 0);
            int y = fb.getOrDefault(e, 0);
            int diff = Math.abs(x - y);

            if (diff % 2 != 0) {
                return -1;
            }

            for (int i = 0; i < diff / 2; i++) {
                operations.add(e);
            }
        }

        Collections.sort(operations);
        long ans = 0;
        for (int i = 0; i < operations.size() / 2; i++) {
            ans += operations.get(i);
        }
        return ans;
    }
}
