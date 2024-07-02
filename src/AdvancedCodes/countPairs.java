package AdvancedCodes;

import java.util.Arrays;

//Given two positive integer arrays X of size M and Y of size N,
// find the number of pairs such that xy > yx (raised to power of) where x is an element from X
// and y is an element from Y.
public class countPairs {
    static long countPairs(int[] x, int[] y, int M, int N)
    {
        Arrays.sort(x);
        Arrays.sort(y);
        long ans=0;
        for(int ele : x){
            if(ele==1){
                continue;
            }else if(ele==2){
                ans+=N-findUpperBound(y,4);
            }else if(ele==3){
                ans+=occurence(y,2);
                ans+=N-findUpperBound(y,ele);
            }else{
                ans+=N-findUpperBound(y,ele);
            }
        }
        ans+= (long) (M - findUpperBound(x, 1)) * occurence(y,1);
        return ans;
    }

    static int occurence(int[] arr,int x){
        int count=0;
        for(int k : arr){
            if(k==x) count++;
        }
        return count;
    }

    static int findUpperBound(int[] arr,int x){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<=x){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}
