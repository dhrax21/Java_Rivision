package BinarySearch;

public class SecondHighestElement {
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
