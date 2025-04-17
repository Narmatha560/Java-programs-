class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    Node root;

    void delete(int data) {
        root = deleteNode(root, data);
    }

    Node deleteNode(Node currentNode, int data) {
        if (currentNode == null) {
            return currentNode;
        }

        // Traverse the tree to find the node to delete
        if (data < currentNode.data) {
            currentNode.left = deleteNode(currentNode.left, data);
        } else if (data > currentNode.data) {
            currentNode.right = deleteNode(currentNode.right, data);
        } else {
            // Node to be deleted is found

            // Case 1: Node has no child (leaf node)
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            }

            // Case 2: Node has one child
            if (currentNode.left == null) {
                return currentNode.right;
            } else if (currentNode.right == null) {
                return currentNode.left;
            }

            // Case 3: Node has two children
            // Find the in-order successor (smallest value in the right subtree)
            currentNode.data = minValue(currentNode.right);

            // Delete the in-order successor
            currentNode.right = deleteNode(currentNode.right, currentNode.data);
        }
        return currentNode;
    }

    int minValue(Node node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    void printTree() {
        printTree(root);
    }

    void printTree(Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.data + " "); // Adding a space for readability
            printTree(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node(50);
        bst.root.left = new Node(30);
        bst.root.right = new Node(70);
        bst.root.right.left = new Node(20);
        bst.root.left.right = new Node(40);

        System.out.print("Before deletion: ");
        bst.printTree(); // Expected output: 20 30 40 50 70

        bst.delete(30); // Delete node with value 20

        System.out.print("\nAfter deletion: ");
        bst.printTree(); // Expected output: 30 40 50 70
    }
}

