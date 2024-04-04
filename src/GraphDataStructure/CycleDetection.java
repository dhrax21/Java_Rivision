package GraphDataStructure;

import java.util.ArrayList;

public class CycleDetection {

    boolean cycleDetectionDFS(ArrayList<Graph_Implementation.Edge>[] graph,int curr,boolean[] vis,boolean[] recStack){
            recStack[curr]=true;
            vis[curr]=true;

        for(int i=0; i<graph[curr].size(); i++){
            Graph_Implementation.Edge e=graph[curr].get(i);

            if(recStack[e.dest]){
                return true;
            }else if(!vis[e.dest]){
                if(cycleDetectionDFS(graph,e.dest,vis,recStack)){
                    return true;
                }
            }
        }
        recStack[curr]=false;
        return false;
    }
}
