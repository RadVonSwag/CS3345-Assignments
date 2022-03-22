package Assignment_2;

public class CircQueueTest {
    

    public static void main(String[] args) {
        CircularQueue<String> newQ = new CircularQueue<String>(8);
        System.out.println(newQ.isEmpty());
        newQ.enqueue("one");
        newQ.enqueue("two");
        newQ.enqueue("three");
        newQ.enqueue("four");
        newQ.enqueue("five");
        newQ.dequeue();
        newQ.dequeue();
        newQ.enqueue("six");
        System.out.println(newQ.size());
        System.out.println(newQ.isEmpty());
    
    }
}
