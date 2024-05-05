package BinaryTrees;

public class BuildTreeFromInorderPostorder {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int d){
            this.data=d;
        }
    }

    int idx=0;
    Node buildTree(int[] in, int[] post, int n) {
        idx=n-1;
        return build(in,post,0,n-1);
    }

    Node build(int[] in,int[] post,int start,int end){
        if(start>end){
            return null;
        }
        Node root=new Node(post[idx--]);
        if(start==end){
            return root;
        }
        int mid=0;
        int i=0;
        for(i=start; i<=end; i++){
            if(in[i]==root.data){
                mid=i;
                break;
            }
        }
        if(i>end)
            return null;

        root.right=build(in,post,mid+1,end);
        root.left=build(in,post,start,mid-1);
        return root;
    }
}
