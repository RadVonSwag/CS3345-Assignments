package Assignment_2;

public class LinkedListLZTest {

    public static void main(String[] args) {

        LinkedListLZ<String> newList = new LinkedListLZ<String>();
        newList.Add("poop");
        newList.Add("pee");
        newList.Add("snot");
        newList.Add("sweat");
        newList.Add("Apple Juice");
        newList.Add("blood");
        newList.Add("tears");
        //newList.SetElement(4, "bile");
        System.out.println(newList.Contains("Apple Juice"));
        System.out.println(newList.Stringy());
        newList.lazyDelete(4);
        newList.Stringy();
        System.out.println(newList.Contains("Apple Juice"));
        newList.Insert(4, "Grape Juice");
        newList.lazyDelete(5);
        String testString = newList.Stringy();
        System.out.println(testString);
        System.out.println("I've made it!");
    }

}
