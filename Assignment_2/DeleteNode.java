package Assignment_2;

public class DeleteNode<E extends Comparable<E>> {
   
   
    public void delete(Node<E> node)
    {
        node.data = node.next.data;
        node.next = node.next.next;
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
