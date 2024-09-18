package CodeBeginners;

import java.util.LinkedList;
import java.util.Queue;


// We are given two array [arr,brr] of size n ,both are rotations of each other we need to perform two operations
//: Rotate the array anticlockwise [arr]
//: Remove the first element of both the arrays if they are same
public class MinOps {

    public static void main(String[] args) {
        int[] arr={1,2,3};
        int[] brr={2,1,3};


        int n=arr.length;

        System.out.println(min_operations(n,arr,brr));
    }
    public static int min_operations(int n, int[] arr, int[] brr) {
        // code here
        Queue<Integer> q=new LinkedList<>();
        for(int i : arr){
            q.add(i);
        }
        int i=0;
        int ans=0;
        while(i<n){
            int y=q.remove();
            if(y==brr[i]){
                i++;
            }
            else{
                q.add(y);
            }
            ans++;
        }
        return ans;
    }
}
