package AdvancedCodes;
import java.util.*;
import java.lang.*;
import java.io.*;

public class RearrangeArray {

        public static void rearrange(long arr[], int n){

            int max=10000001;

            int left=0,right=n-1;

            for(int i=0; i<n; i++){
                if(i%2==0){

                    System.out.println((arr[right]%max) * max);
                    arr[i]=((arr[right]%max) * max) + arr[i];
//                    System.out.println(arr[i]);
                    right--;
                }else{
                    System.out.println(((arr[left]%max) * max) + arr[i]);
                    arr[i]=((arr[left]%max) * max) + arr[i];
                    left++;
                }
            }

            for(int i=0; i<n; i++){
                arr[i]=arr[i]/max;
            }
            return;
        }

    public static void main(String[] args) {
            long[] arr={1,2,3,4,5,6};
            System.out.println(Arrays.toString(arr));
            rearrange(arr,arr.length);
            System.out.println(Arrays.toString(arr));
    }
    }
