package Subsets;

import java.util.Scanner;

public class SubsetsArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int[] arr=new int[N];

        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }


        subsetss(arr,N);
    }
    static void subsetss(int[] arr,int N){
        int limit=(int)Math.pow(2,N);

        for(int i=0; i<limit; i++){
            String set="";
            int temp=i;

            for(int j=N-1; j>=0; j--){
                int rem=temp%2;
                temp=temp/2;

                if(rem==0){
                   set="-\t"+set;
                }else{
                    set=arr[j]+"\t"+set;
                }
            }
            System.out.println(set);
        }
    }
}
