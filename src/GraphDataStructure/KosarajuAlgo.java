package GraphDataStructure;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgo {
   public static class Edge{
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

    public static void dfs(ArrayList<Edge>[] graph,int curr,boolean[] vis){
        vis[curr]=true;
        System.out.print(curr+" ");

        for(int i=0; i<graph[curr].size(); i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s){
        vis[curr]=true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph,e.dest,vis,s);
            }
        }
        s.push(curr);
    }

    static void createGraph(ArrayList<Edge>[] graph,int V){
        for(int i=0; i<V; i++){
            graph[i]=new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));
    }

   public static void kosaraju(ArrayList<Edge>[] graph,int V){
       Stack<Integer> s=new Stack<>();
       boolean[] vis=new boolean[V];

       //step 1 do the sorting
       for(int i=0; i<V; i++){
           if(!vis[i]){
               topSort(graph,i,vis,s);
           }
       }

       //step 2 transpose the graph

       ArrayList<Edge>[] transpose=new ArrayList[V];
       for(int i=0; i<V; i++){
           transpose[i]=new ArrayList<Edge>();
       }

       for(int i=0; i<V; i++){
           vis[i]=false;
           for(int j=0; j<graph[i].size(); j++){
               Edge e=graph[i].get(j);
               transpose[e.dest].add(new Edge(e.dest, e.src));      //reversing the edges
           }
       }

       //step 3 performing the dfs on transposed graph

       while(!s.isEmpty()){
           int curr=s.pop();
           if(!vis[curr]){
               dfs(transpose,curr,vis);
               System.out.println();
           }
       }

   }

    public static void main(String[] args) {
        int V=5;
        boolean[] vis=new boolean[V];
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph,V);
        kosaraju(graph,V);

    }

}
