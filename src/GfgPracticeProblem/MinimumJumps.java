package GfgPracticeProblem;

public class MinimumJumps {
    public static void main(String[] args) {
        int[] arr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int N= arr.length;

        System.out.println(minJumps(arr,N));

//        System.out.println(canReach(arr,N));
    }
    static int minJumps(int[] arr,int N){
        int totalJump=0;
        int dest=arr.length-1;

        int covered=0;
        int lastJumpIdx=0;


        for(int i=0; i<arr.length; i++){
            covered=Math.max(covered,i+arr[i]); //calculating indices 

            if(i==lastJumpIdx){
                lastJumpIdx=covered;
                totalJump++;

                if(covered>=dest){
                    return totalJump;
                }
            }

        }
        return -1;
    }
    static int canReach(int[] A, int N) {
        // code here

        if(N==0 || N==1) return 1;

        int jumps=0;

        for(int i=0; i<=jumps; i++){
            jumps=Math.max(jumps,i+A[i]);
            if(i>=N-1)
                return 1;
        }
        return 0;

    }
}
