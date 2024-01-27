package BinaryTrees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

       public Node(int d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTreeYT {
        static int index = -1;
        public Node buildTree(int[] nodes) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

        private static void levelOrder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node curr=q.remove();

                if((curr == null)){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(curr.data+" ");
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }
            }
        }

        private static void postOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }


        private static void inOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
        private static void preOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }


    public static void main(String[] args) {
            int[] nodes = {1,3,4,-1,-1,5,-1,-1,99,-1,6,-1,7,-1,-1};

            BinaryTreeYT tree = new BinaryTreeYT();
            Node root= tree.buildTree(nodes);
            levelOrder(root);
        }

}
