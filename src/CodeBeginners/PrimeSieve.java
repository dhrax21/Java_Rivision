package CodeBeginners;

import java.util.Arrays;

public class PrimeSieve {
    public static void main(String[] args) {
        int n=20;
        boolean[] prime=new boolean[n+1];
        sieve(n,prime);
    }

    private static void sieve(int n, boolean[] prime) {

            boolean[] isPrime=new boolean[n+1];
            Arrays.fill(isPrime,true);

            isPrime[0]=false;   // as these are not prime numbers
            isPrime[1]=false;

            for(int p=2; p*p<=n; p++){
                //if isPrime[p] is true is prime so make all multiples of it as false
                if(isPrime[p]){
                    for(int multiple=p*p; multiple<=n; multiple+=p){
                        isPrime[multiple]=false;
                    }
                }
            }

            //print all prime numbers

        for(int i=2; i<isPrime.length; i++){
            System.out.print(isPrime[i]==true ? i : "\t");
        }
    }
}
