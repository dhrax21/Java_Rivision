package GraphDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Graph_Implementation_Weighted {

    public static class Pair implements Comparable<Pair>{
        int node;
        int dest;

        public Pair(int src, int dest) {
            this.node = src;
            this.dest = dest;
        }

        @Override
        public int compareTo(Pair o) {
            return this.dest-o.dest;
        }
    }

    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest,int weight) {
            this.src = src;
            this.dest = dest;
            this.weight=weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "src=" + src +
                    ", dest=" + dest +
                    ", weight=" + weight +
                    '}';
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){     //adjacency list , undirected , unweighted graph
        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

        static void printGraph(ArrayList<Edge>[] graph){
          for (ArrayList<Edge> edges : graph) {
              System.out.println(edges.toString() + "/");
          }
        }

       static void dijkstra(ArrayList<Edge>[] graph,int src,int V){

        boolean[] vis=new boolean[V];
        int[] dist=new int[V];

        for(int i=0; i<V; i++){
            if(i != src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
           PriorityQueue<Pair> pq=new PriorityQueue<>();
           pq.add(new Pair(src,0));

           while(!pq.isEmpty()){
               Pair curr=pq.poll();
               if(!vis[curr.node]){
                   vis[curr.node]=true;

                   for(int i = 0; i <graph[curr.node].size(); i++) {
                        Edge e=graph[curr.node].get(i);     //calculating edges
                        int u=e.src;        //source node
                        int v=e.dest;       //destination node

                       if(!vis[v] && dist[u] + e.weight < dist[v]){        //relaxation
                           dist[v]=dist[u]+ e.weight;
                           pq.add(new Pair(v,dist[v]));
                       }
                   }
               }

           }

           System.out.println(Arrays.toString(dist));
       }

    public static void main(String[] args) {
        int V=6;        //vertices

        ArrayList<Edge> graph[] =new ArrayList[V];
        createGraph(graph);
        dijkstra(graph,0,V);
    }
}
