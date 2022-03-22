package Assignment_3;

import java.util.LinkedList;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

/**
 * BinaryTree
 * 
 * @author Andrew Estes
 * @NetID ace190002
 */
public class ThreadedBinarySearchTree<E extends Comparable<E>> {

    /**
     * Points to the root node in the Binary Tree
     */
    Node<E> root = null;

    /**
     * Points to the current node being viewed/manipulated by the various methods in
     * the BinaryTree class
     */
    Node<E> currentNode = root;

    /**
     * Points to the parent node of the current node being viewed/manipulated by the
     * various methods in BinaryTree class
     */
    Node<E> parentNode = new Node<E>(null, null, null);

    /**
     * Creates an empty binary tree
     */
    public ThreadedBinarySearchTree() {

    }

    /**
     * Sets Root node if there is none yet
     * 
     * @param data
     */
    private void createRootNode(E data) {
        Node<E> newNode = new Node<E>(null, data, null);
        root = newNode;
    }

    public void insert(E data) {
       root = insertFunction(root, data);
    }

    /**
     * Inserts nodes into Threaded binary search tree
     * 
     * @param data
     */

    private Node<E> insertFunction(Node<E> root, E data) {
        currentNode = root;
        parentNode = null;
       
        //While loop to traverse layers of BST
        while (currentNode != null) {
            if (currentNode.data == data) {
                System.out.println("Node already exists in BST\n");
            }

            parentNode = currentNode;

            //Traverse left subnodes
            if (currentNode.hasLeftThread == false) {
                currentNode = currentNode.left;
            } else {
                break;
            }

            //Traverse right subnodes
            if (currentNode.hasRightThread == false) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }

        //Add new Node
        Node<E> newNode = new Node<E>(null, data, null);
        newNode.hasLeftThread = true;
        newNode.hasRightThread = true;

        if (parentNode == null)
        {
            root = newNode;
        } else if (data.compareTo(parentNode.data) < 0)
        {
            newNode.left = parentNode.left;
            newNode.right = parentNode; 
            parentNode.left = newNode;
            parentNode.left.hasLeftThread = false;
        } else if (data.compareTo(parentNode.data) > 0)
        {
            newNode.right = parentNode.right;
            newNode.left = parentNode;
            parentNode.right = newNode;
            parentNode.right.hasRightThread = false;
        }
        currentNode = root;
        return currentNode;
    }

    /**
     * Inserts node into Threaded Binary Search Tree recursively
     * 
     * @param data
     */
    public void recursiveInsert(E data) {
        if (root == null) {
            Node<E> newNode = new Node<E>(null, data, null);
            root = newNode;
            currentNode = root;
            return;
        }

        if (data.compareTo(currentNode.data) < 0) {
            if (currentNode.left == null) {
                currentNode.left = new Node<E>(null, data, null);
                currentNode.left.hasLeftThread = true;
                currentNode.left.hasRightThread = true;
                currentNode.hasLeftThread = false;
            }
            parentNode = currentNode;
            currentNode = currentNode.left;
            recursiveInsert(data);
        } else if (data.compareTo(currentNode.data) > 0) {
            if (currentNode.right == null) {
                currentNode.right = new Node<E>(null, data, null);
                currentNode.right.hasLeftThread = true;
                currentNode.right.hasRightThread = true;
                currentNode.hasRightThread = false;
            }
            parentNode = currentNode;
            currentNode = currentNode.right;
            recursiveInsert(data);
        }
        currentNode = root;
        return;
    }

    /**
     * Calls the searchFunction method
     * 
     * @param node
     * @return
     */
    public boolean search(E node) {
        boolean exists = false;
        Node<E> searchNode = new Node<E>(null, node, null);
        if (searchFunction(searchNode) != null) {
            exists = true;
        }
        return exists;
    }

    /**
     * Searches through the Binary Tree for the specified Node
     * 
     * @param desiredNode
     * @return
     */
    private Node<E> searchFunction(Node<E> desiredNode) {
        Node<E> foundNode = null;
        if (currentNode == null) {
            return currentNode;
        } else if (currentNode.data == desiredNode.data) {
            foundNode = currentNode;
            currentNode = root;
            return foundNode;
        }
        if (desiredNode.data.compareTo(currentNode.data) < 0) {
            currentNode = currentNode.left;
            foundNode = searchFunction(desiredNode);
            return foundNode;

        } else if (desiredNode.data.compareTo(currentNode.data) > 0) {
            currentNode = currentNode.right;
            foundNode = searchFunction(desiredNode);
            return foundNode;
        } else if (desiredNode.data.compareTo(currentNode.data) == 0) {
            foundNode = currentNode;
            return foundNode;
        }
        currentNode = root;
        return foundNode;
    }

    /**
     * Calls getNode and returns the data of the specified node
     * 
     * @param node
     * @return data of specified node
     */
    public E get(E node) {
        Node<E> tempNode = new Node<E>(null, node, null);
        Node<E> foundNode = getNode(tempNode);
        if (foundNode == null) {
            currentNode = root;
            return root.data;
        }
        currentNode = root;
        return foundNode.data;
    }

    /**
     * Finds and returns the specified Node
     * 
     * @param node
     * @return specified Node
     */
    private Node<E> getNode(Node<E> node) {
        Node<E> foundNode = searchFunction(node);
        return foundNode;
    }

    /**
     * Calls the deleteFunction method and removes the desired node from the Binary
     * Search Tree
     * 
     * @param node
     */
    public void delete(E data) {
        root = deleteFunction(root, data);
    }

    /**
     * Removes the specified node from the Binary Search Tree
     * 
     * @param desiredNode
     * @return true if the node was successfully removed, false if the node does not
     *         exist in the tree.
     */
    private Node<E> deleteFunction(Node<E> rootNode, E data) {
        if (rootNode == null)
            return rootNode;
        if (data.compareTo(rootNode.data) < 0)
            rootNode.left = deleteFunction(rootNode.left, data);
        else if (data.compareTo(rootNode.data) > 0)
            rootNode.right = deleteFunction(rootNode.right, data);
        else {
            if (rootNode.left == null)
                return rootNode.right;
            else if (rootNode.right == null)
                return rootNode.left;
            rootNode.data = replacementNode(rootNode.right);
            rootNode.right = deleteFunction(rootNode.right, rootNode.data);
        }
        return rootNode;
    }

    /**
     * Finds the smallest node of the right child to replace the node being removed.
     * 
     * @param root
     * @return replacement value
     */
    @SuppressWarnings("unchecked")
    private E replacementNode(Node<E> rightChild) {
        Object replacement = rightChild.data;
        while (rightChild.left != null) {
            replacement = rightChild.left.data;
            rightChild = rightChild.left;
        }

        return (E) replacement;
    }

    /**
     * Calls the inOrderTraversal method and iterates through the binary tree and
     * prints the results out in order
     */
    public List printInOrder() {
        List list = inOrderTraversal(root);
        return list;
    }

    /**
     * Iterates through the binary tree and prints the results out in order
     * 
     * @param currentNode
     */
    List<E> list = new LinkedList();

    private List inOrderTraversal(Node<E> currentNode) {
        if (currentNode != null) {
            inOrderTraversal(currentNode.left);
            list.add(currentNode.data);
            inOrderTraversal(currentNode.right);
        }
        return list;
    }

    /**
     * Resets the currentNode memeber to the root node
     */
    private void resetCurrent() {
        currentNode = root;
    }

    private class Node<T> {
        /**
         * The element stored in the node
         */
        E data;
        /**
         * points to the right child node
         */
        Node<E> right;
        /**
         * points to the left child node
         */
        Node<E> left;
        /**
         * points to left thread
         */
        boolean hasLeftThread;
        /**
         * points to right thread
         */
        boolean hasRightThread;

        /**
         * Creates Node object
         * 
         * @param left
         * @param data
         * @param right
         */
        private Node(Node<E> left, E data, Node<E> right) {
            this.data = data;
            this.right = right;
            this.left = left;
        }
    }
}
