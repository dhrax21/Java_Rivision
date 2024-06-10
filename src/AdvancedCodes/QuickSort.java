package AdvancedCodes;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={7,6,10,5,9,2,11,55,7};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

        private static void quickSort(int[] arr, int low, int high) {
            if(low>=high){
                return;
            }

            int start=low;
            int end=high;
            int mid=low+(high-low)/2;
            int pivot=arr[mid];

            while(start<=end){
                while(arr[start]<pivot){
                    start++;
                }
                while(arr[end]>pivot){
                    end--;
                }

                if(start<=end){
                    int temp=arr[start];
                    arr[start]=arr[end];
                    arr[end]=temp;
                    start++;
                    end--;
                }
            }
            quickSort(arr,low,end);
            quickSort(arr,start,high);
    }

}
