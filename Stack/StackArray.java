package Stack;

import java.util.Scanner;

class Stack {
    int[] arr;
    int top;
    int capacity;

    Stack(int n) {
        capacity = n;
        arr = new int[n];
        top = -1;
    }

    void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        arr[top]=x;
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println("Popped element is " + arr[top]);
        top--;
    }

    void peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Peek element is " + arr[top]);
    }

    void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == capacity - 1;
    }

    // REVERSE STACK (EASIEST WAY FOR ARRAY)
    void reverse() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }

        int i = 0, j = top;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

public class StackArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack st = new Stack(n);

        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        System.out.print("Original stack: ");
        st.display();

        st.peek();
        st.pop();

        System.out.print("After pop: ");
        st.display();

        st.reverse();
        System.out.print("After reverse: ");
        st.display();

        sc.close();
    }
}
