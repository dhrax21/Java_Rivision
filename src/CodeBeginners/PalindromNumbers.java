package CodeBeginners;
import java.util.Scanner;

public class PalindromNumbers {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a number to check for pallindrome:");
//        int N = sc.nextInt();
//        System.out.println(isPalindrome(N));

//        String ss=sc.next();
        permute("abc","");



    }

    static void permute(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            String ros=str.substring(0,i) + str.substring(i+1);
            permute(ros,ch+ans);
        }
    }


     static boolean isPalindrome(int N){
        int rev=0;
        for(int i=N; i>0; i=i/10){
            rev = rev * 10 + i % 10;
        }

        if(rev==N){
            return true;
        }
        return false;
    }
}
