package ArrayListCust;

import java.util.Scanner;

public class SubSetsArray {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int N=sc.nextInt();
//        int[] nums=new int[N];
//        for(int i=0; i<N; i++){
//            nums[i]=sc.nextInt();
//        }
//        subSetBinary(N,nums);
        String str="123";
        powerSet(str,0,"");




    }
    static void powerSet(String str, int index, String curr)
    {

        // base case
        if (index == str.length()) {
            System.out.println(curr);
            return;
        }
        powerSet(str, index + 1, curr + str.charAt(index));
        powerSet(str, index + 1, curr);

    }


    static void subSetBinary(int N,int[] nums){
        System.out.println("Printing Subsets--");

        int totalSubsets=(int)Math.pow(2,N);

        for(int i=0; i<totalSubsets; i++){
            String set="";
            int temp=i;
            for(int j=N-1; j>=0; j--){
                int rem=temp % 2;
                temp=temp/2;
                if(rem==0){
                    set="-\t"+set;
                }else{
                    set=nums[j]+"\t"+set;
                }
            }
            System.out.println(set);
        }
    }

}
