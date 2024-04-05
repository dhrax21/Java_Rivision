package GraphDataStructure;

import java.util.ArrayList;
import java.util.Stack;

public class TopSort {      //topological sort

    void topSortUtil(ArrayList<Graph_Implementation.Edge>[] graph, int curr, boolean[] vis, Stack<Integer> st){
        vis[curr]=true;

            for(int i=0; i<graph[curr].size(); i++){
                Graph_Implementation.Edge e=graph[curr].get(i);

               if(!vis[e.dest])
                    topSortUtil(graph,e.dest,vis,st);
            }
        st.push(curr);
    }

    void topSort(ArrayList<Graph_Implementation.Edge>[] graph,int V){
        boolean[] vis=new boolean[V];
        Stack<Integer> st=new Stack<>();

        for(int i=0; i<V; i++){
            if(!vis[i]){
                topSortUtil(graph,i,vis,st);
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+"\t");
        }
    }
}
