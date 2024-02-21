package HeapsAndPriorityQueue;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Heaps heap=new Heaps();
        int[] arr={22,13,17,11,10};
        heap.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
