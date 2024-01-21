package QueueY;

public class QueueY {
    static class Queue{

        static int[] arr;

        static int rear;
        int size;
        private Queue(int n){
            this.size=n;
            arr=new int[n];
            rear=-1;
        }

        public boolean isEmpty(){
            return rear==-1;
        }
        public boolean isFull(){
            return rear==size-1;
        }


        public void add(int data){
            if(!isFull()){
                rear++;
                arr[rear]=data;
            }
        }

        public int peek(){
            return rear==-1 ? -1 : arr[0];
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("Nothing to delete ");
                return -1;
            }
            int data=arr[0];
            for(int i=0; i<rear; i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return data;
        }

    }


    // for circular queue implementation

    static class CirQueue{

        static int[] arr;

        static int rear;
        static int front;
        int size;
        private CirQueue(int n){
            this.size=n;
            arr=new int[n];
            rear=-1;
            front=-1;
        }

        public boolean isEmpty(){
            return front==-1 && rear==-1;
        }
        public boolean isFull(){
            return (rear+1) % size==front;
        }


        public void add(int data){
            if(isFull()){
                System.out.println("overflow!");
                return;
            }
            //if it's the last element
            if(front==-1){
                front=0;
            }

            rear=(rear+1)%size;
            arr[rear]=data;
        }

        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return arr[front];
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("Nothing to delete ");
                return -1;
            }
            int data=arr[front];

            // if only one element is present
            if(front==rear){
                front=rear=-1;
            }else{
                front=(front+1)%size;
            }
            return data;
        }

    }

    static class QueueLinkList{

       static class Node{
           int data;
           Node next;

           Node (int data){
               this.data=data;
               this.next=null;
           }
       }

       static Node head=null;
       static Node tail=null;


       public boolean isEmpty(){
           return head==null && tail==null;
       }

       public void add(int data){
           Node nd=new Node(data);

           if(tail==null){
               head=nd;
               tail=nd;
               return;
           }

           tail.next=nd;
           tail=nd;
       }

       public int remove(){

           if(isEmpty()){
               System.out.println("Queue is empty!");
               return -1;
           }

           int v= head.data;
           if(head==tail){
               tail=null;
           }
           head=head.next;
           return v;
       }

       public int peek(){
           if(isEmpty()){
               return -1;
           }
           return head.data;
       }


    }



    public static void main(String[] args) {
        QueueLinkList q=new QueueLinkList();
        System.out.println(q.isEmpty());
        q.add(14);
        q.add(45);
        q.add(124);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
