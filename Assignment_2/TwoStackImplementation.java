package Assignment_2;

public class TwoStackImplementation<E extends Comparable<E>> {
    private E[] oneArray;
    private int top1;
    private int top2;
    private int size;

    public TwoStackImplementation(int size) {
        oneArray = (E[]) new Comparable[size];
        top1 = -1;
        top2 = oneArray.length;
        this.size = size;
    }

    public void push1(E element) {
        if (top1 < (size/2)-1) {
            top1++;
            oneArray[top1] = element;
        } else {
            System.out.println("Stack Overflow. Element could not be added to Stack 1.");
        }
    }

    public void push2(E element) {
        if (top2 > (size/2)) {
            top2--;
            oneArray[top2] = element;
        } else {
            System.out.println("Stack Overflow. Element could not be added to Stack 2.");
        }
    }

    public void pop1() {
        if (size == 0) {
            System.out.println("Stack 1 is empty.");
            return;
        } else {
            oneArray[top1] = null;
            top1--;
        }
    }

    public void pop2() {
        if (size == 0) {
            System.out.println("Stack 2 is empty");
            return;
        } else {
            oneArray[top2] = null;
            top2++;
        }
    }

    public E top1() {
        if (top1 < 0) {
            return null;
        } else {
            return oneArray[top1];
        }
    }

    public E top2() {
        if (top2 >= size) {
            return null;
        } else {
            return oneArray[top2];
        }
    }

    public int size() {
        return size;
    }

}
