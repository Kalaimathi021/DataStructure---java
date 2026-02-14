package Tree;

import java.util.Scanner;

class Node {
    char data;
    Node left;
    Node right;

    Node(char x) {
        data = x;
        left = null;
        right = null;
    }
}


class MyQueue {

    static class QNode {
        Node data;
        QNode next;

        QNode(Node data) {
            this.data = data;
        }
    }

    QNode front, rear;

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(Node data) {
        QNode newNode = new QNode(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    Node dequeue() {
        if (isEmpty())
            return null;

        Node temp = front.data;
        front = front.next;

        if (front == null)
            rear = null;

        return temp;
    }
}

public class BinaryTreeWOcollections{

    Node root = null;
    public void insert(char x) {

        Node newNode = new Node(x);

        if (root == null) {
            root = newNode;
            return;
        }

        MyQueue queue = new MyQueue();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node temp = queue.dequeue();

            if (temp.left == null) {
                temp.left = newNode;
                return;
            } else {
                queue.enqueue(temp.left);
            }

            if (temp.right == null) {
                temp.right = newNode;
                return;
            } else {
                queue.enqueue(temp.right);
            }
        }
    }

    public void delete() {
        root = null;
    }

    public void delete(char x) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (root.data == x)
                root = null;
            return;
        }

        Node key = null;
        Node temp = null;

        MyQueue queue = new MyQueue();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            temp = queue.dequeue();

            if (temp.data == x)
                key = temp;

            if (temp.left != null)
                queue.enqueue(temp.left);

            if (temp.right != null)
                queue.enqueue(temp.right);
        }

        if (key != null) {
            char val = temp.data;
            deleteof(val);
            key.data = val;
        }
    }

    public void deleteof(char x) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (root.data == x)
                root = null;
            return;
        }

        MyQueue queue = new MyQueue();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node temp = queue.dequeue();

            if (temp.left != null) {
                if (temp.left.data == x) {
                    temp.left = null;
                    return;
                } else {
                    queue.enqueue(temp.left);
                }
            }

            if (temp.right != null) {
                if (temp.right.data == x) {
                    temp.right = null;
                    return;
                } else {
                    queue.enqueue(temp.right);
                }
            }
        }
    }

    public void levelOrder(Node root) {
        if (root == null)
            return;

        MyQueue queue = new MyQueue();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node temp = queue.dequeue();
            System.out.print(temp.data + " ");

            if (temp.left != null)
                queue.enqueue(temp.left);

            if (temp.right != null)
                queue.enqueue(temp.right);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            tree.insert(sc.next().charAt(0));
        }

        System.out.println("Before Deletion:");
        tree.levelOrder(tree.root);

        tree.delete('c');

        System.out.println("\nAfter Deletion:");
        tree.levelOrder(tree.root);

        sc.close();
    }
}
