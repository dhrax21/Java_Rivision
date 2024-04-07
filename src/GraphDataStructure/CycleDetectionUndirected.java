package GraphDataStructure;

import java.util.ArrayList;

public class CycleDetectionUndirected {
     boolean isCycleUndirected(ArrayList<Graph_Implementation.Edge>[] graph,int curr,boolean[] vis,int parent){
        vis[curr]=true;

        for(int i=0; i<graph[curr].size(); i++){
            Graph_Implementation.Edge e=graph[curr].get(i);

            if(vis[e.dest] && parent != e.dest){
                return true;
            }
            else if(!vis[e.dest]){
                if(isCycleUndirected(graph,e.dest,vis,parent)){
                    return true;
                }
            }
        }
        return false;
    }
}
