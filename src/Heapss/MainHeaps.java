package Heapss;

public class MainHeaps {
    public static void main(String[] args) {
        Priority_Que_Min pq=new Priority_Que_Min();

//        for(int i=10; i>=0; i-=2){
//
//        }

        pq.insert(100);
        pq.insert(-34);
        pq.insert(29);
        pq.insert(67);
        pq.insert(1);
        pq.insert(1282);
        while(!pq.isKhali()){
            System.out.print(pq.removeMin()+"-->");
        }
    }
}
