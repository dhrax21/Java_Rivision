package AdvancedCodes;

public class SudokuSolver {

    public static void main(String[] args) {
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int N = board.length;

        if (SolveSudoku(board))
        {
            // print solution
            printGrid(board);
        }
        else {
            System.out.println("No solution");
        }
    }
    static boolean SolveSudoku(int[][] grid)
    {
        int n=grid.length;
        int row=-1,col=-1;
        boolean isEmpty=true;       // to check if sudoku is solved
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    row=i;
                    col=j;
                    isEmpty=false;
                    break;
                }
            }
            if(!isEmpty)
                break;
        }

        if(isEmpty) return true;

        for(int num=1; num<=9;  num++){
            if(isSafe(grid,row,col,num)){
                grid[row][col]=num;
                if(SolveSudoku(grid))
                    return true;
                else
                    grid[row][col]=0;
            }
        }
        return false;
    }
    static boolean isSafe(int[][] grid,int r,int c,int num){

        //for rows
        for(int i=0;i<grid.length; i++){
            if(grid[i][c]==num) return false;
        }

        //for column
        for(int i=0; i<grid.length; i++){
            if(grid[r][i]==num) return false;
        }

        // for checking individual boxes
        int sqrt=(int)Math.sqrt(grid.length);
        int boxRow=r-(r%sqrt);
        int boxCol=c-(c%sqrt);

        for(int i=boxRow; i<boxRow+sqrt; i++){
            for(int j=boxCol; j<boxCol+sqrt; j++){
                if(grid[i][j]==num) return false;
            }
        }
        return true;
    }

    //Function to print grids of the Sudoku.
    static void printGrid (int[][] grid)
    {
        for(int i = 0 ;i<grid.length;i++){
            for(int j = 0 ;j<grid.length;j++){
                if(i==grid.length-1 && j==grid.length-1){
                    System.out.print(grid[i][j]) ;
                }else{
                    System.out.print(grid[i][j]+" ") ;
                }
            }
            System.out.println();
        }
    }
}
