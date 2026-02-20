import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


class LinkedList1 {

    Node head;

    // Insert at end
    void insert(int data) {
        Node newNode = new Node(data);

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

    // Move even numbers to end
    void moveEvenToEnd() {

        Node oddHead = null, oddTail = null;
        Node evenHead = null, evenTail = null;

        Node current = head;

        while (current != null) {

            if (current.data % 2 != 0) {  // odd
                if (oddHead == null) {
                    oddHead = oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            } else {  // even
                if (evenHead == null) {
                    evenHead = evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            }

            current = current.next;
        }

        if (oddTail != null)
            oddTail.next = evenHead;

        if (evenTail != null)
            evenTail.next = null;

        head = (oddHead != null) ? oddHead : evenHead;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList1 list = new LinkedList1();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            list.insert(value);
        }

        System.out.println("\nOriginal List:");
        list.display();

        list.moveEvenToEnd();

        System.out.println("After Moving Even Numbers:");
        list.display();

        sc.close();
    }
}
