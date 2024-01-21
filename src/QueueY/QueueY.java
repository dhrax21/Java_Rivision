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

    public static void main(String[] args) {
        Queue q=new Queue(4);
        System.out.println(q.isEmpty());
//        q.add(11);
//        q.add(22);
//        q.add(33);
//        System.out.println(q.isFull());
//        System.out.println(q.size);
//
        System.out.println(q.peek());
    }
}
