package DP;

import java.util.Arrays;

public class CoinChangeCombination {
    public static void main(String[] args) {
        int[] coins={2,3,5};
        int tar=7;

        int[] amt=new int[tar+1];
        amt[0]=1;

        for(int i=0; i<coins.length; i++){
            for(int j=coins[i]; j<amt.length; j++){
                amt[j] += amt[j-coins[i]];
            }
        }
        System.out.println(Arrays.toString(amt)) ;
//        System.out.println(amt[tar]);
    }
}
