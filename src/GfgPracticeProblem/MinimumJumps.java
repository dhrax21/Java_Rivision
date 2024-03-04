package GfgPracticeProblem;

public class MinimumJumps {
    public static void main(String[] args) {
        int[] arr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int N= args.length;

        System.out.println(minJumps(arr,N));
    }
    static int minJumps(int[] arr,int N){
        int totalJump=0;
        int dest=arr.length-1;

        int covered=0;
        int lastJumpIdx=0;

        if(arr.length==1){
            return 0;
        }

        for(int i=0; i<arr.length; i++){
            covered=Math.max(covered,i+arr[i]);

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
}
