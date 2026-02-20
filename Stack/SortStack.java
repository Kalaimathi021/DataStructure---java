package Stack;

import java.util.Scanner;

public class SortStack {

    static int top = -1;
    static int[] stack;

    public static void push(int value) {
        stack[++top] = value;
    }

    public static int pop() {
        return stack[top--];
    }

    public static int peek() {
        return stack[top];
    }

    public static boolean isEmpty() {
        return top == -1;
    }

    public static void sort() {
        if (!isEmpty()) {
            int temp = pop();
            sort();
            insert(temp);
        }
    }

    public static void insert(int value) {
        if (isEmpty() || peek() <= value) {
            push(value);
            return;
        }

        int temp = pop();
        insert(value);
        push(temp);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        stack = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            push(sc.nextInt());
        }

        sort();

        System.out.println("Sorted Stack (Ascending Order):");

        while (!isEmpty()) {
            System.out.println(pop());
        }

        sc.close();
    }
}
