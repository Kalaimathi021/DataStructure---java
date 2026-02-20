import java.util.Scanner;

class Queue {
    int[] arr;
    int front, rear, size, capacity;

    Queue(int capacity) {
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

    void insertFront(int value) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        arr[front] = value;
        size++;
        System.out.println("Inserted at Front");
    }

    void insertRear(int value) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        arr[rear] = value;
        size++;
        System.out.println("Inserted at Rear");
    }

    void deleteFront() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Deleted from Front: " + arr[front]);

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        size--;
    }

    void deleteRear() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Deleted from Rear: " + arr[rear]);

        if (front == rear) {
            front = rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }

        size--;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
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
}

public class DoubleEndedQueue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter capacity of deque: ");
        int n = sc.nextInt();

        Queue q = new Queue(n);

        while (true) {

            System.out.println("\n1.Insert Front");
            System.out.println("2.Insert Rear");
            System.out.println("3.Delete Front");
            System.out.println("4.Delete Rear");
            System.out.println("5.Display");
            System.out.println("6.Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    q.insertFront(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    q.insertRear(sc.nextInt());
                    break;

                case 3:
                    q.deleteFront();
                    break;

                case 4:
                    q.deleteRear();
                    break;

                case 5:
                    q.display();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
