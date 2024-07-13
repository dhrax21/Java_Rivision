package GraphDataStructure;
//{It is used to find topological sorting of nodes of graph & it works only for DAG->Directed Acyclic Graph}

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//        Algorithm:
//        Add all nodes with in-degree 0 to a queue.
//        While the queue is not empty:
//        Remove a node from the queue.
//        For each outgoing edge from the removed node, decrement the in-degree of the destination node by 1.
//        If the in-degree of a destination node becomes 0, add it to the queue.
//        If the queue is empty and there are still nodes in the graph, the graph contains a cycle and cannot be topologically sorted.
//        The nodes in the queue represent the topological ordering of the graph.
public class Kahns_Algorithm {
    public static int[] topologicalSort(List<List<Integer>> adj, int V)
    {
        // Array to store indegree of each vertex
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Queue to store vertices with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[V];
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            result[index++] = node;

            // Decrease indegree of adjacent vertices as the
            // current node is in topological order
            for (int it : adj.get(node)) {
                indegree[it]--;

                // If indegree becomes 0, push it to the
                // queue
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        // Check for cycle
        if (index != V) {
            System.out.println("Graph contains cycle!");
            return new int[0];
        }

        return result;
    }

}
