package GraphDataStructure;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestSourceToDestination {
    static class Pair{
        int i;
        int j;
        int step;

        Pair(int i,int j,int s){
            this.i=i;
            this.j=j;
            this.step=s;
        }
    }
    int shortestDistance(int N, int M, int A[][], int X, int Y) {

        if(A[0][0]==0 || A[X][Y]==0)
            return -1;


        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(0,0,0));

        boolean[][] vis=new boolean[N][M];
        vis[0][0]=true;

        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};


        //bfs breadth first search multi source
        while(!q.isEmpty()){
            Pair temp=q.poll();

            if(temp.i==X && temp.j==Y){
                return temp.step;
            }

            for(int i=0; i<4; i++){
                int nR=temp.i+dx[i];
                int nC=temp.j+dy[i];

                while(nR>=0 && nC>=0 && nR<N && nC<M && A[nR][nC] != 0 && !vis[nR][nC]){
                    q.add(new Pair(nR,nC,temp.step+1));
                    vis[nR][nC]=true;
                }
            }
        }
        return -1;
    }
};

//        N=3, M=4
//        A=[[1,0,0,0],
//           [1,1,0,1],
//           [0,1,1,1]]
//        X=2, Y=3
//        Output:
//        5
//        Explanation:
//        The shortest path is as follows:
//        (0,0)->(1,0)->(1,1)->(2,1)->(2,2)->(2,3).
