package BinaryTrees;

import java.util.*;

public class VerticalTraversal {
    static class Node{
        int data;
        Node left;
        Node right;

         Node(int d){
            this.data=d;
        }
    }

    static class Pair{
        int ht;
        Node node;

        Pair(int h,Node n){
            this.ht=h;
            this.node=n;
        }
    }
    static ArrayList<Integer> verticalOrder(Node root)
    {
        Map<Integer,ArrayList<Integer>> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,root));

        while(!q.isEmpty()){
            Pair curr=q.poll();
            if(map.containsKey(curr.ht)){
                map.get(curr.ht).add(curr.node.data);
            }else{
                ArrayList <Integer> list=new ArrayList<>();
                list.add(curr.node.data);
                map.put(curr.ht,list);
            }

            if(curr.node.left != null){
                q.add(new Pair(curr.ht-1,curr.node.left));
            }
            if(curr.node.right != null){
                q.add(new Pair(curr.ht+1,curr.node.right));
            }
        }
        ArrayList <Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,ArrayList <Integer>> entry : map.entrySet()){
            ans.addAll(entry.getValue());
        }
        return ans;
    }
}
