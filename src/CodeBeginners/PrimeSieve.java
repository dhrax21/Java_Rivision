package CodeBeginners;

public class PrimeSieve {
    public static void main(String[] args) {
        int n=20;
        boolean[] prime=new boolean[n+1];
        sieve(n,prime);
    }

    private static void sieve(int n, boolean[] prime) {

        for(int i=2; i*i<=n; i++){
            if(!prime[i]){
                for(int j=i*2; j<=n; j+=i){
                    prime[j]=true;
                }
            }
        }
        for(int i=2; i<=n; i++){
            if(!prime[i]){
                System.out.print(i+"\t");
            }
        }
    }
}
