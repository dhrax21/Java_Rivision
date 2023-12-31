package CodeBeginners;

public class PrimeNumberCheck {
    public static boolean isPrime(int num){

        if(num<=1){
            return false;
        }

        int c=2;
        while(c * c < num ){
            if(num % c*c ==0){
                return false;
            }
            c++;
        }
        return true;
    }
}
