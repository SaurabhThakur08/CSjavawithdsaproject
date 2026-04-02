package bst;

/**
 * BinarySearchTree - Core BST implementation.
 *
 * Supports:
 *  - Insertion     : O(log n) average
 *  - Deletion      : O(log n) average
 *  - Search        : O(log n) average
 *  - Traversals    : In-order, Pre-order, Post-order  — all O(n)
 *  - Height        : O(n)
 *  - Min / Max     : O(log n) average
 */
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // ─────────────────────────────────────────
    //  INSERT
    // ─────────────────────────────────────────

    /**
     * Public insert — adds a value to the BST.
     */
    public void insert(int data) {
        root = insertRec(root, data);
        System.out.println("Inserted: " + data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        } else {
            System.out.println("  [Warning] Duplicate value " + data + " ignored.");
        }
        return root;
    }

    // ─────────────────────────────────────────
    //  SEARCH
    // ─────────────────────────────────────────

    /**
     * Public search — returns true if the value exists in the BST.
     */
    public boolean search(int data) {
        boolean found = searchRec(root, data);
        System.out.println("Search " + data + ": " + (found ? "Found ✓" : "Not Found ✗"));
        return found;
    }

    private boolean searchRec(Node root, int data) {
        if (root == null) return false;
        if (data == root.data) return true;
        return data < root.data
                ? searchRec(root.left, data)
                : searchRec(root.right, data);
    }

    // ─────────────────────────────────────────
    //  DELETE
    // ─────────────────────────────────────────

    /**
     * Public delete — removes a value from the BST.
     */
    public void delete(int data) {
        if (!search(data)) {
            System.out.println("  [Warning] Value " + data + " not found; nothing deleted.");
            return;
        }
        root = deleteRec(root, data);
        System.out.println("Deleted: " + data);
    }

    private Node deleteRec(Node root, int data) {
        if (root == null) return null;

        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // Case 1: Leaf node
            if (root.left == null && root.right == null) return null;

            // Case 2: One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Two children — replace with in-order successor
            int minVal = findMin(root.right);
            root.data = minVal;
            root.right = deleteRec(root.right, minVal);
        }
        return root;
    }

    // ─────────────────────────────────────────
    //  MIN / MAX / HEIGHT
    // ─────────────────────────────────────────

    public int findMin() {
        if (root == null) throw new RuntimeException("Tree is empty.");
        return findMin(root);
    }

    private int findMin(Node node) {
        return node.left == null ? node.data : findMin(node.left);
    }

    public int findMax() {
        if (root == null) throw new RuntimeException("Tree is empty.");
        return findMax(root);
    }

    private int findMax(Node node) {
        return node.right == null ? node.data : findMax(node.right);
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    public boolean isEmpty() {
        return root == null;
    }

    // ─────────────────────────────────────────
    //  TRAVERSALS
    // ─────────────────────────────────────────

    /** In-order traversal (Left → Root → Right) → sorted output */
    public void inOrder() {
        System.out.print("In-Order    : ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node == null) return;
        inOrderRec(node.left);
        System.out.print(node.data + " ");
        inOrderRec(node.right);
    }

    /** Pre-order traversal (Root → Left → Right) */
    public void preOrder() {
        System.out.print("Pre-Order   : ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderRec(node.left);
        preOrderRec(node.right);
    }

    /** Post-order traversal (Left → Right → Root) */
    public void postOrder() {
        System.out.print("Post-Order  : ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node node) {
        if (node == null) return;
        postOrderRec(node.left);
        postOrderRec(node.right);
        System.out.print(node.data + " ");
    }

    // ─────────────────────────────────────────
    //  VISUAL TREE PRINT
    // ─────────────────────────────────────────

    /** Prints a sideways ASCII tree for easy visualization. */
    public void printTree() {
        System.out.println("Tree Structure (rotated 90° — right is top):");
        printTreeRec(root, "", true);
    }

    private void printTreeRec(Node node, String prefix, boolean isLeft) {
        if (node == null) return;
        printTreeRec(node.right, prefix + (isLeft ? "│   " : "    "), false);
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);
        printTreeRec(node.left, prefix + (isLeft ? "    " : "│   "), true);
    }
}
