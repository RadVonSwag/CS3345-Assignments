package Assignment_2;

public class TwoStackTest {
    public static void main(String[] args) {
        TwoStackImplementation<String> twoStacks = new TwoStackImplementation<String>(8);
        
        twoStacks.push2("raspberry");
        twoStacks.push2("cranberry");
        twoStacks.push2("blueberry");
        twoStacks.push2("blackberry");
        twoStacks.push2("grapefruit");
        System.out.println(twoStacks.top1());
        System.out.println(twoStacks.top2());
        System.out.println(twoStacks.size());
        
        twoStacks.push1("banana");
        twoStacks.push1("apple");
        twoStacks.push1("orange");
        twoStacks.push1("grape");
        twoStacks.push1("raspberry");
        twoStacks.push1("testberry");
        System.out.println(twoStacks.top1());
        System.out.println(twoStacks.top2());
        System.out.println(twoStacks.size());

        twoStacks.pop1();
        twoStacks.pop2();
        System.out.println(twoStacks.top1());
        System.out.println(twoStacks.top2());
        System.out.println(twoStacks.size());
        twoStacks.pop1();
        twoStacks.pop2();
        //System.out.println(twoStacks.toString());




    }
}
