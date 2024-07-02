package LinkList;

public class FlattenLinkList {

    static class Node{
        int data;
        Node next;
        Node bottom;

        Node(int d){
            this.data=d;
            this.next=null;
            this.bottom=null;
        }
    }
   static Node flatten(Node root) {
        if(root==null) return null;

        Node ans=null;
        Node curr=root;

        while(curr!=null){
            ans=mergeBottomSorted(ans,curr);
            curr=curr.next;
        }
        return ans;
    }
   static Node mergeBottomSorted(Node head1,Node head2){
        if(head1==null || head2==null){
            return head1==null ? head2 : head1;
        }

        Node ptr1=head1;
        Node ptr2=head2;

        Node dummy=new Node(-1);
        Node ans=dummy;

        while(ptr1 != null || ptr2 != null){
            int val1=(ptr1==null) ? Integer.MAX_VALUE : ptr1.data;
            int val2=(ptr2==null) ? Integer.MAX_VALUE : ptr2.data;

            if(val1<val2){
                dummy.bottom=ptr1;
                ptr1=ptr1.bottom;
            }else{
                dummy.bottom=ptr2;
                ptr2=ptr2.bottom;
            }
            dummy=dummy.bottom;
        }

        return ans.bottom;
    }
}
