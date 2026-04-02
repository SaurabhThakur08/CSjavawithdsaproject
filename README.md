# BST Operation Tool

**Java | Data Structures & Algorithms**

A robust, well-documented Binary Search Tree (BST) implementation in Java — built for clarity, correctness, and performance.

---

## Features

| Operation      | Time Complexity |
|----------------|----------------|
| Insert         | O(log n) avg   |
| Search         | O(log n) avg   |
| Delete         | O(log n) avg   |
| Traversals     | O(n)           |
| Height         | O(n)           |
| Min / Max      | O(log n) avg   |

- ✅ Insertion with duplicate detection  
- ✅ Deletion — handles all 3 cases (leaf, one child, two children)  
- ✅ Search with clear Found / Not Found output  
- ✅ In-Order, Pre-Order, Post-Order traversals  
- ✅ ASCII visual tree print  
- ✅ Min, Max, Height utilities  
- ✅ Clean OOP design — modular `Node` + `BinarySearchTree` + `Main`

---

## Project Structure

```
BST-Operation-Tool/
└── src/
    └── bst/
        ├── Node.java              # BST node (data, left, right)
        ├── BinarySearchTree.java  # Core BST logic
        └── Main.java              # Driver / demo
```

---

## How to Run

### Using terminal

```bash
# Compile
javac -d out src/bst/*.java

# Run
java -cp out bst.Main
```

### Using an IDE (IntelliJ / Eclipse / VS Code)
1. Open the `src/` folder as the source root.
2. Run `Main.java`.

---

## Sample Output

```
═════════════════════════════════════════════
  1. INSERTION
═════════════════════════════════════════════
Inserted: 50
Inserted: 30
...

═════════════════════════════════════════════
  3. TRAVERSALS
═════════════════════════════════════════════
In-Order    : 10 20 25 30 35 40 45 50 60 70 80
Pre-Order   : 50 30 20 10 25 40 35 45 70 60 80
Post-Order  : 10 25 20 35 45 40 30 60 80 70 50
```

---

## OOP Design Highlights

- **`Node`** — encapsulates tree node data; decoupled from tree logic.  
- **`BinarySearchTree`** — single responsibility: all tree operations in one cohesive class with private recursive helpers.  
- **`Main`** — clean driver; zero business logic, pure demonstration.

---

## Author

**Saurabh Thakur**  
[GitHub → SaurabhThakur08](https://github.com/SaurabhThakur08)
