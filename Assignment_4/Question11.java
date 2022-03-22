package Assignment_4;

public class Question11 {

    public static void main(String[] args) {
        boolean[] TFarray = { false, false, false, true, true, true };
        TFarray = TFKeySort(TFarray);

        String[] TFMarray = { "true", "false", "maybe", "true", "false", "maybe", "maybe", "true", "false" };
        TFMarray = TFMKeySort(TFMarray);
    }

    /**
     * TFKeySort sorts an array of elements consisting of the keys "true" or "false"
     * -- sorted such that "false" elements precede "true" elements
     * 
     * @param array
     * @return array
     */
    public static boolean[] TFKeySort(boolean[] array) {
        int i = 0; // initialize i to traverse starting at the beginning of the array
        int j = array.length - 1; // initialize j to traverse starting at the end of the array

        while (j > i) { // terminate the while loop when i and j meet in the array
            while (array[i] == false) // while loop to increment i as long as the element at index i == false
            {
                i++;
            }
            while (array[j] == true) // while loop to decrement j as long as the element at index j == true
            {
                j--;
            }
            if (i >= j) // break if i is greater than or equal to j
            {
                break;
            }
            boolean temp = array[i]; // store the element at index i in temp variable

            // perform swap of elements at index i and index j
            array[i] = array[j];
            array[j] = temp;

            // increment i and decrement j
            i++;
            j--;
        }
        return array; // return the sorted array when finished
    }

    /**
     * TFMKeySort sorts an array of elements consisting of the keys "true", "false",
     * or "maybe" -- sorted such that "false" elements precede "maybe" elements that
     * precede "true" elements
     * 
     * @param array
     * @return
     */
    public static String[] TFMKeySort(String[] array) {
        int i = 0; // initialize i to traverse starting at the beginning of the array
        int j = array.length - 1; // initialize j to traverse starting at the end of the array

        while (j > i) { // terminate the while loop when i and j meet in the array
            while (array[i] == "false") // while loop to increment i as long as the element at index i == false
            {
                i++;
            }
            while (array[j] == "true" || array[j] == "maybe") // while loop to decrement j as long as the element at
                                                              // index j == true or maybe
            {
                j--;
            }
            if (i >= j) // break if i is greater than or equal to j
            {
                break;
            }
            String temp = array[i]; // store the element at index i in temp variable

            // perform swap of elements at index i and index j
            array[i] = array[j];
            array[j] = temp;

            // increment i and decrement j
            i++;
            j--;
        }
        j = array.length - 1;
        while (j > i) { // terminate the while loop when i and j meet in the array
            while (array[i] == "maybe") // while loop to increment i as long as the element at index i == maybe
            {
                i++;
            }
            while (array[j] == "true") // while loop to decrement j as long as the element at index j == true
            {
                j--;
            }
            if (i >= j) // break if i is greater than or equal to j
            {
                break;
            }
            String temp = array[i]; // store the element at index i in temp variable

            // perform swap of elements at index i and index j
            array[i] = array[j];
            array[j] = temp;

            // increment i and decrement j
            i++;
            j--;
        }

        return array; // return the sorted array when finished
    }
}
