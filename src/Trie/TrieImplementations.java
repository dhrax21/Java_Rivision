package Trie;

import java.util.Arrays;

public class TrieImplementations {

    static class Node{
        Node[] children;
        boolean endOfWord;

        public Node() {
            this.children = new Node[26];
            Arrays.fill(children, null);
            this.endOfWord = false;
        }
    }
    static Node root=new Node();

    static void insert(String word){

        Node curr=root;

        for(int i=0; i<word.length(); i++){
            int index=word.charAt(i)-'a';

            if(curr.children[index]==null){         // create a reference for the character
                curr.children[index]=new Node();
            }
            if(i==word.length()-1){
                curr.children[index].endOfWord=true;
            }
            curr=curr.children[index];
        }

    }

    static boolean search(String key){
        Node curr=root;
        for(int i=0; i<key.length(); i++){
            int index=key.charAt(i)-'a';

            if(curr.children[index]==null){
                return false;
            }
            if(i==key.length()-1 && !curr.children[index].endOfWord){
                return false;
            }
            curr=curr.children[index];
        }
        return true;
    }

    static int countNodes(Node root){
        if(root==null) return 0;

        int cnt=0;
        for(int i=0; i<26; i++){
            if(root.children[i]!=null){
                cnt+=countNodes(root.children[i]);
            }
        }
        return cnt+1;
    }


    static boolean wordBreak(String key){
        if(key.isEmpty()) return true;

        for(int i=1; i<=key.length(); i++){
            String firstPart=key.substring(0,i);
            String secPart=key.substring(i);
            if(search(firstPart) && wordBreak(secPart)){
                return true;
            }
        }

        return false;
    }
    static String ans="";
    static void longestPrefix(Node root,StringBuilder temp){
        if(root==null) return;

        for(int i=0; i<26; i++){
            if(root.children[i]!=null && root.children[i].endOfWord){
                temp.append((char)(i+'a'));
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestPrefix(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }


    }

    public static void main(String[] args) {
        String[] words={"m","ma","man","mang","mangm","mango"};

        for(int i=0; i< words.length; i++){
            insert(words[i]);
        }

        longestPrefix(root,new StringBuilder());
        System.out.println(ans);
    }
}
