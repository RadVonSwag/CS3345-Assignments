package Assignment_2;

import java.util.LinkedList;

public class ReverseList {

    public static void main(String[] args) {
        LinkedList newList = new LinkedList();
        newList.add("one");
        newList.add("two");
        newList.add("three");
        newList.add("four");
        LinkedList reversedList = Reverse(newList);
    }

    public static LinkedList Reverse(LinkedList list) {
        int index = list.size() - 1;
        LinkedList reversedList = new LinkedList();
        while (index >= 0)
        {
            reversedList.add(list.get(index));
            index--;
        }
        return reversedList;
    }

}
