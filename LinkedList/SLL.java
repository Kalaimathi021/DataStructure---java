package LinkedList;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class SLL {

    Node head = null;

    /* ---------- INSERT METHODS ---------- */

    void addAtFirst(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    void addAtLast(int x) {
        Node newNode = new Node(x);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void addAtPosition(int x, int pos) {
        if (pos < 0 || pos > size()) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 0) {
            addAtFirst(x);
            return;
        }

        Node newNode = new Node(x);
        Node temp = head;

        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    /* ---------- DELETE METHODS ---------- */

    void deleteAtFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    void deleteAtLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos < 0 || pos >= size()) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 0) {
            deleteAtFirst();
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    /* ---------- EXTRA (OPTIONAL) METHODS ---------- */

    boolean isEmpty() {
        return head == null;
    }

    boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    int get(int index) {
        if (index < 0 || index >= size()) {
            return -1;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    void clear() {
        head = null;
    }

    /* ---------- UTILITY METHODS ---------- */

    int size() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    /* ---------- MAIN METHOD ---------- */

    public static void main(String[] args) {
        SLL list = new SLL();

        list.addAtFirst(10);
        list.addAtFirst(20);
        list.addAtLast(30);
        list.addAtPosition(25, 2);

        list.display();

        System.out.println("Size: " + list.size());
        System.out.println("Is Empty: " + list.isEmpty());
        System.out.println("Search 25: " + list.search(25));
        System.out.println("Element at index 1: " + list.get(1));

        list.deleteAtFirst();
        list.display();

        list.deleteAtLast();
        list.display();

        list.clear();
        list.display();
    }
}
