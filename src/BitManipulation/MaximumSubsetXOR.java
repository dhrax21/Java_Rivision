package BitManipulation;

import java.util.Arrays;

public class MaximumSubsetXOR {

    public static void main(String[] args) {
        int[] arr={8,5,2};
        System.out.println(maxSubsetXOR(arr, arr.length));
    }

    // Gausian Elimination technique
    public static int maxSubsetXOR(int[] arr, int N)
    {
        int max= Arrays.stream(arr).max().getAsInt();

        // find set bit from msb
        int msb=31;
        for(int i=31; i>=0; i--){
            int ithBit=(max >> i) & 1;
            if(ithBit==1){
                msb=i;
                break;
            }
        }


// basically modifying the array elements based on msb(which is set)

        int index=0;
        for(int i=msb; i>=0; i--){
            int maxIndex=0;
            int maxEle=Integer.MIN_VALUE;
            for(int j=index; j<N; j++){
                int setBit=(arr[j]>>i) & 1;
                if(setBit != 0 && arr[j]>maxEle){
                    maxEle=arr[j];
                    maxIndex=j;
                }
            }
            if(maxEle==Integer.MIN_VALUE) continue;
            swap(arr,index,maxIndex);

            for(int k=0; k<N; k++){
                if(k==index) continue;
                if(((arr[k]>>i)&1) == 1){
                    arr[k]=arr[k]^arr[index];       //modifying the original array elements
                }
            }
            index++;
        }

        // take xor of all elements
        int ans=0;
        for(int a : arr){
            ans=ans^a;
        }
        return ans;

    }
    public static void swap(int[] arr,int i ,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
