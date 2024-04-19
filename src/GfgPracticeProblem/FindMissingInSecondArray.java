package GfgPracticeProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMissingInSecondArray {

//
//    Input :
//    n = 5, m = 5
//    a[] = {4, 3, 5, 9, 11}
//    b[] = {4, 9, 3, 11, 10}
//
//    Output :
//            5
//    Explanation:
//    Second array does not contain element 5
    ArrayList<Integer> findMissing(int a[], int b[], int n, int m)
    {
        Arrays.sort(b);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : a){
            int low=0, high=m-1;
            boolean f = true;
            while(low<=high){
                int mid = low + (high-low)/2;
                if(b[mid]==i){
                    f = false;
                    break;
                }else if(b[mid]<i){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
            if(f)   list.add(i);
        }
        return list;
    }
}
