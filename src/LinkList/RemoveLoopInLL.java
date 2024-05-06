package LinkList;

public class RemoveLoopInLL {

    public static class Node{
        int data;
        Node next;

         Node(int data) {
            this.data = data;
        }
    }
//linklist removal of cycle conditions
    public static void removeLoop(Node head){

        if(head==null || head.next==null)
            return;

        Node slow=head;
        Node fast=head;

        boolean cycle=false;

        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                cycle=true;
                break;
            }
        }
        if(!cycle)          //if there is no cycle then just return
            return;

        slow=head;          //again set slow to head of linklist
        if(slow != fast){
            while(slow.next != fast.next){
                slow=slow.next;
                fast=fast.next;
            }
            fast.next=null;
        }else{
            while(fast.next != slow){
                fast=fast.next;
            }
            fast.next=null;
        }
    }
}
