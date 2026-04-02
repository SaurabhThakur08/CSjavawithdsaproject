package bst;

/**
 * Represents a single node in the Binary Search Tree.
 */
public class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
