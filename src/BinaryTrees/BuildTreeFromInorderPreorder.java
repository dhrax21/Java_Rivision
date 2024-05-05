package BinaryTrees;

public class BuildTreeFromInorderPreorder {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int d){
            this.data=d;
        }
    }

    static int idx=0;
    static Node build(int s1,int e1,int[] in,int pre[]){

        if(e1<s1||idx>=in.length)       //base case if start>end and index out of bound for inoder array
            return null;

        Node newNode=new Node(pre[idx++]);

        int mid = 0;
        for(int i=s1;i<=e1;i++){
            if(in[i]==newNode.data){
                mid=i;                      //find root's index in the inorder array
                break;
            }
        }
        newNode.left = build(s1,mid-1,in,pre);      //recursively adjust for left and right subtrees

        newNode.right = build(mid+1,e1,in,pre);

        return newNode;
    }
     static Node buildTree(int[] inorder, int[] preorder, int n)
    {
        idx=0;
        return build(0,inorder.length-1,inorder,preorder);
    }
}
