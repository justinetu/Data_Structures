public class BinarySearchTree {
    Node root = null;

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    void insert(int val) {
        Node node = new Node(val);

        while (true) {
            if (root == null) {
                root = node;
                break;
            }
            if (node.value < root.value) { // Checks if added node is less than current node
                if (root.left == null) {
                    root.left = node;
                    break;
                } else {
                    root = root.left;
                }
            } else { // Checks if the added node is greater than current node
                if (root.right == null) {
                    root.right = node;
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        //System.out.println(root.value);
    }
    boolean lookup(int value) {
        Node curr = root;
        Node find = new Node(value);
        while(curr != null) {
            if(find.value == curr.value)
                return true;
            else if(find.value < curr.value)
                curr = curr.left;
            else
                curr = curr.right;
        }
        return false;
    }
    void remove(int value) {
        Node parent = null;
        Node curr = root;
        while(curr != null) {
            if(value > curr.value) {
                parent = curr;
                curr = curr.right;
            }
            else if(value < curr.value) {
                parent = curr;
                curr = curr.left;
            }
            // value == curr.value
            else {
//                if(curr.right == null) {
//                    if(parent == null) {
//                        root = curr.left;
//                    }
//                }
                // Right child with a left child
                if(curr.right != null) {
                    if(curr.right.left != null) {
                        parent.right = curr.right.left;
                        curr.right.left = null;
                        break;
                    }
                    // Right child with no left child
                    else {
                        parent.right = curr.right;
                        break;
                    }
                }
                // curr.right == null
                else {
                    // A left child with a right child
                    if(curr.left != null) {
                        if(curr.left.right != null) {
                            parent.right = curr.left.right;
                            break;
                        }
                        // Left child with no right child
                        else {
                            parent.right = curr.left;
                            break;
                        }
                    }
                    // No left child
                    else {
                        parent.right = null;
                        break;
                    }
                }
            }
        }
    }
    void printTree(Node r) {
        // Prints all the nodes in the right subtree
        Node n = r;
        while(n != null) {
            System.out.println(n.value + " ");
            n = n.right;
        }
        n = root.left;
        while(n != null) {
            System.out.println(n.value + " ");
            n = n.left;
        }
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(8);
        bst.insert(2);
        bst.printTree(bst.root);
        System.out.println(bst.lookup(2));
    }
}
