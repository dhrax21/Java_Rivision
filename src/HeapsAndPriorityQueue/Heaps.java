package HeapsAndPriorityQueue;

public class Heaps {
    public void sort(int[] arr){
        int length=arr.length;

        //making heap from array
        for(int i=length/2-1; i>=0; i--){
            heapify(arr,length,i);
        }

        //swapping first_index(max element) with last position
        for(int i=length-1; i>=0; i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr,i,0);
        }
    }
    public void heapify(int[] arr,int n,int i){

        int largest=i;
        int left_child=(2*i)+1;
        int right_child=(2*i)+2;

        if(left_child<n && arr[left_child]>arr[largest]){
            largest=left_child;
        }
        if(right_child<n && arr[right_child]>arr[largest]){
            largest=right_child;
        }

        if(largest != i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;


            heapify(arr,n,largest);
        }
    }
}
