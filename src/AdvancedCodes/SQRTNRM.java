package AdvancedCodes;

public class SQRTNRM {  //newton raphson method
    public static void main(String[] args) {

        System.out.println(sqrtNRM(40));

    }
    static double sqrtNRM(int n){
        double x=n;
        double root;
        while(true){
            root=0.5 * (x + (n/x));         // formula to guess the sqrt by tukka

            if(Math.abs(root-x)<1){         // if the error is less than 1 it means we have found the answer
                break;
            }
            x=root;                         // assign the guessed root
        }
        return root;
    }

}
