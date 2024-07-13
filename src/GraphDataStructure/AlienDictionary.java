package GraphDataStructure;
import java.io.*;
import java.util.*;
import java.math.*;

public class AlienDictionary {
    //{ Driver Code Starts
    /*package whatever //do not write package name here */



   static class GFG {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int t = Integer.parseInt(sc.next());
            while(t-- > 0)
            {
                int n = Integer.parseInt(sc.next());
                int k = Integer.parseInt(sc.next());

                String[] words = new String[n];

                for(int i=0;i<n;i++)
                {
                    words[i] = sc.next();
                }

                Solution ob = new Solution();
                //  System.out.println(T.findOrder(words,k));
                String order = ob.findOrder(words,n,k);
                if(order.length() == 0){
                    System.out.println(0);
                    continue;
                }
                if(order.length() != k){
                    System.out.println("INCOMPLETE");
                    return;
                }
                String temp[] = new String[n];
                for(int i=0;i<n;i++)
                    temp[i] = words[i];

                Arrays.sort(temp, new Comparator<String>(){

                    @Override
                    public int compare(String a, String b) {
                        int index1 = 0;
                        int index2 = 0;
                        for(int i = 0; i < Math.min(a.length(), b.length())
                                && index1 == index2; i++) {
                            index1 = order.indexOf(a.charAt(i));
                            index2 = order.indexOf(b.charAt(i));
                        }

                        if(index1 == index2 && a.length() != b.length())
                        {
                            if(a.length() < b.length())
                                return -1;
                            else
                                return 1;
                        }

                        if(index1 < index2)
                            return -1;
                        else
                            return 1;

                    }
                });

                int flag = 1;
                for(int i=0;i<n;i++)
                {
                    if(!words[i].equals(temp[i]))
                    {
                        flag = 0;
                        break;
                    }
                }

                System.out.println(flag);
            }
        }

    }

    // } Driver Code Ends
    static class Solution
    {
        public void makeGraph(String[] dict,List<List<Integer>> adj,int K){

            for(int i=0; i<K; i++){
                adj.add(new ArrayList<>());
            }

            for(int it=0; it<dict.length-1; it++){
                String s1=dict[it];
                String s2=dict[it+1];

                int i=0,j=0;
                while(i<s1.length() && j<s2.length()){

                    if(s1.charAt(i) != s2.charAt(j)){
                        int u=s1.charAt(i)-'a';
                        int v=s2.charAt(j)-'a';
                        adj.get(u).add(v);
                        break;
                    }
                    i++;
                    j++;
                }
            }

           
        }
        public String findOrder(String [] dict, int N, int K)
        {
            List<List<Integer>> adj=new ArrayList<>();    //adjacency list
            makeGraph(dict,adj,K);


            //topological sorting using Kahn's Algorithm
            Queue<Integer> q=new LinkedList<>();
            int[] indegree=new int[K];

            for(int i=0; i<adj.size(); i++){
                for(int j=0; j<adj.get(i).size();j++){
                    indegree[adj.get(i).get(j)]++;
                }
            }


            for(int i=0; i<K; i++){
                if(indegree[i]==0){
                    q.add(i);
                }
            }


            String ans="";
            while(!q.isEmpty()){
                int curr=q.poll();
                ans+=String.valueOf((char)(curr+97));
                for(int x : adj.get(curr)){
                    indegree[x]--;
                    if(indegree[x]==0){
                        q.add(x);
                    }
                }
            }

            return ans;
        }
    }
}
