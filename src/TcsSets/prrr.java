package TcsSets;

import java.util.ArrayList;
import java.util.Arrays;

public class prrr {
    public static void main(String[] args) {

        ArrayList<Integer> list=new ArrayList<>();

        for(int i=1; i<5; i++){
            list.add(i | 4);
        }

        int[] arr=list.stream().mapToInt(i->i).toArray();
//        System.out.println(Arrays.toString(arr));
//        int max=Arrays.stream(arr).sum();
//        System.out.println(max);

        int n= arr.length;
        ArrayList<ArrayList<Integer>> outer=new ArrayList<>();
         for(int i=0; i<n; i++){
             ArrayList<Integer> in=new ArrayList<>();
             for(int j=i; j<n; j++){
                 in.add(arr[j]);
                 outer.add(new ArrayList<>(in));
             }
         }
        System.out.println(outer);

    }
}
//[5, 6, 7, 4, 5, 6, 7, 12, 13]