package Assignment_2;

/**
 * Deque class for Assignment 2 CS3345
 * 
 * @author Andrew Estes
 * @version 1.0
 */
public class Deque<E extends Comparable<E>> {

    Node<E> front;

    Node<E> end;

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

        /**
         * Creates Node object
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

    /**
     * inserts x at the front of the deque
     * 
     * @param x
     */
    public void push(E x) {
        Node<E> newNode = new Node<E>(front, x, end); //Creates a new node to be added to the deque
        if (front == null) //initial case if the deque is empty
        {
            front = newNode; //set both the front and end to newNode (since there's only one) newNode.prev/.next should be null
            end = newNode;
        } else {
            Node<E> e = end; //create a new node to shift the rest of the elements of the deque through as as newNode gets added to the beginning
            while (e.prev != null) {
                e = e.prev;
            }
            e.prev = newNode; //will set the previous node to newNode until it reaches the front of the deque
            front = newNode; //will set the front of the list to newNode once the other elements have been readjusted
            front.next = front.prev; //correcting a mixup... method initially developed to insert element at the end
            front.prev = null;
        }
        
    }

    /**
     * removes element from the front of deque
     */
    public void pop() {
        front = front.next;
        front.prev = null;
    }

    /**
     * inserts element at the end of deque
     * 
     * @param x
     */
    public void inject(E x) {
        Node<E> newNode = new Node<E>(end, x, null); //Create new node to be added to the deque
        if (front == null) { //base caes for empty deque
            front = newNode;
            end = newNode;
        } else {
            Node<E> f = front; //create a temp node to shift the rest of the deque elements through as newNode is added to the end
            while (f.next != null) {
                f = f.next;
            }
            f.next = newNode; //sets the next node to newNode until it reaches the end of the deque
            end = newNode; //sets the end node to newNode once the rest of the elements have been adjusted.
            end.next = null;
        }
    }

    /**
     * removes element from the end of deque
     */
    public void eject() {
        end = end.prev;
        end.next = null;
    }

}
