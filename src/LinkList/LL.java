package LinkList;

public class LL {

    private Node head;
    private Node tail;

    private int size;

    public LL() {
        this.size=0;
    }

    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;

        if(tail==null){
            tail=head;
        }
        size++;
    }

    public void insertLast(int val){

        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }

    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println(" End!");
    }

    public void insertPos(int val,int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }

        Node temp=head;

        for(int i=1; i<index; i++){
            temp=temp.next;
        }

        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;
    }

    public int deleteFirst(){
        int data=head.val;
        head=head.next;

        if(head==null){
            tail=null;
        }
        size--;
        return data;
    }

    public Node get(int index){

        Node temp=head;
        for(int i=1; i<index; i++){
            temp=temp.next;
        }
        return temp;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node node=get(size-1);
        int data=tail.val;

        tail=node;
        node.next=null;

        size--;
        return data;
    }

    public int delete(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteFirst();
        }

        Node prev=get(index-1);
        int val=prev.next.val;

        prev.next=prev.next.next;

        return val;
    }



    class Node{
        private int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
