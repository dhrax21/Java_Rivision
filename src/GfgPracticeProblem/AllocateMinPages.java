package GfgPracticeProblem;

import java.util.Arrays;

public class AllocateMinPages {


    // to find max Element from Array use : ->   int max=Arrays.stream(A).max().getAsInt()
    public static int findPages(int[]A,int N,int M)
    {
        if(M>N) return -1;
        int low=1;
        int high= Arrays.stream(A).sum();
        int mid=0;
        int res=0;
        while(low <= high){
            mid=low+(high-low)/2;
            if(isPossible(A,N,M,mid)){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
    static boolean isPossible(int[] A,int N,int M,int maxPages){
        int count=1;
        int sum=0;
        for(int i=0; i<N; i++){

            if(A[i]>maxPages) return false;
            sum+=A[i];
            if(sum>maxPages){
                count++;
                i--;
                sum=0;
            }
        }
        if(count>M) return false;

        return true;
    }
}
