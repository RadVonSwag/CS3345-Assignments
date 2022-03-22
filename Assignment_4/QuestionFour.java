package Assignment_4;

import java.util.LinkedList;

public class QuestionFour<E extends Comparable<E>> {

    LinkedList heap = new LinkedList();
    E root = (E) heap.get(0);

    public void deleteMin() {
        // Delete root leaving a hole at the root- takes O(1) time
        // Move hole down to leaf (removing the leaf)
        // Binary Search for new min to replace root, comparing both child nodes to make swaps - BS takes O(loglogN) time
        // Total runtime is O(1) + logN + loglogN

        // LinkedList implementation

        if (heap.isEmpty()) {
            System.out.println("nothing removed. Heap is empty.");
            return;
        }
        heap.removeFirst();
        E newMin;
        int i = 0;
        E node = (E) heap.get(i);
        E leftChild = (E) heap.get(2 * i);
        E rightChild = (E) heap.get((2 * i) + 1);

        if (leftChild.compareTo(rightChild) < 0)
        {
            newMin = leftChild;
        
        }






  //      deleteHelper(heap, 0);

    }

    public LinkedList deleteHelper(LinkedList heapHeap, int index) {
        LinkedList newHeap = heapHeap;
        E node = (E) heap.get(index);
        E leftChild = (E) heap.get(2 * index);
        E rightChild = (E) heap.get((2 * index) + 1);

        if (leftChild.compareTo(rightChild) < 0) {
            node = leftChild;
            newHeap.set(index, leftChild);
            index = (index * 2);
            deleteHelper(newHeap, index);

        } else if (leftChild.compareTo(rightChild) > 0) {

        }
        return newHeap;
    }

    private class Node<T> {
        /**
         * The element stored in the node
         */
        E data;
        /**
         * points to the right node
         */
        Node<E> right;
        /**
         * points to the left node
         */
        Node<E> left;

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
