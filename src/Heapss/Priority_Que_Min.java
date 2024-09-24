package Heapss;

import java.util.ArrayList;

public class Priority_Que_Min extends Exception {
    private ArrayList<Integer> heap;

    public Priority_Que_Min(){
        this.heap=new ArrayList<>();
    }

    public boolean isKhali(){
        return heap.isEmpty();
    }
    public int peek(){
        if(heap.isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return heap.get(0);
    }

    public void insert(int x){
        heap.add(x);
        int childIndex=heap.size()-1;
        int parentIndex=(childIndex-1)/2;

        while(childIndex>0){
            if(heap.get(childIndex)<heap.get(parentIndex)){
                int temp=heap.get(childIndex);
                heap.set(childIndex,heap.get(parentIndex));
                heap.set(parentIndex,temp);

                childIndex=parentIndex;
                parentIndex=(childIndex-1)/2;
            }else{
                return;
            }
        }
    }

    public int removeMin(){
        if(heap.isEmpty()) throw new ArrayIndexOutOfBoundsException();
        int temp=heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int index=0,minIndex=index;

        int leftChildIndex=1;
        int rightChildIndex=2;

        while(leftChildIndex<heap.size()){
            if(heap.get(leftChildIndex)<heap.get(index)){
                minIndex=leftChildIndex;
            }
            if(rightChildIndex<heap.size() &&heap.get(rightChildIndex)<heap.get(index)){
                minIndex=rightChildIndex;
            }
            if(minIndex == index) break;
            else{
                int temp1=heap.get(index);
                heap.set(index,heap.get(minIndex));
                heap.set(minIndex,temp1);
                index=minIndex;
                leftChildIndex=2*index+1;
                rightChildIndex=2*index+2;
            }
        }
        return temp;
    }
}
