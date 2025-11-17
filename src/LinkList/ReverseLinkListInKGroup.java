package LinkList;

public class ReverseLinkListInKGroup {
    private class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, LL.Node next) {
            this.val = val;
        }
    }
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) return null;

            // Step 1: Check if there are k nodes
            ListNode node = head;
            for (int i = 0; i < k; i++) {
                if (node == null) return head;  // fewer than k nodes left
                node = node.next;
            }

            // Step 2: Reverse first k nodes
            ListNode prev = null;
            ListNode curr = head;
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Step 3: head is now the tail of this reversed group
            // Connect recursion result of the remaining list
            head.next = reverseKGroup(curr, k);

            // Step 4: prev is the new head of the reversed group
            return prev;
        }


   // Given the head of a singly linked list and two integers left and right where left <= right,
    // reverse the nodes of the list from position left to position right, and return the reversed list.


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        // mark nodes for currentNode and Node from where reversal starts
        ListNode leftPre=dummy;
        ListNode currNode=head;

        for(int i=0; i<left-1; i++){
            leftPre=leftPre.next;
            currNode=currNode.next;
        }

        //mark the node from where we started the reversal
        ListNode subListHead=currNode;

        ListNode preNode=null;


        for(int i=0; i<=right-left; i++){
            ListNode nextNode=currNode.next;
            currNode.next=preNode;
            preNode=currNode;
            currNode=nextNode;
        }

        leftPre.next=preNode;
        subListHead.next=currNode;

        return dummy.next;
    }

}
