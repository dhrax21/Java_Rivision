package DSAAgain;

import java.util.ArrayList;
import java.util.Scanner;

public class BIinarryTree {

    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
        }
    }

    static Scanner sc=null;

    public static void main(String[] args) {
        sc=new Scanner(System.in);

        Node root=createTree();
    }

    private static Node createTree() {

        Node root=null;
        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if(data == -1) return null;

        root= new Node(data);

        System.out.println("Enter left root value" + data);
        root.left=createTree();

        System.out.println("Enter right root value"+ data);
        root.right=createTree();

        return root;
    }

    void printLeftView(Node root){
        ArrayList<Node> list=new ArrayList<>();
        printLeftViewUtil(root,list,0);

        for(Node n : list){
            System.out.println(n.data+" :");
        }
    }

    private void printLeftViewUtil(Node root, ArrayList<Node> list, int level) {
        if(root==null)
            return;

        if(list.get(level)==null){
            list.add(root);
        }

        printLeftViewUtil(root.left,list,level+1);
        printLeftViewUtil(root.right,list,level+1)  ;
    }
}
