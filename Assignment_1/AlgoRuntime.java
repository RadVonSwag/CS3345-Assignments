package Assignment_1;

import java.util.Scanner;

/**
 * AlgoRuntime Class takes 6 different algorithms and prints the runtime for
 * each in nanoseconds.
 * 
 * Written by Andrew Estes 9-14-2021
 * Ver 1.0 
 */
public class AlgoRuntime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Initiate Scanner to accept input
        System.out.println("Waiting for Input:"); // Prompt user for input
        long n = input.nextLong(); // Accept input from the user as "long" currently no input validation
        System.out.println("---------------------------------------"); // Line to separate the user's input from the
                                                                       // results of the program

        // Print the runtime of each algorithm from Question 6 on its own line.
        algoOne(n);
        algoTwo(n);
        algoThree(n);
        algoFour(n);
        algoFive(n);
        algoSix(n);

        input.close(); // Close the Scanner object.
    }

    /**
     * algoOne prints the runtime for the first algorithm from Question 6 of
     * Assignment 1
     * 
     * @param n
     */
    public static void algoOne(long n) {
        long start = System.nanoTime(); // Take note of current system time and store it in "start"
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum++;
        long stop = System.nanoTime(); // Take note of current system time and store it in "stop"
        System.out.println(stop - start); // Subtract final time from start time and print result.
    }

    /**
     * algoTwo prints the runtime for the second algorithm from Question 6 of
     * Assignment 1
     * 
     * @param n
     */
    public static void algoTwo(long n) {
        long start = System.nanoTime(); // Take note of current system time and store it in "start"
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                sum++;
        long stop = System.nanoTime(); // Take note of current system time and store it in "stop"
        System.out.println(stop - start);
    }

    /**
     * algoThree prints the runtime for the third algorithm from Question 6 of
     * Assignment 1
     * 
     * @param n
     */
    public static void algoThree(long n) {
        long start = System.nanoTime(); // Take note of current system time and store it in "start"
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n * n; j++)
                sum++;
        long stop = System.nanoTime(); // Take note of current system time and store it in "stop"
        System.out.println(stop - start); // Subtract final time from start time and print result.
    }

    /**
     * algoFour prints the runtime for the fourth algorithm from Question 6 of
     * Assignment 1
     * 
     * @param n
     */
    public static void algoFour(long n) {
        long start = System.nanoTime(); // Take note of current system time and store it in "start"
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                sum++;
        long stop = System.nanoTime(); // Take note of current system time and store it in "stop"
        System.out.println(stop - start); // Subtract final time from start time and print result.
    }

    /**
     * algoFive prints the runtime for the fifth algorithm from Question 6 of
     * Assignment 1
     * 
     * @param n
     */
    public static void algoFive(long n) {
        long start = System.nanoTime(); // Take note of current system time and store it in "start"
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i * i; j++)
                for (int k = 0; k < j; k++)
                    sum++;
        long stop = System.nanoTime(); // Take note of current system time and store it in "stop"
        System.out.println(stop - start); // Subtract final time from start time and print result.
    }

    /**
     * algoSix prints the runtime for the sixth algorithm from Question 6 of
     * Assignment 1
     * 
     * @param n
     */
    public static void algoSix(long n) {
        long start = System.nanoTime(); // Take note of current system time and store it in "start"
        int sum = 0;
        for (int i = 1; i < n; i++)
            for (int j = 1; j < i * i; j++)
                if (j % i == 0)
                    for (int k = 0; k < j; k++)
                        sum++;
        long stop = System.nanoTime(); // Take note of current system time and store it in "stop"
        System.out.println(stop - start); // Subtract final time from start time and print result.
    }

}