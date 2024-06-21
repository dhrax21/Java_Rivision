package AdvancedCodes;

public class MatrixMedian {
    public static void main(String[] args) {
        int[][] mat={{1,3,5},{2,6,9},{3,6,9}};
        System.out.println(median(mat,3,3));

    }
    static int median(int mat[][], int R, int C) {
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;

        for(int i=0; i<R; i++){
            low=Math.min(low,mat[i][0]);
            high=Math.max(high,mat[i][C-1]);
        }

        int req_median=(R*C)/2;
        if(R%2==0 || C%2==0)
            req_median--;

        int ans=high;

        while(low<=high){
            int count=0;
            int mid=(low+(high-low)/2);
            for(int i=0; i<R; i++){
                count+=search(mat[i],mid);
            }
            if(count<=req_median){
                low=mid+1;
            }else{
                high=mid-1;
                ans=Math.min(ans,mid);
            }
        }
        return ans;
    }
    static int search(int[] mat,int x){      //for searching no of values<x
        int lo=0,hi=mat.length-1;
        int ans=-1;
        while(lo<=hi){
            int mid=(lo+(hi-lo)/2);
            if(mat[mid]<=x){
                lo=mid+1;
                ans=Math.max(ans,mid);
            }else{
                hi=mid-1;
            }
        }
        return ans+1;
    }
}
