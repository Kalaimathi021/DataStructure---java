import java.util.Scanner;

class CirQueue {
    int[] arr;
    int front;
    int rear;
    int capacity;
    int size;

 
    CirQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }


    boolean isFull() {
        return size == capacity;
    }


    boolean isEmpty() {
        return size == 0;
    }

  
    void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;

        System.out.println(x + " inserted");
    }


    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(arr[front] + " removed");

        front = (front + 1) % capacity;
        size--;


        if (size == 0) {
            front = -1;
            rear = -1;
        }
    }

    void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front element: " + arr[front]);
    }

    
void reverse() {

    if (isEmpty() || size == 1) {
        return;
    }

    int i = front;
    int j = (front + size - 1) % capacity;

    for (int count = 0; count < size / 2; count++) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        i = (i + 1) % capacity;
        j = (j - 1 + capacity) % capacity;
    }
}


   
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        int i = front;
        for (int count = 0; count < size; count++) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.println();
    }


    void getSize() {
        System.out.println("Queue size: " + size);
    }
}

public class CircularQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        CirQueue q = new CirQueue(capacity);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        q.dequeue();
        q.display();

        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);   

        q.display();
        q.reverse();
        q.display();
        q.peek();
        q.getSize();

        sc.close();
    }

}
