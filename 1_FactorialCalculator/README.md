# Introduction to Java for C Programmers

## Objective:

The goal of this assignment is to familiarize you with Java programming by editing and compiling a simple Java program. This assignment will help you understand the similarities and differences between Java and C, focusing on basic syntax and features common to both languages, such as variable declarations, control flow statements, and functions.

## Task Description: 
You are provided with a basic Java program that calculates the factorial of a number using recursion and iteratively. Your task is to modify the program to include additional functionality as specified below, compile the program, and test it to ensure it runs correctly. You may use online java environments, such as replit.

## Provided Program FactorialCalculator.java:
```
public class FactorialCalculator {

// Recursive method to calculate factorial
  public static int factorialRecursive(int n) {
    if (n == 0) {
        return 1;
    }
    return n * factorialRecursive(n - 1);
}
// Iterative method to calculate factorial
  public static int factorialIterative(int n) {
    int result = 1;
    for (int i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
  }
  public static void main(String[] args) {
    int number = 5; // Example number for factorial calculation
    System.out.println("Factorial of " + number + " (Recursive): " + factorialRecursive(number));
    System.out.println("Factorial of " + number + " (Iterative): " + factorialIterative(number));
  }
}
```

## Modifications to Make:

- Input from User: 
Modify the program to accept an integer input from the user instead of using a hard-coded value. Use Scanner for input.

- Error Handling: Add error handling to ensure the program only accepts positive integers. Display an error message for invalid inputs.

- Additional Functionality: Add a function that calculates the sum of all integers from 1 to n (inclusive), where n is the input number. Implement this function iteratively. Modify the main method to call this new function and display its result.

## Steps to Follow: 
- Edit the Program: Make the required modifications in a text editor of your choice.

- Compile the Program: Open a terminal or command prompt. Navigate to the directory containing your modified FactorialCalculator.java. Compile the program using the javac compiler: javac FactorialCalculator.java. Ensure there are no compilation errors.

- Run the Program: Execute the compiled program using the java command: java FactorialCalculator.
- Test the program with various inputs to ensure it behaves as expected.
