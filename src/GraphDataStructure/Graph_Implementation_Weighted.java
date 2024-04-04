package GraphDataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_Implementation_Weighted {

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

        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,-1));

        graph[2].add(new Edge(2,0,5));
        graph[2].add(new Edge(2,1,90));
        graph[2].add(new Edge(2,3,87));

        graph[3].add(new Edge(3,1,-12));
        graph[3].add(new Edge(3,2,98));
    }

        static void printGraph(ArrayList<Edge>[] graph){
          for (ArrayList<Edge> edges : graph) {
              System.out.println(edges.toString() + "/");
          }

        }






    public static void main(String[] args) {
        int V=4;        //vertices

        ArrayList<Edge> graph[] =new ArrayList[V];
        createGraph(graph);
        printGraph((graph));
    }
}
