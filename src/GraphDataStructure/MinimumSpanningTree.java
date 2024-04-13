package GraphDataStructure;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

   public static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }


      static void createGraph(ArrayList<Edge>[] graph,int V){
            for(int i=0; i<V; i++){
                graph[i]=new ArrayList<Edge>();
            }

            graph[0].add(new Edge(0,1,10));
            graph[0].add(new Edge(0,2,15));
            graph[0].add(new Edge(0,3,30));

            graph[1].add(new Edge(1,0,10));
            graph[1].add(new Edge(1,3,40));

            graph[2].add(new Edge(2,0,15));
            graph[2].add(new Edge(2,3,50));

            graph[3].add(new Edge(3,1,40));
            graph[3].add(new Edge(3,2,50));
        }

    public static class Pair implements Comparable<Pair>{
       int node;
       int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cost-o.cost;
        }
    }
    public static void primAlgo(ArrayList<Edge>[] graph,int V){
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>();
        boolean[] vis=new boolean[V];
        int mstCost=0;
        pq.add(new Pair(0,0));      //src,cost

        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.node]) {
                vis[curr.node] = true;

                mstCost += curr.cost;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);

                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.weight));
                    }
                }
            }
        }
        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph,V);
        primAlgo(graph,V);

    }
}
