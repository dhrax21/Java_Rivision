package BitManipulation;

public class CountFlipBits {
  static   class Solution{

      public static void main(String[] args) {
          int A=10,B=20;
          System.out.println(countBitsFlip(A,B));
      }

        // Function to find number of bits needed to be flipped to convert A to B
        public static int countBitsFlip(int a, int b){

            int temp=a^b;
            int cnt=0;

            while(temp > 0 ){
                if(temp % 2==1)
                    cnt++;
                temp>>=1;           //number (temp) divided by 2
            }
            return cnt;
        }


    }
}
