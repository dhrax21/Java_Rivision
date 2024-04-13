package GraphDataStructure;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
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
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));
    }


    public static void bellmanFord(ArrayList<Edge>[] graph,int src,int V){

        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        boolean[] vis=new boolean[V];

        for(int k=0; k<V-1; k++){       //O(V)
            for(int i=0; i<V; i++){
                for(int j=0; j<graph[i].size(); j++){
                    Edge e=graph[i].get(j);
                    int u=e.src;
                    int v=e.dest;


                    if(dist[u] !=Integer.MAX_VALUE && dist[u]+e.weight<dist[v]){
                        dist[v]=dist[u]+e.weight;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dist));

    }

    public static void main(String[] args) {

        int V=5;
        ArrayList<Edge>[] graph =new ArrayList[V];
        createGraph(graph);
        bellmanFord(graph,0,V);


    }

}
