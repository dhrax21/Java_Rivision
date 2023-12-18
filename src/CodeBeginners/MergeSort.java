package CodeBeginners;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={5,4,9,1};

        mergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int si, int ei) {

            if(ei-si==1){
                return;
            }
            int mid=si+(ei-si)/2;

            mergeSort(arr,si,mid);
            mergeSort(arr,mid,ei);

            conquer(arr,si,mid,ei);
    }

    private static void conquer(int[] arr, int si, int mid, int ei) {

        int[] merged=new int[ei-si];

        int idx1=si; int idx2=mid; int k=0;

        while(idx1<mid && idx2<ei){
            if(arr[idx1]<arr[idx2]){
                merged[k++]=arr[idx1++];
            }else{
                merged[k++]=arr[idx2++];
            }
        }

        while(idx1<mid){
            merged[k++]=arr[idx1++];
        }
        while(idx2<ei){
            merged[k++]=arr[idx2++];
        }

        //copying the sorted array in main given array
        for(int i=0; i< merged.length; i++){
            arr[si+i]=merged[i];                    //bcos modifying the original array objects
        }
    }
}
