package Assignment_2;

/**
 * The PostFix class allows for input of an expression in PostFix notation. PostFix objects can perform the 
 * calculation of an expression in PostFix notation and return the result.
 * @author Andrew Estes
 * @version 1.0
 * @date Tue. Sep. 28, 2021
 */
public class PostFix {
    private String[] fullString; // array to hold all of the input
    private String[] Symbols; //array to hold elements in the stack
    private int top = -1; //top
    private Double result; //final result

    /**
     * default constructor
     */
    public PostFix() {
    }
    /**
     * calculate function takes the input as a string and separates it into parts in order to be operated on
     * @param input
     * @return
     */
    public Double calculate(String input) {
        
        if (!input.contains(" ")) //basic input validation. There are other cases where incorrect input could cause errors that are not accounted for (eg. invalid characters or 8*)
        {
            System.out.println("Error. Numbers and symbols must be separated by a space.");
            return null;
        }
        
        //Initialize all of the variables that will be needed to perform calculations
        int index = 0; //index
        Double sum; //for sums
        Double num1; //first number popped (when popped)
        Double num2; //second number popped (when popped)
        Double dif; //for differences
        Double prod; //for product
        Double quot; //for quotient

        fullString = input.split("\\s"); //Split the string input into an array using space as delimiter

        String symbol = fullString[index]; //set symbol to an element at index of fullString
        Symbols = new String[input.length()]; //Initialize Symbols array as stack to hold and perform calculations
        
        //main while loop to look at each symbol and operation
        while (index != fullString.length) {
           //switch structure to determine what operations need be done based on the symbol
            switch (symbol) {
                case "+":
                    num1 = Double.parseDouble(pop()); //pop stack and set num1 to value popped
                    num2 = Double.parseDouble(pop()); //pop stack and set num2 to value popped
                    sum = num1 + num2; //perform the appropriate operation
                    symbol = Double.toString(sum); //convert sum to string and set symbol equal to sum
                    break;

                case "-":
                    num1 = Double.parseDouble(pop()); //pop stack and set num1 to value popped
                    num2 = Double.parseDouble(pop()); //pop stack and set num2 to value popped
                    dif = num2 - num1; //perform the appropriate operation
                    symbol = Double.toString(dif); //convert dif to string and set symbol equal to dif
                    break;

                case "*":
                    num1 = Double.parseDouble(pop()); //pop stack and set num1 to value popped
                    num2 = Double.parseDouble(pop()); //pop stack and set num2 to value popped
                    prod = num1 * num2; //perform the appropriate operation
                    symbol = Double.toString(prod); //convert prod to string and set symbol equal to prod
                    break;

                case "/":
                    num1 = Double.parseDouble(pop()); //pop stack and set num1 to value popped
                    num2 = Double.parseDouble(pop()); //pop stack and set num2 to value popped
                    quot = num2 / num1; //perform the appropriate operation
                    symbol = Double.toString(quot); //convert quot to string and set symbol equal to quot
                    break;
            }

                push(symbol); //push the new symbol to the stack
            index++; //increment index
            
            //check if index is greater than the amount of elements in fullString, go to beginning of loop if so
            if (index >= fullString.length) {
                continue;
            }

            
            symbol = fullString[index]; //set symbol to element at index of fullString
        }


        result = Double.parseDouble(Symbols[top]);//set result to the value at the top of the stack once all values have operated on.
        return result;
    }
    /**
     * The push function will push a String element to the stack and adjust the top accordingly.
     * @param symbol
     */
    public void push(String symbol) {
        top++; //increment top index
        Symbols[top] = symbol; //input the new element at the new top index in Symbols
    }

    /**
     * The pop function will remove the string element at the top of the stack and return the value removed this way
     * @return
     */
    public String pop() {
        String removed = Symbols[top]; //save value that is being removed in removed
        Symbols[top] = null; //remove the value from the top
        top--; //decrement top index
        return removed;
    }

}
