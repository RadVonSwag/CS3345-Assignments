package Assignment_1;

import javax.lang.model.util.ElementScanner6;

public class Index {
    public static void main(String[] args) {
        int i = 8;
        int[] newArray = { 1, 2, 3, 4, 5, 6 };
        int[][] newMatrix = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 },
                { 19, 20, 21, 22, 23, 24 }, { 25, 26, 27, 28, 29, 30 }, { 31, 32, 33, 34, 35, 36 } };
        int low = 0;
        int high = newArray.length;
        // binarySearch(i, newArray, high, low);
        boolean contains = matrixSearch(newMatrix, 40);
        System.out.println(contains);
        boolean arrayContains = linearSearch(i, newArray);
        System.out.println(arrayContains);

    }

    /**
     * linearSearch takes an array and searches for a specified element in the array
     * and prints whether it is in the array or not.
     * 
     * @param i
     * @param newArray
     */
    public static boolean linearSearch(int i, int[] newArray) {
        for (int n = 0; n < newArray.length; n++) { //begin loop that increments n as it iterates through the elements
            if (newArray[n] == i) {
                return true; // return true if the element being searched for is the element at index n
            }
        }
        return false; //return false if element is not found in the array
    }

    /**
     * This binarySearch method is incomplete and does not work.
     * 
     * @param i
     * @param newArray
     * @param high
     * @param low
     */
    public static void binarySearch(int i, int[] newArray, int high, int low) {
        int mid = (low + high) / 2;
        if (newArray[mid] == i) {
            System.out.println(i + " is in the array.");
        } else if (newArray[mid] > i) {
            low = mid + 1;
            binarySearch(i, newArray, high, low);
        } else {
            high = mid - 1;
            binarySearch(i, newArray, high, low);
        }

    }

    /**
     * matrixSearch takes a matrix and an element to search for and searches the
     * matrix for the element in O(n) time.
     * 
     * @param matrix
     * @param X
     * @return true or false
     */
    public static boolean matrixSearch(int[][] matrix, int X) {

        int rowIndex = 0; // initiate row index
        int colIndex = matrix.length - 1; // initiate column index to be the at the top right of the matrix

        while (rowIndex < matrix.length && colIndex >= 0) { // begin while loop to search for element
            if (matrix[rowIndex][colIndex] == X) {
                return true; // return true if the current element is the one being searched for
            } else if (matrix[rowIndex][colIndex] > X) {
                colIndex--; // search the next column of the row if the above was not the element being
                            // searched for
            } else {
                rowIndex++; // begin searching the next row if element not found in current row
            }
        }
        return false; // return false if element was not found in the matrix
    }

}
