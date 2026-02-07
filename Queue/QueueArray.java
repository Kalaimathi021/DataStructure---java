package Queue;
class Queue{
    int arr[]=new int[5];
    int size=0;
    int front =-1;
    int rear=-1;
    int capacity=5;

    public void enqueue(int x){
        if(rear==capacity-1){
            System.out.println("Queue is full");
            return;
        }
        if(front==-1){
            front++;
        }
        rear++;
        arr[rear]=x;
        arr[rear]=x;
    }
}
public class QueueArray {
    
}
