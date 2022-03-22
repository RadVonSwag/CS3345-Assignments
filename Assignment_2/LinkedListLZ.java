package Assignment_2;

/**
 * LinkedListLZ
 * 
 * @author Andrew Estes
 * @NetID ace190002
 */
public class LinkedListLZ<E extends Comparable<E>> {

    // Implement a generic linkedlist to support different data types.
    // Use this class instead of using ArrayList.
    // Create another class that represents the node of a linkedlist.

    /**
     * Points to the first node in the list
     */
    Node<E> first;
    /**
     * Points to the last node in the list
     */
    Node<E> last;
    /**
     * Stores the total number of elements in the list
     */
    int size = 0;

    /**
     * Creates an empty LinkedListLZ.
     */
    public LinkedListLZ() {

    }

    /**
     * Creates an LinkedListLZ containing full array of elements.
     * 
     * @param elements
     */
    public LinkedListLZ(E[] elements) {
        this();
        CreateLinkedList(elements);
    }

    /**
     * Creates the nodes of the Linked List based on parameter.
     * 
     * @param elements
     */
    public boolean CreateLinkedList(E[] elements) {
        if (elements.length == 0) {
            return false;
        }

        for (int i = 0; i < elements.length; i++) {
            Add(elements[i]);
        }
        return true;
    }

    /**
     * Returns the first element in the list.
     * 
     * @return the first element in the list
     */
    public E GetFirst() {
        return first.data;
    }

    /**
     * Returns the last element in the list.
     * 
     * @return the last element in the list
     */
    public E GetLast() {
        return last.data;
    }

    /**
     * Adds a new element to the end of the list.
     * 
     * @param e
     */
    public void Add(E e) {
        Node<E> newNode = new Node<E>(last, e, null);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            Node<E> f = first;
            while (f.next != null) {
                f = f.next;
            }
            f.next = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     * Inserts a new node at the specified index NOT FULLY RESOLVED DOES NOT WORK
     * PROPERLY
     * 
     * @param index
     * @param element
     */
    public void Insert(int index, E element) {
        if (index == size) {
            Add(element);
            return;
        }
        Node<E> loserNode = GetNode(index); // loser node is being pushed back one space in the list to make room for
                                            // the new node
        addBefore(loserNode, element);
    }

    /**
     * The addBefore function complements the insert function.
     * @param node
     * @param data
     */
    private void addBefore(Node<E> node, E data)
    {
        Node<E> newNode = new Node<E>(node.prev, data, node);
        newNode.prev.next = newNode;
        node.prev = newNode;
        size++;
    }

    /**
     * Removes element at specified index.
     * 
     * @param index
     * @return "success" if successful, null if unsuccessful
     */
    public void lazyDelete(int index) {
        Node<E> nodeToRemove = GetNode(index);
        if (nodeToRemove.isDeleted == true) {
            System.out.println("The node at index " + index + " has already been removed.");
            return;
        } else {
            SetDeleted(index);
        }

        // not decreasing size since the nodes are technically not deleted.

    }

    public void SetDeleted(int index) throws ArrayIndexOutOfBoundsException {
        Node<E> currentNode = new Node<E>(null, null, null);
        if ((index >= size) || (index < 0)) {
            System.out.println("Element could not be changed at index" + index + ". Specified index is out of bounds.");
        } else if (index == size - 1) {
            Node<E> rightElement = last;
            rightElement.isDeleted = true;
            currentNode = rightElement;
        } else {
            if (index < (size / 2)) {
                Node<E> leftElement = first;
                for (int i = 0; i < index; i++) {
                    leftElement = leftElement.next;
                }
                leftElement.isDeleted = true;
                currentNode = leftElement;
            } else {
                Node<E> rightElement = last;
                for (int i = size - 1; i > index; i--) {
                    rightElement = rightElement.prev;
                }
                rightElement.isDeleted = true;
                currentNode = rightElement;
            }
        }
    }

    public Node<E> GetNode(int index) {
        Node<E> currentNode = new Node<E>(null, null, null);
        if (index == 0) {
            return first;
        } else if (index == size - 1) {
            return last;
        } else if ((index >= size) || (index < 0)) {
            throw new IndexOutOfBoundsException(
                    "Element could not be identified at index" + index + ". Specified index is out of bounds.");
        } else {
            if (index < (size / 2)) {
                Node<E> leftElement = first;
                for (int i = 0; i < index; i++) {
                    leftElement = leftElement.next;
                }
                currentNode = leftElement;
            } else {
                Node<E> rightElement = last;
                for (int i = size - 1; i > index; i--) {
                    rightElement = rightElement.prev;
                }
                currentNode = rightElement;
            }
        }
        return currentNode;
    }

    /**
     * Method is called Stringy because there were issues with a previous toString() method. The toString() method used the same lines of code, but caused issues with my IDE during runtime and debugging.
     * @return
     */
    public String Stringy() {
        String result = String.valueOf(first.data);
        Node<E> currentNode = first.next;
        while (currentNode != null) {
            if (currentNode.isDeleted == true) {
                currentNode = currentNode.next;
                continue;
            }
            result = result + ", " + currentNode.data;
            currentNode = currentNode.next;
        }

        return result;
    }

    /**
     * Determines whether or not the list contains the specified element.
     * 
     * @param element
     * @return true if element is in list, false if it is not in the list
     */
    public boolean Contains(E element) {
        Node<E> currentNode = first;
        while (currentNode != null) {
            if (currentNode.data == element) {
                if (currentNode.isDeleted == true) {
                    return false;
                }
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }
    
    /**
     * Returns the Length of the list
     * 
     * @return the length of the list
     */
    public Integer GetLength() {
        return size;
    }

    private class Node<E> {
        /**
         * The element stored in the node
         */
        E data;
        /**
         * points to the next node
         */
        Node<E> next;
        /**
         * points to the previous node
         */
        Node<E> prev;

        boolean isDeleted;

        /**
         * Creates Node object to be used and manipulated in LinkedListLZ
         * 
         * @param prev
         * @param data
         * @param next
         */
        private Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}