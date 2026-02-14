package Tree;

import java.util.LinkedList;
import java.util.Queue;
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

public class BinaryTree {

    Node root = null;

    public void insert(char x) {

        Node newNode = new Node(x);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left == null) {
                temp.left = newNode;
                return;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = newNode;
                return;
            } else {
                queue.add(temp.right);
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

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.data == x) {
                key = temp;
            }

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);
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

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left != null) {
                if (temp.left.data == x) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }

            if (temp.right != null) {
                if (temp.right.data == x) {
                    temp.right = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }
        }
    }

    public void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);
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
