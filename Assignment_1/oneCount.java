package Assignment_1;

public class oneCount {

    static int i = 0;
    static int totalOnes = 0;


    public static void main(String[] args) {

    }
    public static int oneCount(String binaryString) {
        i++;
        if (i >= binaryString.length()) {
            return totalOnes;
        }

        if (binaryString.charAt(i) == '1') {
            return totalOnes = oneCount(binaryString) + 1;
        } else {
            return totalOnes = oneCount(binaryString);
        }
    }

    public static int nCount(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            return nCount(n / 2) + nCount(n % 2);
        }
    }
}
