package Assignment_2;

public class CircularQueue<E extends Comparable<E>> {

   private int front;
   private int back;
   private E[] queue;
   private int size;
   private boolean isEmpty = true;

    public CircularQueue(int size) {
        queue = (E[]) new Comparable[size];
        front = 0;
        this.size = 0;
        back = 0;
    }

    public void enqueue(E element) {

        queue[back] = element;
        back++;
        size++;
        isEmpty();

    }

    public E dequeue() {
        E removed = null;
        if (isEmpty()) {
            return null;
        } else {
            removed = queue[front];
            queue[front] = null;
            size--;
            front++;
        }
        return removed;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }

        return queue[front];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            isEmpty = true;
            return isEmpty;
        }
        isEmpty = false;
        return isEmpty;
    }
}
