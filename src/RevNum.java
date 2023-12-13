import java.util.Scanner;

public class RevNum {

    static int reverse(int n){
        int rev=0;

        int rem=0;

        while( n!=0){
            rem=n%10;
            n=n/10;

            rev=rev*10 + rem;
        }


        return rev;
    }

    static boolean palDrome(int num){
        if(num<10)
            return true;

        if(reverse(num)==num)
            return true;

        return false;
    }

    static boolean armStrong(int n){

        int temp=n;  // copy the given number

        boolean flag = false;

        int digit=(int)Math.log10(n)+1;  // count total digits in a number

        int rem=0;
        int sum=0;

        while(n>0){
            rem=n%10;
            sum=sum + (int)Math.pow(rem,digit);
            n=n/10;
        }

        if(sum==temp){
            flag=true;
        }

        if(flag){
            return true;
        }
        return false;
    }

}
