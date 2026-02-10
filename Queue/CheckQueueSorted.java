import java.util.Scanner;
import java.util.PriorityQueue;

class MyQueue{
    int front;
    int rear;
    int[] arr;
    int capacity;

    MyQueue(int capacity){
        this.capacity=capacity;
        arr=new int[capacity];
        front=0;
        rear=-1;

    }

    boolean isFull(){
        return rear==capacity-1;
    }

    boolean isEmpty(){
        return rear<front;
    }

    void enqueue(int x){
        
        arr[++rear]=x;

       
        
    }

    int dequeue(){
       
        return arr[front++];
    }
}
public class CheckQueueSorted {
       
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int capacity=sc.nextInt();
        MyQueue q=new MyQueue(capacity);
        for(int i=0;i<capacity;i++){
            q.enqueue(sc.nextInt());
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=0;i<capacity;i++){
            pq.offer(q.arr[i]);
        }
        String ans="sorted";
        for(int i=0;i<capacity;i++){
            if(q.dequeue()!=pq.poll()){
                ans="not sorted";
                break;
            }
        }

        System.out.println(ans);

    }
}
