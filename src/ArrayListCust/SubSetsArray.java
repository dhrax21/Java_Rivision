package ArrayListCust;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubSetsArray {
    public static void main(String[] args) {
        int N = 3;
        int[] nums = {1, 2, 3};

//        subSetBinary(N,nums);
////        String str="123";
////        powerSet(str,0,"");

        subStringsPrint("10101", new ArrayList<>());
    }

    static void subStringsPrint(String s, List<String> sets) {

        for (int i = 0; i < s.length(); i++) {
            String sub = "";
            for (int j = i; j < s.length(); j++) {
                sub += s.charAt(j);
                sets.add(sub);
                System.out.print(sub + " ");
            }
            System.out.println();
        }
    }
}
//    static void powerSet(String str, int index, String curr)
//    {
//
//        // base case
//        if (index == str.length()) {
//            System.out.println(curr);
//            return;
//        }
//        powerSet(str, index + 1, curr + str.charAt(index));
//        powerSet(str, index + 1, curr);
//
//    }


//    static void subSetBinary(int N,int[] nums){
//        System.out.println("Printing Subsets--");
//
//        int totalSubsets=(int)Math.pow(2,N);
//
//        for(int i=0; i<totalSubsets; i++){
//            String set="";
//            int temp=i;
//            for(int j=N-1; j>=0; j--){
//                int rem=temp % 2;
//                temp=temp/2;
//                if(rem==0){
//                    set="-\t"+set;
//                }else{
//                    set=nums[j]+"\t"+set;
//                }
//            }
//            System.out.println(set);
//        }
//    }

