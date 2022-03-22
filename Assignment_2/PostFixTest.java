package Assignment_2;

import java.util.Scanner;

/**
 * The PostFixText class implements the PostFix class and demonstrates the capabilities of the "calculate function from a PostFix object"
 * @author Andrew Estes
 * @version 1.0
 * @date Tue. Sep. 28, 2021
 */
public class PostFixTest {
    public static void main(String[] args) {
        PostFix ps = new PostFix(); //create new PostFix object

        Scanner scanner = new Scanner(System.in); //create new Scanner to accept input
        String input = ""; //initialize input vairable
        
        //Main while loop that chekcs for q as input to exit program.
        while (!input.equalsIgnoreCase("q")) {
            System.out.println(
                    "Please input an expression in PostFix notation or type \"q\" to quit. Please separate your numbers and symbols with a space.\nExample input: \"5 2 + 8 3 - * 4 /\"");
            input = scanner.nextLine(); //accept input from user
            
            //break loop if input is q
            if (input.equalsIgnoreCase("q")) {
                continue;
            }

            Double result = ps.calculate(input); //perform the calculate function on the string of characters user input.
            System.out.println("Result: " + result +"\n"); //Print the result
        }
        scanner.close(); //close scanner object
        System.out.println("\nExiting Program...."); //Exit message
        System.exit(0); //Exit program

        
    }
}
