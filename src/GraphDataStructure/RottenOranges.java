package GraphDataStructure;
import java.util.LinkedList;

public class RottenOranges {

    class Pair{
        int row;
        int col;

        Pair(int r,int c){
            this.row=r;
            this.col=c;
        }
    }
    public int orangesRotting(int[][] grid)
    {
        int r=grid.length;
        int c=grid[0].length;
        int level=-1;
        int fresh=0;

        LinkedList<Pair> q=new LinkedList<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j]==2){                  //rotten orange position
                    q.addLast(new Pair(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
            int[] dx={-1,1,0,0};
            int[] dy={0,0,-1,1};


        while(!q.isEmpty()){
            int size=q.size();
            level++;
            while(size-->0){
                Pair curr=q.removeFirst();

                for(int i=0; i<4; i++){
                    int rdash=curr.row+dx[i];
                    int cdash=curr.col+dy[i];
                    if(rdash>=0 && cdash>=0 && rdash<r && cdash<c && grid[rdash][cdash]==1){
                        q.addLast(new Pair(rdash,cdash));
                        grid[rdash][cdash]=0;
                        fresh--;
                    }
                }
            }
        }

        if(fresh==0){
            return level;
        }else{
            return -1;
        }


    }
}
