import java.util.Scanner;

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
  
   // Iterative method to calculate the sum of integers from 1 to n
   public static int sumOfIntegersIterative (int n){
       int sum = 0;
       for ( int i = 0; i <= n; i++){
           sum += i;
       }
       return sum;
   }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a positive integer for factorial calculation: ");
    int number = scanner.nextInt();
      
    if (number < 0)  {
        System.out.println("Error: Please enter a positive integer.");
    } else {
        System.out.println("Factorial of " + number + " (Recursive): " + factorialRecursive(number));
        System.out.println("Factorial of " + number + " (Iterative): " + factorialIterative(number));
        System.out.println("Sum of integers from 1 to " + number + ": " + sumOfIntegersIterative(number));
    }
    scanner.close();
  }
}
