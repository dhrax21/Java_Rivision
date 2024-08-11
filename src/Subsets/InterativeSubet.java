package Subsets;

import java.util.ArrayList;
import java.util.List;

public class InterativeSubet {

    public static void main(String[] args) {
        int[] arr={5,6,7};

        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int num : arr){

            int size= outer.size();

            for(int i=0; i<size; i++){
                List<Integer> inner=new ArrayList<>(outer.get(i));

                inner.add(num);
                outer.add(inner);
            }

        }

        System.out.println(outer);
    }




}
