package TcsSets;

public class SubsetSum {
    public static void main(String[] args) {
         int N=4;
         int[] arr={1,5,11,5,1};

        System.out.println(partition(N,arr));
    }

    static int partition(int n,int[] arr){
        int totalSum=0;

        for(int l : arr){
            totalSum+=l;
        }

        if(totalSum%2==1) return -1;
        int target=totalSum/2;

        if(solve(0,n,arr,target)){
            return 1;
        }
        return -1;
    }
    static boolean solve(int idx,int n,int[] arr,int tar){
        if(idx>=n) return false;

        if(tar<0) return false;
        if(tar==0) return true;

        boolean incl=solve(idx+1,n,arr,tar-arr[idx]);
        boolean excl=solve(idx+1,n,arr,tar);

        return incl || excl;
    }
}
