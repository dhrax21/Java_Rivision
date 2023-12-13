import java.util.Arrays;

public class Sorting {

    static void insertSort(int[] arr){

        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j>0; j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void selSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int last=arr.length-i-1;
            int maxIndex=maxElementIndex(arr,0,last);
            swap(arr,maxIndex,last);
        }

        System.out.println(Arrays.toString(arr));
    }

    static int maxElementIndex(int[] arr,int start,int end){

         int max=start;

         for(int i=start; i<=end; i++){
             if(arr[max]<arr[i]){
                 max=arr[i];
                 max=i;
             }
         }
         return max;
    }

    static void swap(int[] arr,int first, int second){
        int temp=0;
        temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }


    static void bubbleSort(int[] arr){

        int temp=0;
        boolean swapped;
        for(int i=0; i< arr.length-1; i++) {
            swapped=false;
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }

        }

        System.out.println(Arrays.toString(arr));
    }
}
