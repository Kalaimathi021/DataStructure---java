import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {

    Node head=null;

    // Insert at end
    public void insert(int data) {
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

    // Merge two lists
    public static Node merge(Node head1, Node head2) {
        if (head1 == null) return head2;

        Node temp = head1;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head2;
        return head1;
    }

    // Remove duplicates WITHOUT HashSet
    public static Node removeDuplicates(Node head) {

        Node current = head;

        while (current != null) {

            Node runner = current;
            while (runner.next != null) {

                if (runner.next.data == current.data) {
                    runner.next = runner.next.next; // delete duplicate
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }

        return head;
    }

    // Display
    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        System.out.print("Enter number of elements in first list: ");
        int n1 = sc.nextInt();

        System.out.println("Enter elements of first list:");
        for (int i = 0; i < n1; i++) {
            list1.insert(sc.nextInt());
        }

        System.out.print("Enter number of elements in second list: ");
        int n2 = sc.nextInt();

        System.out.println("Enter elements of second list:");
        for (int i = 0; i < n2; i++) {
            list2.insert(sc.nextInt());
        }

        // Merge
        Node mergedHead = merge(list1.head, list2.head);

        // Remove duplicates
        mergedHead = removeDuplicates(mergedHead);

        System.out.println("Merged List After Removing Duplicates:");
        display(mergedHead);
    }
}
