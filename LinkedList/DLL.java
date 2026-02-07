package LinkedList;

public class DLL {

    static class Node {
        int data;
        Node prev, next;

        Node(int x) {
            data = x;
        }
    }

    Node head = null, tail = null;
    int size = 0;

    // add at beginning (index 0)
    void addAtFirst(int x) {
        Node newNode = new Node(x);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // add at end (index size)
    void addAtLast(int x) {
        Node newNode = new Node(x);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
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
        newNode.prev = temp;
        temp.next.prev = newNode;
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
            head.prev = null;
        }
        size--;
    }

    // delete last (index size-1)
    void deleteAtLast() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    // 🔥 delete at position (0-based)
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
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
    }

    void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        DLL list = new DLL();

        list.addAtPosition(10, 0); // [10]
        list.addAtPosition(20, 1); // [10,20]
        list.addAtPosition(30, 2); // [10,20,30]
        //list.addAtPosition(15, 1); // [10,15,20,30]

        list.displayForward();   // 10 15 20 30
        list.displayBackward();  // 30 20 15 10

        //list.deleteAtPosition(0); // remove 10
        //list.deleteAtPosition(2); // remove 30

        //list.displayForward(); // 15 20
    }
}
