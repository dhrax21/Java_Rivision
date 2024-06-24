package GfgPracticeProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class _4Sum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>>  res=new ArrayList<>();

        Arrays.sort(arr);
        int left=0,right=0;
        int n=arr.length;
        int sum=0;

        for(int i=0; i<n-3; i++){

            //if duplicates then skip
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1; j<n-2; j++){

                //if duplicates then skip
                if(j>i+1 && arr[j]==arr[j-1]) continue;
                left=j+1;
                right=n-1;
                while(left<right){
                    sum=arr[i];
                    sum+=arr[j];
                    sum+=arr[left];
                    sum+=arr[right];
                    if(sum==k){
                        ArrayList<Integer> list=new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[left]);
                        list.add(arr[right]);
                        res.add(list);
                        left++;
                        right--;

                        //for duplicates
                        while(left<right && arr[left]==arr[left-1]) left++;
                        while(left<right && arr[right]==arr[right+1]) right--;

                    }else if(sum<k){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
