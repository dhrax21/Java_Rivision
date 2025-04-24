package HashMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter a character");
//        String str=sc.nextLine();
//        String s=str.replace(" ","");
//        System.out.println(s);
//
//        String[] arr={"1","8","4","6","2"};
//        String temp="";
//        for(String st:arr){
//            temp+=st;
//        }
////        Arrays.sort(arr);
////        System.out.println(Arrays.toString(arr));
//        int num=Integer.parseInt(temp);
//
//        HashMap<Integer,Integer> mp=new HashMap<>();
//        mp.put(null,2);
//        mp.put(1,12);
//
//
//        for(Map.Entry<Integer,Integer> e:mp.entrySet()){
//            System.out.println(e.getKey()+"--->"+e.getValue());
//        }
                    //1,5,11,10,15,6
          int[] arr={1,4,6,-1,5,-9};
          int[] prefix=new int[arr.length];
          int sum=arr[0];
          prefix[0]=sum;
          for(int i=1; i<arr.length;  i++){
              sum+=arr[i];
              prefix[i]=sum;
          }

          for(int i=1; i<arr.length; i++){
              System.out.print(prefix[i]-prefix[i-1]+"\t");
          }
//        System.out.println(Arrays.toString(prefix));
//        System.out.println("[1,5,11,10,15,6]");
    }
}
