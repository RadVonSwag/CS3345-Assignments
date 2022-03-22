package Assignment_1;

public class ArrayOperations {

    public static void main(String[] args) {
        int[] array = { 11, 2, 3, 4, 50, 6, 7, 90 };
        int sum = algoA(array);
        int difference = algoB(array);
        int product = algoC(array);
        int quotient = algoD(array);
        int diftest = algoTest(array);
    }

    /**
     * the maximum value of a[j]+a[i], with j ≥ i.
     * 
     * @param array
     * @return sum
     */
    public static int algoA(int a[]) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (sum < a[i] + a[j]) {
                    sum = a[i] + a[j];
                }
            }
        }
        return sum;
    }

    /**
     * the maximum value of a[j]-a[i], with j ≥ i
     * 
     * @param a
     * @return difference
     */
    public static int algoB(int a[]) {
        int difference = 0;
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length; i++) {
                if (difference < a[j] - a[i]) {
                    difference = a[j] - a[i];
                }
            }
        }
        return difference;
    }

    /**
     * the maximum value of a[j]*a[i], with j ≥ i.
     * @param a
     * @return
     */
    public static int algoC(int a[])
    {
        int product = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (product < a[i] * a[j]) {
                    product = a[i] * a[j];
                }
            }
        }
        return product;
    }

    /**
     * the maximum value of a[j]/a[i], with j ≥ i.
     * @param a
     * @return
     */
    public static int algoD(int a[]) {
        int quotient = 0;
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length; i++) {
                if (quotient < a[j] / a[i]) {
                    quotient = a[j] / a[i];
                }
            }
        }
        return quotient;
    }

    public static int algoTest(int a[]) {
        int difference = 0;
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length; i++) {
                if (difference < a[j] - a[i]) {
                    difference = a[j] - a[i];
                }
            }
        }
        return difference;
    }
}
