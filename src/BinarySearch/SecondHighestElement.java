package BinarySearch;

public class SecondHighestElement {

    public static void main(String[] args) {

        int[] arr={1,3,45,12,55,31,122,455};

        SecondHighestElement s=new SecondHighestElement();
        int ans=s.print2largest(arr,arr.length);
        System.out.println(ans);
    }
    int print2largest(int arr[], int n) {
        int large=-1;
        int secondLarge=-1;

        for(int i=0;  i<n; i++){
            if(arr[i]>large){
                secondLarge=large;
                large=arr[i];
            }
            else if(arr[i] != large && arr[i]>secondLarge){
                secondLarge=arr[i];
            }
        }
        return secondLarge;
    }
}
