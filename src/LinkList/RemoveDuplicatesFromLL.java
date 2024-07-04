package LinkList;

public class RemoveDuplicatesFromLL {
    static class Node{
        int data;
        Node next;

        Node(int d){
            this.data=d;
        }
    }

    static Node addLast(Node head,int d){

        if(head==null){
            return new Node(d);
        }
        Node temp=head;
        while(temp.next != null){
            temp=temp.next;
        }
        temp.next=new Node(d);
        return head;
    }

    public static void main(String[] args) {
        int[] arr={28,28,28,35,35 };
        Node head=null;
        for(int k : arr){
            head=addLast(head,k);
        }
        Node ans=removeAllDuplicates(head);
        while(ans != null){
            System.out.print(ans.data+"->");
            ans=ans.next;
        }
    }
    static Node removeAllDuplicates(Node head) {
        Node dummy=new Node(-1);
        dummy.next=head;

        Node prev=dummy;

        while(head != null){
            if(head.next != null && head.data == head.next.data){
                while(head.next != null && head.data == head.next.data){
                    head=head.next;
                }
                prev.next=head.next;
            }else{
                prev=prev.next;
            }
            head=head.next;
        }
        return dummy.next;
    }
}
