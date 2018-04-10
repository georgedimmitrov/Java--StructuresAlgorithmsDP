package DataStructures;

public class BinarySearchTree {
    BinarySearchTreeNode root;

    BinarySearchTree() {
        this.root = null;
    }


    public void insert(int value) {
        if (this.root == null) {
            this.root = new BinarySearchTreeNode(value);
            return;
        }

        BinarySearchTreeNode parent = null;
        BinarySearchTreeNode current = this.root;

        while (current != null) {
            // very important to know thy parent!
            parent = current;

            if (current.getValue() < value) {
                current = current.getRight();
            } else if (current.getValue() > value) {
                current = current.getLeft();
            } else {
                // value you are inserting is already in tree
                return;
            }
        }

        // if we get to here -> current is OK to be inserted, just need to set parent to point at it
        // we check if the value of the new node is > or < than parent and insert it on right/left respectively
        if (parent.getValue() < value) {
            parent.setRight(new BinarySearchTreeNode(value));
        } else {
            parent.setLeft(new BinarySearchTreeNode(value));
        }
    }

    public boolean search(int value) {
        if (this.root == null) {
            return false;
        }

        BinarySearchTreeNode current = this.root;

        while (current != null) {
            if (current.getValue() < value) {
                current = current.getRight();
            } else if (current.getValue() > value) {
                current = current.getLeft();
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean delete(int value) {
        if (this.root == null) {
            return false;
        }

        BinarySearchTreeNode current = this.root;
        BinarySearchTreeNode parent = null;

        while (current.getValue() != value) {
            // keep pointer to parent
            parent = current;

            if (current.getValue() > value) {
                current = current.getLeft();
            } else if (current.getValue() < value) {
                current = current.getRight();
            }

            if (current == null) {
                // value not in tree
                return false;
            }
        }

        // case 1 - current is leaf node
        if ((current.getLeft() == null) && (current.getRight() == null)) {
            if (current == this.root) {
                this.root = null;
            } else if (parent.getValue() < current.getValue()) {
                parent.setRight(null);
            } else {
                parent.setLeft(null);
            }

            return true;
        }

        // case 2 - current has one child only
        if (current.getLeft() == null) {
            if (current == this.root) {
                this.root = current.getRight();
            } else if (parent.getValue() < current.getValue()) {
                parent.setRight(current.getRight());
            } else {
                parent.setLeft(current.getRight());
            }

            return true;
        } else if (current.getRight() == null) {
            if (current == this.root) {
                this.root = current.getLeft();
            } else if (parent.getValue() < current.getValue()) {
                parent.setRight(current.getLeft());
            } else {
                parent.setLeft(current.getLeft());
            }

            return true;
        }

        // case 3 - current has two children
        if ((current.getLeft() != null) && (current.getRight() != null)) {
            // get biggest number of left subtree
            BinarySearchTreeNode successor = getBiggestNodeFromLeftSubtree(current);

            // set its left/right children to the left/right children of node we want to delete
            successor.setLeft(current.getLeft());
            successor.setRight(current.getRight());

            // only thing left is to change the reference in the parent of the node we want to delete
            if (current == this.root) {
                this.root = successor;
            } else if (parent.getValue() < successor.getValue()) {
                parent.setRight(successor);
            } else {
                parent.setLeft(successor);
            }

            return true;
        }

        return false;
    }


    private BinarySearchTreeNode getBiggestNodeFromLeftSubtree(BinarySearchTreeNode start) {
        BinarySearchTreeNode parent = start.getLeft(); // in left subtree
        BinarySearchTreeNode rightChild = parent.getRight(); // represents most right node

        // in this case left subtree of start has no right child
        if (rightChild == null) {
            start.setLeft(parent.getLeft());
            return parent;
        }

        while (rightChild.getRight() != null) {
            parent = rightChild;
            rightChild = rightChild.getRight();
        }
        //in rightChild is the most right (biggest) node
        //  if biggest node has leftChild it will be set as right child of parent
        //  if leftChild is null, the right child of parent will be also null
        parent.setRight(rightChild.getLeft());

        return rightChild;
    }

    private int getHeight(BinarySearchTreeNode current) {
        if (current == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(current.getLeft()), getHeight(current.getRight()));
    }
}
