package GraphDataStructure;

import java.util.ArrayList;

public class PrintPaths {
     void printAllPaths(ArrayList<Graph_Implementation.Edge>[] graph,boolean[] vis,int curr,String path,int tar){

        if(curr==tar){
            System.out.println(path);
            return;
        }

        for(int i=0; i<graph[curr].size(); i++){

            Graph_Implementation.Edge e=graph[curr].get(i);
            if(!vis[e.dest]){                       //if node is not visited
                vis[curr]=true;
                printAllPaths(graph,vis,e.dest,path+e.dest,tar);
                vis[curr]=false;
            }
        }

    }
}
