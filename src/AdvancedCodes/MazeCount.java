package AdvancedCodes;

public class MazeCount {
    public static void main(String[] args) {
        int m=4,n=4;
        System.out.println(countMazePaths(m,n));
    }

    private static int countMazePaths(int m, int n) {
        return countTotal(0,0,m,n);
    }

    private static int countTotal(int i, int j, int m, int n) {

        if(i==m || j==n){
            return 0;
        }

        if(i==m-1 && j==n-1){
            return 1;
        }

        int rightDir=countTotal(i,j+1,m,n);
        int leftDir=countTotal(i+1,j,m,n);

        return rightDir+leftDir;
    }
}
