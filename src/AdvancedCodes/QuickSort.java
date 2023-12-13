package AdvancedCodes;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={5,4,8,3,1,6,-87,6};
        qSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    static void qSort(int[] arr, int low, int hi){
        if(low>=hi){
            return;
        }

        int s=low;
        int end=hi;

        int mid=s+(end-s)/2;

        int pivot=arr[mid];

        while(s<=end){
            while(arr[s]<pivot){
                s++;
            }

            while(arr[end]>pivot){
                end--;
            }

            if(s<=end){
                int temp=arr[s];
                arr[s]=arr[end];
                arr[end]=temp;
                s++;
                end--;
            }

        }

        qSort(arr,low,end);
        qSort(arr,s,hi);
    }

}
