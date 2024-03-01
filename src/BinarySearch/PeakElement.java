package BinarySearch;

public class PeakElement {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,3,1,3};
        PeakElement p=new PeakElement();
       int ans= p.peakElement(arr,arr.length);
        System.out.println(ans);
    }
    public int peakElement(int[] arr,int n)
    {
        return helper(arr,0,n-1,n);
    }
    public int helper(int[] arr,int low,int high,int n){
        int mid=low+(high-low)/2;

        if((mid==0 || arr[mid-1]<=arr[mid]) && (mid==n-1 || arr[mid]>=arr[mid+1])){
            return mid;
        }
        else if(mid>0 && arr[mid-1]>arr[mid]){
            return helper(arr,low,mid-1,n);
        }else{
            return helper(arr,mid+1,high,n);
        }
    }
}
