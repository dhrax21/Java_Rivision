package TcsSets;

import java.util.Arrays;

public class Practice {

    private void change(int[] num){
        for(int i=0; i<num.length; i++){
            num[i]=2*num[i];
        }
//        System.out.println(Arrays.toString(num));
    }
    public static void main(String[] args) {
        Practice p=new Practice();
        int[] num={1,2,3,4,5};
        System.out.println(Arrays.toString(num));
        p.change(num);
        System.out.println(Arrays.toString(num));
    }
}
