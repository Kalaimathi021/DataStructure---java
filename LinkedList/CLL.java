package LinkedList;

public class CLL {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next=null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    void addAtFirst(int x) {
        Node newNode = new Node(x);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    // add at end (index size)
    void addAtLast(int x) {
        Node newNode = new Node(x);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    // 🔥 add at position (0-based)
    void addAtPosition(int x, int pos) {

        if (pos < 0 || pos > size) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 0) {
            addAtFirst(x);
            return;
        }

        if (pos == size) {
            addAtLast(x);
            return;
        }

        Node newNode = new Node(x);
        Node temp = head;

        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    // delete first (index 0)
    void deleteAtFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
    }


    void deleteAtLast() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = head;
            tail = temp;
        }
        size--;
    }

    void deleteAtPosition(int pos) {

        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 0) {
            deleteAtFirst();
            return;
        }

        if (pos == size - 1) {
            deleteAtLast();
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    // display
    void display() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // MAIN
    public static void main(String[] args) {

        CLL list = new CLL();

        list.addAtPosition(10, 0);
        list.addAtPosition(20, 1);
        list.addAtPosition(30, 2);
        list.addAtPosition(15, 1);

        list.display(); // 10 15 20 30

        list.deleteAtPosition(0);
        list.display(); // 15 20 30

        list.deleteAtPosition(2);
        list.display(); // 15 20
    }
}
