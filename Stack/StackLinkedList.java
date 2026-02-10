package Stack;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class StackLinkedList {

    Node top = null;
    int size = 0;

    // PUSH
    void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // POP
    void pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println("Popped element is " + top.data);
        top = top.next;
        size--;
    }

    void peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top element is " + top.data);
    }

    
    void display() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }
        Node temp = top;
        System.out.print("Stack elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    
    boolean isEmpty() {
        return top == null;
    }

    void reverse() {
        Node prev = null;
        Node curr = top;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        top = prev;
    }

    
    int size() {
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackLinkedList st = new StackLinkedList();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        st.display();
        st.peek();
        st.pop();

        st.display();

        // optional test
        st.reverse();
        System.out.print("After reverse: ");
        st.display();

        sc.close();
    }
}



