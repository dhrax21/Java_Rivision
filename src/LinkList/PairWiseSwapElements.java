package LinkList;

public class PairWiseSwapElements {

    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Solution {
        public Node pairWiseSwap(Node head) {
            if (head == null || head.next == null) {
                return head;
            }

            Node prev = null;
            Node forward = null;
            Node curr = head;
            int count = 0;

            while (curr != null && count < 2) {
                forward = curr.next;
                curr.next = prev;
                prev = curr;
                curr = forward;
                count++;
            }

            if (forward != null) {
                head.next = pairWiseSwap(forward);
            }

            return prev;
        }
    }


}
