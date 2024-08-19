# Implementing a Simple Two-Person Game in Java

## Objective:
To apply object-oriented programming concepts in Java to create a simple two-person game, reinforcing understanding of class definition, object instantiation, and basic input/output using the java.util.Scanner class.

## Background: 
Students have already been introduced to the basics of object-oriented programming and have knowledge of programming in C. This assignment leverages their understanding of programming concepts and applies them in a Java context, focusing on the use of objects, class definitions, and the java.util.Scanner for input.

## Instructions:

### Game Overview:

- Implement a simple number guessing game where one player (the computer) selects a number within a specified range (e.g., 1 to 100), and the other player (the user) tries to guess it based on feedback. Class Definition:

- Define a class named GuessingGame. Its variables have to represent the game status. Which variables are you going to use? What are their type? This class should contain methods to.

- set up the game: game.setup(...)

- accept user guesses: game.acceptGuess(...)

- provide feedback (higher, lower, or correct guess): game.feedback(...)

- count the number of guesses: game.countGuess(...)

- What parameters should these methods receive, if any. What values they should return, if any. The main method is the only thing that can be static.

## Main Method:

In your GuessingGame class, include a main method that instantiates a GuessingGame object and starts the game. The game should continue until the user guesses the correct number. User Input:

Use the java.util.Scanner class to read the user's guesses from the console.

## Feedback Mechanism:

After each guess, the program should provide feedback to the user if the guess is too high, too low, or correct.

## Ending the Game:

Once the user guesses the number correctly, display a congratulatory message including the number of attempts it took to guess the number correctly.
