package TcsSets;

import java.util.Arrays;

public class EqualSubArrays {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};

        System.out.println(isEqualParts(arr));
    }

    static int isEqualParts(int[] arr){

        int n= arr.length;
        int leftSum= Arrays.stream(arr).sum();

        int rightSum=0;

        for(int i=n-1; i>=0; i--){
            rightSum +=arr[i];
            leftSum-=arr[i];

            if(leftSum==rightSum){
                return i;
            }
        }
        return -1;
    }
}
