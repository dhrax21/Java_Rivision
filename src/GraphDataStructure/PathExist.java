package GraphDataStructure;


//Given a grid of size n*n filled with 0, 1, 2, 3. Check whether there is a path possible from the source to destination. You can traverse up, down, right and left.
//        The description of cells is as follows:
//
//        A value of cell 1 means Source.
//        A value of cell 2 means Destination.
//        A value of cell 3 means Blank cell.
//        A value of cell 0 means Wall (blocked cell which we cannot traverse).
//        Note: There are only a single source and a single destination.
public class PathExist {
    public boolean is_Possible(int[][] grid) {

        int n = grid.length;

        boolean[][] vis = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    return findPath(grid, i, j, vis);
                }
            }
        }
        return false;
    }


    // dfs approach
    boolean findPath(int[][] grid, int i, int j, boolean[][] vis) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || vis[i][j] || grid[i][j] == 0) {
            return false;
        }


        if (grid[i][j] == 2)
            return true;


        vis[i][j] = true;

        boolean d1 = findPath(grid, i + 1, j, vis);
        boolean d2 = findPath(grid, i, j + 1, vis);
        boolean d3 = findPath(grid, i - 1, j, vis);
        boolean d4 = findPath(grid, i, j - 1, vis);

        return d1 || d2 || d3 || d4;
    }
}
