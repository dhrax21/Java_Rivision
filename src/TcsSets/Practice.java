package TcsSets;

import java.util.Arrays;

public class Practice {

    private static int secondSmallest(int[] arr){
        int smallest=Integer.MAX_VALUE;
        int secondSmallest=Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i]<smallest){
                secondSmallest=smallest;
                smallest=arr[i];
            }else if(arr[i]>smallest && arr[i]<secondSmallest){
                secondSmallest=arr[i];
            }
        }
        return secondSmallest;
    }

    public static void main(String[] args) {
        Practice p=new Practice();
        int[] num={10,20,30,40,5};
//        System.out.println(Arrays.toString(num));
        System.out.println(secondSmallest(num));

    }
}
