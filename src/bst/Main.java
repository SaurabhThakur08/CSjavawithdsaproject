package bst;

/**
 * Main.java — Driver class for BST Operation Tool
 *
 * Demonstrates:
 *  1. Insertion
 *  2. Search
 *  3. Deletion (leaf, one-child, two-children)
 *  4. All three traversals
 *  5. Min, Max, Height
 *  6. Visual tree print
 */
public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        printSection("1. INSERTION");
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        for (int v : values) bst.insert(v);
        bst.insert(50); // duplicate test

        printSection("2. TREE STRUCTURE");
        bst.printTree();

        printSection("3. TRAVERSALS");
        bst.inOrder();
        bst.preOrder();
        bst.postOrder();

        printSection("4. SEARCH");
        bst.search(40);
        bst.search(99);

        printSection("5. MIN / MAX / HEIGHT");
        System.out.println("Min    : " + bst.findMin());
        System.out.println("Max    : " + bst.findMax());
        System.out.println("Height : " + bst.height());

        printSection("6. DELETION");

        // Delete leaf node
        System.out.println("-- Deleting leaf node (10) --");
        bst.delete(10);
        bst.inOrder();

        // Delete node with one child
        System.out.println("-- Deleting one-child node (20) --");
        bst.delete(20);
        bst.inOrder();

        // Delete node with two children
        System.out.println("-- Deleting two-children node (30) --");
        bst.delete(30);
        bst.inOrder();

        // Delete non-existent node
        System.out.println("-- Deleting non-existent node (999) --");
        bst.delete(999);

        printSection("7. FINAL TREE STATE");
        bst.printTree();
        bst.inOrder();
        System.out.println("Height after deletions: " + bst.height());

        printSection("DONE");
    }

    private static void printSection(String title) {
        System.out.println("\n" + "═".repeat(45));
        System.out.println("  " + title);
        System.out.println("═".repeat(45));
    }
}
