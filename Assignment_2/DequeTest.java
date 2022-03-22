package Assignment_2;

public class DequeTest {
    public static void main(String[] args) {
        Deque<String> newDeque = new Deque<String>();
        newDeque.push("10");
        newDeque.push("taco");
        newDeque.push("three");
        newDeque.pop();
        newDeque.inject("jocko");
        newDeque.inject("wonko");
        newDeque.inject("sponko");
        newDeque.eject();
    }
}
