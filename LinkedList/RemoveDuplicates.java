package LinkedList;
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}

public class RemoveDuplicates {
    Node head = null;

    void addAtLast(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    void display() {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void removeDupUnsorted() {
        if (head == null) return;

        HashSet<Integer> set = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (set.contains(current.data)) {
                prev.next = current.next; // skip duplicate
            } else {
                set.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        RemoveDuplicates list = new RemoveDuplicates();
        for (int i = 0; i < size; i++) {
            list.addAtLast(sc.nextInt());
        }

        // For sorted list, use: list.RemoveDup();
        // For unsorted list, use:
        list.removeDupUnsorted();
        list.display();
    }
}
