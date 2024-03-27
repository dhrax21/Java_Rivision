package LinkList;
import java.util.*;
public class AddTwoNumUsingLL {
   static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

   static class GfG{

        static void printList(Node n){
            while(n!=null){
                System.out.print(n.data+" ");
                n = n.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            while (T-- > 0) {

                int n = sc.nextInt();
                int val = sc.nextInt();

                Node num1 = new Node(val);
                Node tail = num1;
                for(int i=0; i<n-1; i++)
                {
                    val = sc.nextInt();
                    tail.next = new Node(val);
                    tail = tail.next;
                }

                int m = sc.nextInt();
                val = sc.nextInt();

                Node num2 = new Node(val);
                tail = num2;
                for(int i=0; i<m-1; i++)
                {
                    val = sc.nextInt();
                    tail.next = new Node(val);
                    tail = tail.next;
                }

                Solution g = new Solution();
                Node res = g.addTwoLists(num1, num2);
                printList(res);
            }
        }
    }

// } Driver Code Ends

  static class Solution{

        static Node reverse(Node head){
            Node curr=head;
            Node prev=null,nextt=null;

            while(curr != null){
                nextt=curr.next;
                curr.next=prev;
                prev=curr;
                curr=nextt;
            }
            head=prev;
            return head;
        }
        static Node addTwoLists(Node num1, Node num2){

            while(num1!=null&&num1.data==0||num2!=null&&num2.data==0) {
                if(num1!=null&&num1.data==0){
                    num1=num1.next;
                }
                if(num2!=null&&num2.data==0){
                    num2=num2.next;
                }
            }
            if(num1 == null && num2 ==null){
                Node newNode=new Node(0);
                return newNode;
            }



            Node dummy=new Node(-1);
            Node ref=dummy;

            Node head1=reverse(num1);
            Node head2=reverse(num2);
            int carry=0;

            while(head1 != null || head2 != null || carry !=0){
                int sum=0;

                if(head1 != null){
                    sum+=head1.data;
                    head1=head1.next;
                }
                if(head2 != null){
                    sum+=head2.data;
                    head2=head2.next;
                }
                sum+=carry;
                carry=sum/10;

                Node curr=new Node(sum%10);
                ref.next=curr;
                ref=ref.next;
            }

            Node ans=reverse(dummy.next);
            return ans;

        }
    }
}
