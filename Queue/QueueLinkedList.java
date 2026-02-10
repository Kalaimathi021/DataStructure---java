class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class MyQueue {
    Node front;
    Node rear;
    int size;

    // Constructor 56
    MyQueue() {
        front = rear = null;
        size = 0;
    }

    // Check if queue is empty
    boolean isEmpty() {
        return front == null;
    }

    // Enqueue operation
    void enqueue(int x) {
        Node newNode = new Node(x);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println(x + " inserted");
    }

    // Dequeue operation
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(front.data + " removed");
        front = front.next;
        size--;

        // If queue becomes empty
        if (front == null) {
            rear = null;
        }
    }

    
    void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front element: " + front.data);
    }

    
void reverse() {

    if (isEmpty() || front.next == null) {
        return; 
    }

    Node prev = null;
    Node curr = front;
    Node next = null;

    rear = front;   

    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    front = prev;   
}



    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = front;
        System.out.print("Queue elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    void getSize() {
        System.out.println("Queue size: " + size);
    }
}

public class QueueLinkedList {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        q.dequeue();
        q.display();
        q.reverse();
        q.display();

        q.peek();
        q.getSize();
    }
}
