package LinkList;

public class RotateLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }

    }
    static Node rotate(Node head,int k){
        Node curr=head,newhead=null;
        int n=0;
        while(curr!=null){
            curr = curr.next;
            n++;//computing size of sll
        }
        k=k%n;
        if(k==0) return head;//no need to rotate

        curr=head;
        for(int i=0;i<k-1;i++)
            curr = curr.next;

        newhead = curr.next;

        curr.next = null;

        Node node = newhead;
        while(node.next!=null)
            node  = node.next;

        node.next = head;

        return newhead;
    }
}
