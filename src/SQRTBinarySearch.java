public class SQRTBinarySearch {
    public static void main(String[] args) {
        int n=40;
        int pre=3;  //precision

        System.out.printf("%.3f",sqrt(n,pre));
    }
    static double sqrt(int n,int pre){
        double root=0.0;

        int start=0,end=n;
        while(start<=end){
            int mid=(start+end)/2;

            if(mid*mid==n){
                return mid;
            }

            if(mid*mid>n){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        double incr=0.1;

        for(int i=0; i<pre; i++){
            while(root * root <= n ){
                root += incr;
            }
            root-=incr;
            incr/=10;           // it means (0.1) -> (0.01) -> (0.001) ... till the precision
        }


        return root;
    }
}
