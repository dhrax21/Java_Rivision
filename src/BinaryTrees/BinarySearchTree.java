package BinaryTrees;

public class BinarySearchTree {

    static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static Node insert(int value,Node node){
        if(node==null)
            return new Node(value);

        if(value<node.value){
            node.left=insert(value,node.left);
        }
        if(value>node.value){
            node.right=insert(value,node.right);
        }
        return node;
    }

    static void inOrder(Node root){
        if(root==null)
            return;

        inOrder(root.left);
        System.out.print(root.value+" ");
        inOrder(root.right);
    }


    static Node deleteNode(Node node,int x){

        if(node==null){
            return null;
        }

        if(node.value<x){
            node.right=deleteNode(node.right,x);
        }else if(x<node.value){
            node.left=deleteNode(node.left,x);
        }
        else{
                if(node.right!=null && node.left !=null){           //for two child
                    int leftMax=maxi(node.left);
                    node.value=leftMax;
                    node.left=deleteNode(node.left,leftMax);
                    return node;
                }
                else if(node.left != null){                     //for single child
                    return node.left;
                }else if(node.right != null){
                    return node.right;
                }
            return null;
        }
        return node;
        }

    private static int maxi(Node nodeLeft) {
        if(nodeLeft.right != null){
            maxi(nodeLeft.right);
      }
        return nodeLeft.value;
}

    public static void main(String[] args) {
        Node root=null;
        for(int i=1; i<7; i++){
            root=insert(i*3,root);
        }

        insert(14,root);

        inOrder(root);
        System.out.println();
        deleteNode(root,9);
        inOrder(root);

    }

}

