package AdvancedCodes;

public class GCD {
    public static void main(String[] args) {
        int ans=computeGCD(32,8);
        System.out.println(ans);
//        System.out.println(lcm(9,108));
    }

    private static int computeGCD(int a, int b) {

        if(a==0)
            return b;

        return computeGCD(b%a,a);
    }
    private static int lcm(int a,int b){
        return a*b/computeGCD(a,b);
    }

}
