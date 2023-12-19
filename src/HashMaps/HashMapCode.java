package HashMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HashMapCode {
    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;      // nodes
        private int N;      //buckets

        private LinkedList<Node> buckets[];     //N=bucket length

        public HashMap() {
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i=0; i<4; i++){
                this.buckets[i]=new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int bi=key.hashCode();              //bucket index
            return Math.abs(bi) % N;
        }


        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll=buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if(ll.get(i).key==key){
                    return i;       //di  data index
                }
            }
            return -1;
        }

        public void put(K key,V value){
            int bi=hashFunction(key);           //finding bucket index
            int di=searchInLL(key,bi);          //searching the linkedlist in particular bucket

            if(di==-1){
                buckets[bi].add(new Node(key,value));
                n++;
            }else{
                Node node=buckets[bi].get(di);
                node.value=value;
            }

            double lamda=(double) n/N;
            if(lamda>2.0){
                //rehashing because array is over filled with nodes
                rehash();
            }
        }

        private void rehash(){
            LinkedList<Node> oldBucket[]=buckets;
            buckets=new LinkedList[N*2];            //creating bucket of double size
                                                    //because old is full of nodes

            for(int i=0; i<N*2; i++){
                buckets[i]=new LinkedList<>();      //initializing each bucket with a linkedlist
            }

            for(int i=0; i<oldBucket.length;i++){
                LinkedList<Node> ll=oldBucket[i];       //just copying the oldlinkedlist key and value
                                                        // into the new bucket of size N*2
                for(int j=0; j<ll.size(); j++){
                    Node node=ll.get(j);
                    put(node.key,node.value);
                }
            }


        }



        public boolean containsKey(K key){
            int bi=hashFunction(key);           //finding bucket index
            int di=searchInLL(key,bi);          //searching the linkedlist in particular bucket

            if(di==-1){
                return false;
            }else{
                return true;
            }
        }

        public V remove(K key){
            int bi=hashFunction(key);           //finding bucket index
            int di=searchInLL(key,bi);          //searching the linkedlist in particular bucket

            if(di==-1){
                return null;
            }else{
                Node node=buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }


        public V get(K key){
            int bi=hashFunction(key);           //finding bucket index
            int di=searchInLL(key,bi);          //searching the linkedlist in particular bucket

            if(di==-1){
               return null;
            }else{
                Node node=buckets[bi].get(di);
                return node.value;
            }
        }


        public ArrayList<K> keySet(){
            ArrayList<K> keys=new ArrayList<>();
            for(int i=0; i<buckets.length;i++){
                LinkedList<Node> ll=buckets[i];
                for(int j=0; j<ll.size();j++){
                    Node node=ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }

    }


    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("India",100);
        map.put("China",200);
        map.put("US",80);
        map.put("Srilanka",20);
        map.put("Japan",5);


        ArrayList<String> keysHM=map.keySet();
        for (int i = 0; i < keysHM.size(); i++) {
            System.out.println(keysHM.get(i));
        }

        map.containsKey("Bhopal");
        System.out.println(map.isEmpty());
        System.out.println(map.get("India"));

    }

}
