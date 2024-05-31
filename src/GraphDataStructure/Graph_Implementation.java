package GraphDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_Implementation {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "src=" + src +
                    ", dest=" + dest +
                    '}';
        }
    }

  static void createGraph(ArrayList<Edge>[] graph){     //adjacency list , undirected , unweighted graph
        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<Edge>();
        }
        //--------------------graph containing cycle

        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,4));

//       -----------------------------------------



    }

   static void printGraph(ArrayList<Edge>[] graph)
      {
          for (ArrayList<Edge> edges : graph) {
              System.out.println(edges.toString() + "/");
          }
        }

    static void bfs(ArrayList<Edge>[] graph,int V){

        Queue<Integer> queue=new LinkedList<>();
        boolean[] vis=new boolean[V];
        queue.add(0);
        while (!queue.isEmpty()){
            int curr= queue.remove();

            if(!vis[curr]){
                System.out.print(curr+"-->");
                vis[curr]=true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e=graph[curr].get(i);
                    queue.add(e.dest);
                }
            }
        }
    }

    static void dfs(ArrayList<Edge>[] graph,int src,boolean[] vis){
        if(!vis[src]){
            System.out.print(src+" ");
            vis[src]=true;

            for(int i=0; i<graph[src].size(); i++){
                Edge e=graph[src].get(i);
                if(!vis[e.dest])
                    dfs(graph,e.dest,vis);
            }
        }
    }


    public static void main(String[] args) {
        int V=7;        //vertices

        ArrayList<Edge>[] graph =new ArrayList[V];
        createGraph(graph);
        boolean[] vis=new boolean[V];

         CycleDetectionUndirected c=new CycleDetectionUndirected();
         boolean ans=c.isCycleUndirected(graph,0,vis,-1);
        System.out.println(ans);
    }
}
