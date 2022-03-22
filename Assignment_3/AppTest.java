package Assignment_3;

import java.io.FileNotFoundException;

/**
 * Unit test for simple App.
 */
class AppTest {
    
       public static void main(String[] args) {
         TestInsertInt();  
       }

    public static void TestInsertInt() {
        ThreadedBinarySearchTree<Integer> test = new ThreadedBinarySearchTree<Integer>();
        test.insert(8);
        test.insert(8);
        test.insert(8);
        test.insert(6);
        test.insert(9);
        test.insert(2);
        test.insert(4);
        test.insert(12);
        test.insert(10);
        test.insert(11);
        test.insert(6);
        test.insert(4);
        test.insert(10);
        test.printInOrder();

    }

    void TestInsertString() {
        ThreadedBinarySearchTree<String> test = new ThreadedBinarySearchTree<String>();
        test.insert("Apples");
        test.insert("Bananas");
        test.insert("Cranberries");
        test.insert("Dragonfruit");
        test.insert("Apples 2");
    }

    void testSearch() {
        ThreadedBinarySearchTree<String> test = new ThreadedBinarySearchTree<String>();
        test.insert("Apples");
        test.insert("Bananas");
        test.insert("Cranberries");
        test.insert("Dragonfruit");
        test.insert("Apples 2");

        boolean actualResult1 = test.search("Apples 2");
        boolean actualResult2 = test.search("Grapefruits");
    }

    void testDelete() {
        ThreadedBinarySearchTree<Integer> test = new ThreadedBinarySearchTree<Integer>();
        test.insert(8);
        test.insert(6);
        test.insert(9);
        test.insert(2);
        test.insert(4);
        test.insert(12);
        test.insert(10);
        test.insert(11);
        test.insert(13);

        test.printInOrder();
        test.delete(15);

        System.out.println();
        test.printInOrder();

    }
}
