package CodeBeginners;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={5,-4000,3,2,19,109,9};

//        mergeSort(arr,0,arr.length);

//        System.out.println(Arrays.toString(divideInPlace(arr)));
        divideInPlace(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void divideInPlace(int[] arr,int low,int high){

        if(high-low==1) return;

        int mid= (low+high)/2;

        divideInPlace(arr,low,mid);
        divideInPlace(arr,mid,high);

        mergess(arr,low,mid,high);
    }

    static void mergess(int[] arr,int left,int mid,int right){
        int[] res=new int[right-left];
        int i=left,j=mid,k=0;

        while(i< mid && j<right){
            if(arr[i]<arr[j]){
                res[k++]=arr[i++];
            }else{
                res[k++]=arr[j++];
            }
        }
        if(i< mid){
            res[k++]=arr[i++];
        }
        if(j<right){
            res[k++]=arr[j++];
        }

        for(int z=0; z< res.length; z++){
            arr[left+z]=res[z];
        }
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
            arr[si+i]=merged[i];                    //because modifying the original array objects
        }
    }
}
