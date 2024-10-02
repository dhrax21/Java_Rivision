package HashMaps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class SubArrays {
    static ArrayList<ArrayList<Integer>> fein=new ArrayList<>();
    public static void main(String[] args) {
        int[] arr={1,2,4,5};
        ArrayList<Integer> res=new ArrayList<>();
//        generateSubArray(arr,0,res);
//        genSubArrayLoop(arr);

         genSubSet(arr,0,res);
        Collections.sort(fein, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return -(o2.size()-o1.size());
            }
        });
        System.out.println(fein.size());
        System.out.println(fein);

    }

    private static void generateSubArray(int[] arr, int start, ArrayList<Integer> res) {
        if(start>=arr.length) return;

        for(int i=start; i<arr.length; i++){
            res.add(arr[i]);
            System.out.println(res);
            generateSubArray(arr,i+1,res);
            res.remove(res.size()-1);
        }

    }
    private static void genSubArrayLoop(int[] arr){
        for(int i=0; i<arr.length; i++){
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=i; j<arr.length; j++){
                list.add(arr[j]);
                System.out.println(list);
            }

        }
    }

    private static void genSubSet(int[] arr,int start,ArrayList<Integer> res){
        if(start==arr.length){
            fein.add(new ArrayList<>(res));
//            System.out.println(res);
            return;
        }

        genSubSet(arr,start+1,res);
        res.add(arr[start]);
        genSubSet(arr,start+1,res);
        res.remove(res.size()-1);
    }
}
//        1
//        1 2
//        1 2 3
//        1 2 3 4
//        2
//        2 3
//        2 3 4
//        3
//        3 4
//        4