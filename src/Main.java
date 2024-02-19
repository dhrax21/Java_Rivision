import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr={5,4,9,9,2,4,1};

        mergesSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergesSort(int[] arr, int si, int ei) {
        if(ei-si==1)
            return;

        int mid=si+(ei-si)/2;
        
        mergesSort(arr,si,mid);
        mergesSort(arr,mid,ei);

        merge(arr,si,mid,ei);
    }

    private static void merge(int[] arr, int si, int mid, int ei) {
        int[] newArr=new int[ei-si];
        int i=si,j=mid,k=0;

        while(i<mid && j<ei){
            if(arr[i]<arr[j]){
                newArr[k++]=arr[i++];
            }else{
                newArr[k++]=arr[j++];
            }
        }

        while(i<mid){
            newArr[k++]=arr[i++];
        }
        while(j<ei){
            newArr[k++]=arr[j++];
        }

        for(int z=0; z< newArr.length; z++){
            arr[si+z]=newArr[z];                    //bcos modifying the original array objects
        }
    }

}
