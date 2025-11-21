package GraphDataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class CountIsland {

    public static void main(String[] args) {
        char[][] grid={ {1,1},
                        {1,1},
                        {1,1},
                        {1,1}
                      };
        CountIsland c=new CountIsland();
        System.out.println(c.numIslands(grid));
    }
    public void dfs(char[][] map,int r,int c){
        if(r<0 || c<0 || r>=map.length || c>=map[0].length || map[r][c]=='0'){
            return;
        }
        map[r][c]='0';
        dfs(map,r+1,c);
        dfs(map,r-1,c);
        dfs(map,r,c+1);
        dfs(map,r,c-1);
        dfs(map,r+1,c+1);
        dfs(map,r-1,c-1);
        dfs(map,r+1,c-1);
        dfs(map,r-1,c+1);
    }
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)
            return 0;

        int r=grid.length;
        int c=grid[0].length;

        int island=0;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    island++;
                }
            }
        }
        return island;
    }

    private void bfs(char[][] grid, int row,int col,boolean[][] visited){
        int[] dir={0,1,0,-1,0};
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{row,col});
        visited[row][col]=true;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];

            for(int k=0; k<dir.length-1; k++){
                int nr=r+dir[k];
                int nc=c+dir[k+1];

                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='1' &&
                        !visited[nr][nc]){
                    visited[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
}
