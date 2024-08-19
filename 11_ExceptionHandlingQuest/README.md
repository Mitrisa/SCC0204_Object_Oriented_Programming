# Exception Handling Quest
## Objective:
Understand and apply Java exception handling techniques to prevent runtime errors in software applications.

## Background:
The presentation covers key concepts such as the difference between checked and unchecked exceptions, the use of try-catch blocks, and designing methods that throw exceptions.

## Assignment Details:
1. Setup:

- Each student will start with a base code (provided below) that simulates a simple bank account management system. The system currently lacks proper exception handling and contains several potential bugs due to unchecked exceptions.
2. Tasks:

- Part 1: Identify Potential Exceptions
   - Review the provided code and identify all points where exceptions might occur (e.g., null pointer access, array index out of bounds, arithmetic exceptions).
   - Document each potential exception with comments in the code.
- Part 2: Implement Exception Handling
   - Add appropriate try-catch blocks to handle the exceptions identified.
   - Ensure that the program can continue to run gracefully, even if an exception is encountered.
- Part 3: Throw Exceptions
   - Modify methods to throw custom exceptions when certain conditions are met (e.g., withdrawing more than the account balance).
   - Write custom exception classes as needed.
3. Challenge:

- Error Simulation: Introduce intentional bugs in your code for your peers to find and fix. Each student must swap their code with a peer and debug the issues using exception handling techniques.
4. Review:

- Each student presents their final code, discussing how they implemented exception handling and the rationale behind their choices in comments and JavaDocs. Discuss any interesting bugs found during the peer review phase.
## Base Code:
```
public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(100);
        myAccount.deposit(50);
        myAccount.withdraw(20);
        myAccount.displayBalance();
        myAccount.withdraw(200);
    }
}
```
